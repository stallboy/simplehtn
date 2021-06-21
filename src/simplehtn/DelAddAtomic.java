package simplehtn;

public class DelAddAtomic extends DelAddElement {

    private final Predicate atom;

    public DelAddAtomic(Predicate atomIn) {
        atom = atomIn;
    }


    @Override
    public void add(State s, Term[] binding, StateChanged changed) {
        Predicate p = atom.applySubstitution(binding);
        if (s.add(p))
            changed.add.add(p);
    }


    public boolean del(State s, Term[] binding, StateChanged changed) {
        Predicate p = atom.applySubstitution(binding);
        if (s.isProtected(p))
            return false;

        int index;
        if ((index = s.del(p)) != -1)
            //-- If the atom was really deleted from the current state of the world
            //-- (i.e., it was there before), add it to the list of deleted atoms
            //-- so that in case of a backtrack it can be added back. Also keep track
            //-- of where the atom was, so that it can be added back exactly where it
            //-- was. This is important because new bindings are calculated as they
            //-- are needed (as opposed to calculating all of them in advance and
            //-- returning them one-by-one), and therefore if a backtrack happens,
            //-- the data structures should look exactly as they were before the
            //-- backtracked decision (to apply the operator this atomic delete/add
            //-- element is associated with) was made.
            changed.del.add(new NumberedPredicate(p, index));

        return true;
    }

}
