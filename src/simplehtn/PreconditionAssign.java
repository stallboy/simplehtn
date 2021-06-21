package simplehtn;

/**
 * (assign VARID term)
 * 这个含义是 把当前term bind 到VARID上，返回只包含这一项的satisfier
 */
public class PreconditionAssign extends Precondition {
    private final Term term;
    private final DomainElement domainEle;
    private final int whichVar;
    private final String varName;

    private Term boundT;
    private Term[] satisfierRet;

    public PreconditionAssign(Term term, DomainElement domainEle, String varId) {
        setFirst(true); //assign只satisfy一次，用first来方便实现。

        this.term = term;
        this.domainEle = domainEle;
        this.varName = varId;
        this.whichVar = domainEle.varSymbols.get(varId);
    }

    @Override
    public Precondition setUnifier(Term[] unifier) {
        Term unifiedT = term.bind(unifier);
        PreconditionAssign res = new PreconditionAssign(unifiedT, domainEle, varName);
        res.satisfierRet = new Term[unifier.length];
        return res;
    }

    @Override
    protected void resetNextSatisfierHelper(State state, Term[] binding) {
        if (binding == null) {
            boundT = term;
        } else {
            boundT = term.bind(binding);
        }
    }

    @Override
    protected Term[] nextSatisfierHelper(State state) {
        //-- Assign the variable to what it is supposed to be assigned to.
        satisfierRet[whichVar] = boundT;
        return satisfierRet;
    }

    @Override
    public String toString() {
        return String.format("(assign %s %s)", varName, term);
    }

}
