package simplehtn;

/**
 * (forall pre=lexp atoms=latomlist ),
 */
public class DelAddForAll extends DelAddElement {
    private final Precondition pre;
    private final Predicate[] atoms;

    public DelAddForAll(Precondition pre, Predicate[] atoms) {
        this.pre = pre;
        this.atoms = atoms;
    }

    @Override
    public void add(State s, Term[] binding, StateChanged changed) {
        Term[] nextB;
        pre.resetNextSatisfier(s, binding);
        while ((nextB = pre.nextSatisfier(s)) != null) {
            Term.merge(nextB, binding);
            for (Predicate atom : atoms) {
                Predicate p = atom.applySubstitution(nextB);

                if (s.add(p))
                    changed.add.add(p);
            }
        }
    }

    @Override
    public boolean del(State s, Term[] binding, StateChanged changed) {
        Term[] nextB;
        pre.resetNextSatisfier(s, binding);
        while ((nextB = pre.nextSatisfier(s)) != null) {
            Term.merge(nextB, binding);
            for (Predicate atom : atoms) {
                Predicate p = atom.applySubstitution(nextB);
                if (s.isProtected(p))
                    return false;
                int index;
                if ((index = s.del(p)) != -1)
                    changed.del.add(new NumberedPredicate(p, index));
            }
        }
        return true;
    }


}
