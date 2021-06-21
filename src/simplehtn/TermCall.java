package simplehtn;


public class TermCall extends Term {
    private final TList args;
    private final Calculate calculate;
    private final String func;

    public TermCall(TList args, Calculate calculate, String func) {
        this.args = args;
        this.calculate = calculate;
        this.func = func;
    }

    @Override
    public Term bind(Term[] binding) {
        TList boundArgs = args.bindList(binding);

        if (boundArgs.isGroundList()) {
            return calculate.call(boundArgs);
        } else {
            return new TermCall(boundArgs, calculate, func);
        }
    }

    @Override
    public boolean findUnifier(Term t, Term[] binding) {
        return calculate.call(args).findUnifier(t, binding);
    }


    @Override
    public boolean equals(Term t) {
        return calculate.call(args).equals(t);
    }


    @Override
    public boolean isGround() {
        return args.isGroundList();
    }


    @Override
    public String toString() {
        return "(call " + func + " " + args.toString() + ")";
    }
}
