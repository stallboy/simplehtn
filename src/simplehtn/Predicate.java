package simplehtn;


/**
 * latom : ( ID terml ) | VARID
 * 核心是  applySubstitution(binding)得到新predicate
 * 和 findUnifier(t)返回unifier
 */
public class Predicate {
    private final int head;
    private final String name;
    private final Term param;

    /**
     * 这里是整个DomainElement 或Problem的VarCount，这样方便使用统一大小的Term[]来表示binding
     */
    private int varCount;

    /**
     * -1表示，不是VAR，否则表示VAR
     */
    private final int varIdx;


    public static Predicate of(DomainElement ele, String id, Term param) {
        return new Predicate(ele.domain.constSymbols.get(id), id, ele.varSymbols.size(), param);
    }

    public static Predicate of(Problem prob, String id, Term param) {
        return new Predicate(prob.constSymbols.get(id), id, prob.varSymbols.size(), param);
    }

    public static Predicate ofVar(DomainElement ele, String varId) {
        return new Predicate(ele.varSymbols.get(varId), varId, ele.varSymbols.size());
    }

    public static Predicate ofPrimitiveTask(DomainElement ele, String id, Term param) {
        return new Predicate(ele.domain.primitiveTaskSymbols.get(id), id, ele.varSymbols.size(), param);
    }

    public static Predicate ofPrimitiveTask(Problem prob, String id, Term param) {
        return new Predicate(prob.domain.primitiveTaskSymbols.get(id), id, prob.varSymbols.size(), param);
    }

    public static Predicate ofCompoundTask(DomainElement ele, String id, Term param) {
        return new Predicate(ele.domain.compoundTaskSymbols.get(id), id, ele.varSymbols.size(), param);
    }

    public static Predicate ofCompoundTask(Problem prob, String id, Term param) {
        return new Predicate(prob.domain.compoundTaskSymbols.get(id), id, prob.varSymbols.size(), param);
    }


    Predicate(int head, String headName, int varCount, Term param) {
        this.head = head;
        this.name = headName;
        this.varCount = varCount;
        this.param = param;
        varIdx = -1;
    }


    private Predicate(int varIdx, String varName, int varCount) {
        head = -1;
        param = TermList.NIL;
        this.varIdx = varIdx;
        this.name = varName;
        this.varCount = varCount;
    }

    /**
     * To apply a binding to this predicate.
     *
     * @param bindings the binding to be applied.
     * @return the resulting predicate.
     */
    public Predicate applySubstitution(Term[] bindings) {
        //-- If this predicate is a variable symbol,
        if (isVar()) {
            //-- If the variable symbol is not bound to anything, just return this
            //-- predicate itself.
            if (bindings[varIdx] == null)
                return this;

            //-- Find out the list this variable symbol is mapped to and make up the
            //-- predicate out of that list.
            return ((TermList) bindings[varIdx]).toPredicate(varCount);
        }

        //-- Apply the binding and return the result.
        return new Predicate(head, name, varCount, param.bind(bindings));
    }

    /**
     * To find a unifier that unifies the argument list of another predicate
     * with the argument list of this predicate.
     *
     * @param t the argument list of the other predicate.
     * @return the binding that unifies the two argument lists in case they are
     * unifiable, <code>null</code> otherwise.
     */
    public Term[] findUnifier(Term t) {
        //-- First, make an empty binding of the appropriate size.
        Term[] retVal = new Term[varCount];

        //-- If this predicate is a variable, just map the variable to the whole
        //-- argument list and return.
        if (isVar()) {
            retVal[varIdx] = t;  // 很微妙！
            return retVal;
        }

        if (param.findUnifier(t, retVal))
            return retVal;

        return null;
    }


    public boolean equals(Term t) {
        if (isVar())
            return false;

        return (param.equals(t));
    }


    public int getHead() {
        return head;
    }

    public Term getParam() {
        return param;
    }

    public int getVarCount() {
        return varCount;
    }

    public String getName() {
        return name;
    }

    public boolean isGround() {
        if (isVar())
            return false;

        return param.isGround();
    }

    public boolean isVar() {
        return (varIdx != -1);
    }


    public void setVarCount(int varCountIn) {
        varCount = varCountIn;
    }


    public String toString() {
        if (isVar()) {
            return name;
        }

        String s = "(" + name;
        if (param instanceof TermList)
            if (param.isNil())
                //-- Converting (a . NIL) to (a).
                return s + ")";
            else
                //-- Converting (a . (b)) to (a b).
                return s + " " + ((TermList) param).getList() + ")";
            //-- If the argument list is not a list term (which should not happen
            //-- usually, but there is no reason to assume that it will not happen.
        else
            return s + "." + param + ")";
    }

}
