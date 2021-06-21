package simplehtn;

/**
 * 这个的含义是 如果任何binding能满足p，则不通过。
 * 否则就通过，空satisfier。
 */
public class PreconditionNot extends Precondition {
    private final Precondition p;
    private Term[] satisfierRet;

    public PreconditionNot(Precondition p) {
        setFirst(true);
        this.p = p;
    }

    @Override
    public Precondition setUnifier(Term[] unifier) {
        Precondition unifiedP = p.setUnifier(unifier);
        PreconditionNot res = new PreconditionNot(unifiedP);
        res.satisfierRet = new Term[unifier.length];
        return res;
    }

    @Override
    protected void resetNextSatisfierHelper(State state, Term[] binding) {
        p.resetNextSatisfier(state, binding);
    }

    @Override
    protected Term[] nextSatisfierHelper(State state) {
        //-- If the logical expression the negation of which this object represents
        //-- can be satisfied, return null, otherwise return an empty binding.
        if (p.nextSatisfier(state) != null)
            return null;
        else
            return satisfierRet;
    }

    @Override
    public String toString() {
        return String.format("(not %s)", p);
    }
}
