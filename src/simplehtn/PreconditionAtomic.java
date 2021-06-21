package simplehtn;


/**
 * 这个的含义是要寻找  符合当前state  的 satisfier（binding）
 */
public class PreconditionAtomic extends Precondition {
    private final Predicate p;

    private Predicate boundP;
    private MyIterator e;

    public PreconditionAtomic(Predicate p) {
        setFirst(false);
        this.p = p;
    }

    @Override
    public Precondition setUnifier(Term[] unifier) {
        Predicate unifiedP = p.applySubstitution(unifier);
        return new PreconditionAtomic(unifiedP);
    }

    @Override
    protected void resetNextSatisfierHelper(State state, Term[] binding) {
        e = state.iterator(p.getHead());
        if (binding == null) {
            boundP = p;
        } else {
            boundP = p.applySubstitution(binding);
        }
    }

    @Override
    protected Term[] nextSatisfierHelper(State state) {
        return state.nextSatisfier(boundP, e);
    }

    @Override
    public String toString() {
        return p.toString();
    }
}
