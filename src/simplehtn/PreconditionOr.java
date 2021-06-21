package simplehtn;

public class PreconditionOr extends Precondition {
    private final Precondition[] elements;
    private int whichClause;

    public PreconditionOr(Precondition[] elements) {
        setFirst(false);
        this.elements = elements;
        if (elements.length < 2) {
            throw new IllegalArgumentException("PreconditionOr的元素小于2个时应该在上层直接优化");
        }
    }

    @Override
    public Precondition setUnifier(Term[] unifier) {
        Precondition[] unifiedEles = new Precondition[elements.length];
        int i = 0;
        for (Precondition ele : elements) {
            unifiedEles[i] = ele.setUnifier(unifier);
            i++;
        }
        return new PreconditionOr(unifiedEles);
    }

    @Override
    protected void resetNextSatisfierHelper(State state, Term[] binding) {
        for (Precondition ele : elements) {
            ele.resetNextSatisfier(state, binding);
        }
        whichClause = 0;
    }

    @Override
    protected Term[] nextSatisfierHelper(State state) {
        while (whichClause < elements.length) {
            Term[] satisfier = elements[whichClause].nextSatisfier(state);
            if (satisfier != null) {
                return satisfier;
            }
            whichClause++;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(or ");
        for (Precondition element : elements) {
            sb.append(element).append(" ");
        }
        sb.append(")");
        return sb.toString();
    }
}
