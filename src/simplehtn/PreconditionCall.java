package simplehtn;

/**
 * 这个的含义是 函数调用后返回值为nil 就不通过。
 * 否则通过，空satisfier
 */
public class PreconditionCall extends Precondition {
    private final Term term;

    private Term boundT;
    private Term[] satisfierRet;

    public PreconditionCall(Term term) {
        setFirst(true); //call只能匹配一次
        this.term = term;
    }

    @Override
    public Precondition setUnifier(Term[] unifier) {
        Term unifiedT = term.bind(unifier);  // 这个可能会触发 函数调用
        PreconditionCall res = new PreconditionCall(unifiedT);
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
        //-- This behavior is inherited from LISP. A NIL object represents a
        //-- logical falsehood, while everything else represnts true.
        if (boundT.isNil())
            return null;

        return satisfierRet;
    }

    @Override
    public String toString() {
        return term.toString();
    }
}
