package simplehtn;


public class TermList extends Term {
    private final TList list;

    public static TermList NIL = new TermList(null);

    public TermList(TList list) {
        this.list = list;
    }

    public TList getList() {
        return list;
    }


    public Predicate toPredicate(int varCount) {
        TermConstant c = (TermConstant) list.getHead();
        return new Predicate(c.index(), c.name(), varCount, list.getTail());
    }

    @Override
    public Term bind(Term[] binding) {
        if (list != null)
            return new TermList(list.bindList(binding));
        else
            return NIL;
    }

    @Override
    public boolean findUnifier(Term t, Term[] binding) {
        //-- If 't' is a variable symbol, ignore it.
        if (t instanceof TermVariable)
            return true;

        //-- If 't' is not a list, it can not be unified with this term.
        if (!(t instanceof TermList))
            return false;

        //-- If this list represents NIL, the only way to unify 't' with it would
        //-- be for 't' to represent NIL too.
        if (list == null)
            return (((TermList) t).list == null);

        //-- Unify the lists.
        return list.findUnifierList(((TermList) t).list, binding);
    }

    @Override
    public boolean equals(Term t) {
        //-- 't' is not a list.
        if (!(t instanceof TermList))
            return false;

        //-- Both terms are representing NIL, so they are equal.
        if (list == null && ((TermList) t).list == null)
            return true;

        //-- Only one of the terms represents NIL, so they are not equal.
        if (list == null || ((TermList) t).list == null)
            return false;

        //-- Compare the lists.
        return (list.equals(((TermList) t).list));
    }

    @Override
    public boolean isGround() {
        return (list == null || list.isGroundList());
    }

    @Override
    public String toString() {
        if (list == null)
            return "nil";

        return "(" + list.toString() + ")";
    }

    @Override
    String toUnpairString() {
        return list.toString();
    }
}
