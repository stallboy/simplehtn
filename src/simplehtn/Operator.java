package simplehtn;

import java.util.Set;


public class Operator extends DomainElement {
    Precondition pre;
    DelAdd add;
    DelAdd del;
    Term cost;

    public Operator(Domain domain, Set<String> vars) {
        super(domain, vars);
    }

    public boolean apply(Term[] binding, State s, StateChanged changed) {
        if (del.varIdx != -1) {
            TList l = ((TermList) binding[del.varIdx]).getList();

            while (l != null) {
                Predicate p = ((TermList) l.getHead()).toPredicate(0);
                if (s.isProtected(p))
                    return false;

                int index;
                if ((index = s.del(p)) != -1) {
                    changed.del.add(new NumberedPredicate(p, index));
                }

                l = l.getRest();
            }
        } else {
            for (DelAddElement ele : del.elements) {
                if (!ele.del(s, binding, changed)) {
                    return false;
                }
            }
        }

        if (add.varIdx != -1) {
            TList l = ((TermList) binding[add.varIdx]).getList();
            while (l != null) {
                Predicate p = ((TermList) l.getHead()).toPredicate(0);
                if (s.add(p)) {
                    changed.add.add(p);
                }
                l = l.getRest();
            }
        } else {
            for (DelAddElement ele : add.elements) {
                ele.add(s, binding, changed);
            }
        }

        return true;
    }


    public double getCost(Term[] binding) {
        return ((TermNumber) cost.bind(binding)).getNumber();
    }

}
