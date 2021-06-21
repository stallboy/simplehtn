package simplehtn;


public class TermNumber extends Term {

    private final double number;

    public TermNumber(double numberIn) {
        number = numberIn;
    }

    public double getNumber() {
        return number;
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
        return t instanceof TermNumber tc && tc.number == number;
    }

    @Override
    public boolean isGround() {
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
