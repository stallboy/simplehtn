package simplehtn;

public class TermVariable extends Term {
    private final int index;
    private final String name;

    public static TermVariable of(DomainElement ele, String id) {
        return new TermVariable(ele.varSymbols.get(id), id);
    }

    public static TermVariable of(Problem prob, String id) {
        return new TermVariable(prob.varSymbols.get(id), id);
    }

    private TermVariable(int idx, String name) {
        index = idx;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Term bind(Term[] binding) {
        Term b = binding[index];
        if (b != null)
            return b;
        else
            return this;
    }

    @Override
    public boolean findUnifier(Term t, Term[] binding) {
        //-- If 't' is a variable symbol, skip it.
        if (t instanceof TermVariable)
            return true;

        Term b = binding[index];
        if (b == null) {
            //-- If the variable has not already been mapped to something, map it:
            binding[index] = t;
            return true;
        } else {
            //-- If the variable has already been mapped to something, check if it is
            //-- unified with the same thing again.
            return t.equals(b);
        }
    }


    @Override
    public boolean equals(Term t) {
        return false;
    }

    @Override
    public boolean isGround() {
        return false;
    }

    @Override
    public String toString() {
        return name;
    }


}
