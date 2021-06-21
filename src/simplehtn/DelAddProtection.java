package simplehtn;

public class DelAddProtection extends DelAddElement {
    private final Predicate atom;

    public DelAddProtection(Predicate atomIn) {
        atom = atomIn;
    }

    @Override
    public void add(State s, Term[] binding, StateChanged changed) {
        Predicate p = atom.applySubstitution(binding);
        s.addProtection(p);
        changed.protectionAdd.add(p);
    }

    @Override
    public boolean del(State s, Term[] binding, StateChanged changed) {
        Predicate p = atom.applySubstitution(binding);

        if (s.delProtection(p))
            changed.protectionDel.add(p);
        return true;
    }
}
