package simplehtn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A state is a list of ground atoms intended to represent some state of the world.
 * A logical expression L is a consequent of a state S and an axiom list X if one
 * of the following is true:
 * 之后的说明，请参考pdf
 */
public class State {
    /**
     * 第一层index是predicate的 constant symbol的序号，
     * 之后的列表是关于这个predicate的参数列表，这里都是ground的
     */
    private final List<List<Term>> atoms;
    private final List<String> constSymbols;

    /**
     * 当前如果有(:protection a)状态，下一个action不能选择 del effect里包含a 的operator
     * 第一层index是constant symbol的序号，
     * 第二层是predicate.注意这里有引用计数
     */
    private final List<List<NumberedPredicate>> protections;

    /**
     * 第一层index是constant symbol的序号，
     * 第二层是相同常量符号 axiom 的定义，axiom可以定义多次
     */
    private final List<List<Axiom>> axioms;


    public State(Problem problem) {
        int constantSize = problem.domain.constSymbols.size();

        atoms = new ArrayList<>(constantSize);
        protections = new ArrayList<>(constantSize);
        constSymbols = new ArrayList<>(constantSize);
        for (int i = 0; i < constantSize; i++) {
            atoms.add(new ArrayList<>());
            protections.add(new ArrayList<>());
        }
        // 依赖于constSymbol是LinkedHashMap，有序
        constSymbols.addAll(problem.domain.constSymbols.keySet());

        this.axioms = problem.domain.axioms;

        for (Predicate p : problem.state) {
            if (p.getHead() < constantSize) {
                add(p);
            } else {
                System.out.println("忽略问题状态里不相关的项 " + p);
            }
        }
    }


    public boolean add(Predicate p) {
        var terms = atoms.get(p.getHead());
        for (Term t : terms) {
            if (p.equals(t))
                return false;
        }

        terms.add(p.getParam());
        return true;
    }


    public void addProtection(Predicate p) {
        var nps = protections.get(p.getHead());
        for (NumberedPredicate np : nps) {
            if (p.equals(np.getParam())) {
                np.inc();
                return;
            }
        }

        nps.add(new NumberedPredicate(p));
    }

    public int del(Predicate p) {
        List<Term> vec = atoms.get(p.getHead());

        for (int i = 0; i < vec.size(); i++) {
            Term t = vec.get(i);

            if (p.equals(t)) {
                vec.remove(i);
                return i;
            }
        }
        return -1;
    }


    public boolean delProtection(Predicate p) {
        NumberedPredicate np;
        Iterator<NumberedPredicate> e = protections.get(p.getHead()).iterator();

        while (e.hasNext()) {
            np = e.next();
            if (p.equals(np.getParam())) {
                if (!np.dec())
                    e.remove();

                return true;
            }
        }
        return false;
    }


    public boolean isProtected(Predicate p) {
        for (NumberedPredicate np : protections.get(p.getHead())) {
            if (p.equals(np.getParam()))
                return true;
        }
        return false;
    }

    public MyIterator iterator(int head) {
        return new MyIterator(atoms.get(head));
    }

    /**
     * 返回下一个满足当前state的satisfier
     */
    public Term[] nextSatisfier(Predicate p, MyIterator me) {
        Term[] nextB;
        Term[] retVal;

        //-- If we are still looking into the atoms to prove the predicate (i.e.,
        //-- we have not started looking into the axioms),
        if (me.whichAxiom == -1) {
            //-- Iterate over the appropriate Vector to find atoms that can satisfy
            //-- the given predicate.
            while (me.index < me.vec.size()) {
                Term t = me.vec.get(me.index++);
                // 比如p 是个(block ?x)
                retVal = p.findUnifier(t);

                //-- If this atom can satisfy the given predicate, return the binding
                //-- that unifies the two.
                if (retVal != null)
                    return retVal;
            }

            //-- We have already looked at all the atoms that could possibly satisfy
            //-- the predicate. From now on, we will look at the axioms only.
            me.whichAxiom = 0;
        }

        while (true) {
            //-- If we need to look at a new axiom,
            while (me.ax == null) {
                if (p.getHead() >= axioms.size()) {
                    return null;
                }

                //-- If there are no more axioms to be looked at, return null.
                if (me.whichAxiom == axioms.get(p.getHead()).size()) {
                    return null;
                }

                // 这里 发现这个p是axiom
                //-- Try the next axiom whose head matches the head of the given
                //-- predicate.
                me.ax = axioms.get(p.getHead()).get(me.whichAxiom++);

                // 例如 me.ax 为 (need-to-move ?x)，先找到unifier
                //-- Try to unify the axiom's head with the predicate.
                me.binding = me.ax.unify(p);

                //-- If the two can not be unified,
                if (me.binding == null)
                    //-- Try to look for the next axiom.
                    me.ax = null;
                else {
                    //-- Start with the first branch of this axiom.
                    me.index = 0;
                    //-- No branch has been satisfied yet, so set this variable to false.
                    me.found = false;
                }
            }

            // 再找axiom的branch
            //-- Iterate on all the branches of this axiom.
            for (; me.index < me.ax.subs.length; me.index++) {
                //-- If this is the first time this branch is considered, get the
                //-- iterator for the precondition of this branch.
                if (me.pre == null) {
                    me.pre = me.ax.subs[me.index].pre.setUnifier(me.binding);
                    me.pre.resetNextSatisfier(this, null);
                }

                // 例如 me.pre为 ((on-table ?x) (goal (on ?x ?z)))
                // 再来找符合这个branch的satisfier
                //-- Try the next satisfier for the precondition of this branch of this
                //-- axiom. If there is a next satisfier,
                while ((nextB = me.pre.nextSatisfier(this)) != null) {
                    //-- Merge the two bindings.
                    Term.merge(nextB, me.binding);

                    //-- Calculate the instance of the axiom we are using.
                    Predicate groundAxiomHead = me.ax.getHead().applySubstitution(nextB);

                    //-- Try to unify the axiom and the predicate.
                    retVal = p.findUnifier(groundAxiomHead.getParam());

                    //-- If there is such unifier, return it.
                    if (retVal != null) {
                        //-- The further branches of this axiom must NOT be considered even
                        //-- if this branch fails because there has been at least one
                        //-- satisfier for this branch of the axiom. Set this variable to
                        //-- true to prevent the further branches of this axiom from being
                        //-- considered.
                        me.found = true;

                        return retVal;
                    }
                }

                //-- Try the next branch of this axiom.
                me.pre = null;

                //-- According to the semantics of the axiom branches in JSHOP2, second
                //-- branch is considered only when there is no binding for the first
                //-- branch, the third branch is considered only when there is no
                //-- binding for the first and second branches, etc. Therefore, if one
                //-- of the branches of this axiom has already returned a satisfier,
                //-- the other branches should be ignored.
                if (me.found)
                    break;
            }

            //-- Try the next axiom.
            me.ax = null;
        }
    }


    public void undo(StateChanged changed) {
        //-- Since when an operator is applied, first the predicates in its delete
        //-- list are deleted and then the predicates in its add list are added,
        //-- when that application is undone, first the added predicates should be
        //-- deleted and then the deleted predicates should be added.

        //-- Deleting the added predicates.
        for (Predicate add : changed.add) {
            del(add);
        }
        //-- Adding the deleted predicates, exactly where they were deleted from.
        for (int i = changed.del.size() - 1; i >= 0; i--) {
            NumberedPredicate del = changed.del.get(i);
            atoms.get(del.getHead()).add(del.getNumber(), del.getParam());
        }

        //-- Deleting the added protections.
        for (Predicate pAdd : changed.protectionAdd) {
            delProtection(pAdd);
        }

        //-- Adding the deleted protections.
        for (Predicate pDel : changed.protectionDel) {
            addProtection(pDel);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (List<Term> atomList : atoms) {
            String id = constSymbols.get(i);
            for (Term oneAtomParam : atomList) {
                sb.append("(").append(id);
                sb.append(" ").append(oneAtomParam.toUnpairString());
                sb.append(")\n");
            }
            i++;
        }

        for (List<NumberedPredicate> protection : protections) {
            for (NumberedPredicate np : protection) {
                sb.append("(:protection ").append(np.getPredicate().getName());
                sb.append(" ").append(np.getPredicate().getParam().toUnpairString());
                sb.append(")");
                if (np.getNumber() > 1) {
                    sb.append(" ").append(np.getNumber());
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
