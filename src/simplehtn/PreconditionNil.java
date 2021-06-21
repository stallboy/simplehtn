package simplehtn;

/**
 * 空前置条件，返回成功，空satisfier
 */
public class PreconditionNil extends Precondition {
    private Term[] satisfierRet;

    public PreconditionNil() {
        setFirst(true);
    }

    @Override
    public Precondition setUnifier(Term[] unifier) {
        PreconditionNil res = new PreconditionNil();
        res.satisfierRet = new Term[unifier.length];
        return res;
    }

    @Override
    protected void resetNextSatisfierHelper(State state, Term[] binding) {
    }

    @Override
    protected Term[] nextSatisfierHelper(State state) {
        return satisfierRet;
    }

    @Override
    public String toString() {
        return "nil";
    }
}
