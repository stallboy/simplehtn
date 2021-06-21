package simplehtn;

import java.util.Arrays;

/**
 * ( forall premise=lexp consequence=lexp )
 * 对任意的x in premise(x)成立，都存在y，consequence(x,y)成立。
 * 具体含义为： 如果 对premise的每一个satisfier，consequence都要有binding能satisfy 当前state，则返回成功，空binding
 * 否则就返回失败，null
 */
public class PreconditionForAll extends Precondition {
    private final Precondition premise;
    private final Precondition consequence;

    private Term[] currentBinding;
    private Term[] satisfierRet;


    public PreconditionForAll(Precondition premise, Precondition consequence) {
        setFirst(true); //只返回一次
        this.premise = premise;
        this.consequence = consequence;
    }

    @Override
    public Precondition setUnifier(Term[] unifier) {
        Precondition pre = premise.setUnifier(unifier);
        Precondition cons = consequence.setUnifier(unifier);
        PreconditionForAll res = new PreconditionForAll(pre, cons);
        res.currentBinding = new Term[unifier.length];
        res.satisfierRet = new Term[unifier.length];
        return res;
    }

    @Override
    protected void resetNextSatisfierHelper(State state, Term[] binding) {
        premise.resetNextSatisfier(state, binding);
        Arrays.fill(currentBinding, null);
        if (binding != null) {
            Term.mergeIfAbsent(currentBinding, binding);
        }
    }

    @Override
    protected Term[] nextSatisfierHelper(State state) {
        Term[] satisfier;

        while ((satisfier = premise.nextSatisfier(state)) != null) {
            Term.mergeIfAbsent(satisfier, currentBinding);
            consequence.resetNextSatisfier(state, satisfier);
            if (consequence.nextSatisfier(state) == null) {
                //-- If not, return null, meaning that the ForAll logical expression
                //-- does not hold.
                return null;
            }
        }

        //-- Return the empty binding, meaning that the ForAll logical expression
        //-- holds.
        return satisfierRet;
    }

    @Override
    public String toString() {
        return String.format("(forall %s %s)", premise, consequence);
    }

}
