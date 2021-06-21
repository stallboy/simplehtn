package simplehtn;


public class TermConstant extends Term {
    private final int index;
    private final String name;

    public static TermConstant of(Domain domain, String id) {
        return new TermConstant(domain.constSymbols.get(id), id);
    }

    public static TermConstant of(Problem problem, String id) {
        return new TermConstant(problem.constSymbols.get(id), id);
    }

    private TermConstant(int idx, String name) {
        this.index = idx;
        this.name = name;
    }

    public int index() {
        return index;
    }

    public String name() {
        return name;
    }

    @Override
    public Term bind(Term[] binding) {
        return this;
    }

    @Override
    public boolean findUnifier(Term t, Term[] binding) {
        return ((t instanceof TermVariable) || equals(t));
    }


    @Override
    public boolean equals(Term t) {
        return t instanceof TermConstant tc && tc.index == index;
    }

    @Override
    public boolean isGround() {
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
