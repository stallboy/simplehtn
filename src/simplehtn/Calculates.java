package simplehtn;


public class Calculates {

    public static Div div = new Div();

    public static Equal equal = new Equal();

    public static Less less = new Less();

    public static LessEq lessEq = new LessEq();

    public static Member member = new Member();

    public static Minus minus = new Minus();

    public static More more = new More();

    public static MoreEq moreEq = new MoreEq();

    public static Mult mult = new Mult();

    public static NotEq notEq = new NotEq();

    public static Plus plus = new Plus();

    public static Power power = new Power();

    /**
     * Each code call of the form <code>(call / &#46;&#46;&#46;)</code> is
     * implemented by an object of this class.
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class Div implements Calculate {
        /**
         * This function executes the code call and returns the result by dividing
         * the first argument by the second one, the result of that division by the
         * third argument, and so on.
         */
        public Term call(TList l) {
            double res = ((TermNumber) l.getHead()).getNumber();
            l = l.getRest();

            while (l != null) {
                res /= ((TermNumber) l.getHead()).getNumber();
                l = l.getRest();
            }

            return new TermNumber(res);
        }
    }

    /**
     * Each code call of the form <code>(call = &#46;&#46;&#46;)</code> is
     * implemented by an object of this class.
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class Equal implements Calculate {
        /**
         * This function executes the code call and returns <code>NIL</code> if not
         * all of its (possibly several) arguments are equal, and something other
         * than <code>NIL</code> otherwise.
         */
        public Term call(TList l) {
            Term t1;
            Term t2;

            t1 = l.getHead();
            l = l.getRest();

            while (l != null) {
                t2 = l.getHead();
                if (!t1.equals(t2))
                    return TermList.NIL;
                l = l.getRest();
                t1 = t2;
            }

            return new TermNumber(1.0);
        }
    }

    /**
     * Each code call of the form <code>(call &#60; &#46;&#46;&#46;)</code> is
     * implemented by an object of this class
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class Less implements Calculate {
        /**
         * This function executes the code call and returns something other than
         * <code>NIL</code> if and only if each argument in its argument list is
         * less than the next argument.
         */
        public Term call(TList l) {
            TermNumber t1;
            TermNumber t2;

            t1 = (TermNumber) l.getHead();
            l = l.getRest();

            while (l != null) {
                t2 = (TermNumber) l.getHead();
                if (t1.getNumber() >= t2.getNumber())
                    return TermList.NIL;
                l = l.getRest();
                t1 = t2;
            }

            return new TermNumber(1.0);
        }
    }

    /**
     * Each code call of the form <code>(call &#60;= &#46;&#46;&#46;)</code> is
     * implemented by an object of this class
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class LessEq implements Calculate {
        /**
         * This function executes the code call and returns something other than
         * <code>NIL</code> if and only if each argument in its argument list is
         * less than or equal to the next argument.
         */
        public Term call(TList l) {
            TermNumber t1;
            TermNumber t2;

            t1 = (TermNumber) l.getHead();
            l = l.getRest();

            while (l != null) {
                t2 = (TermNumber) l.getHead();
                if (t1.getNumber() > t2.getNumber())
                    return TermList.NIL;
                l = l.getRest();
                t1 = t2;
            }

            return new TermNumber(1.0);
        }
    }

    /**
     * Each code call of the form <code>(call Member &#46;&#46;&#46;)</code> is
     * implemented by an object of this class
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class Member implements Calculate {
        /**
         * This function executes the code call and returns <code>NIL</code> if its
         * first argument is not a member of its second argument, and something
         * other than <code>NIL</code> otherwise.
         */
        public Term call(TList l) {
            Term t = l.getHead();
            l = ((TermList) l.getRest().getHead()).getList();

            while (l != null) {
                if (t.equals(l.getHead()))
                    return new TermNumber(1.0);

                l = l.getRest();
            }

            return TermList.NIL;
        }
    }

    /**
     * Each code call of the form <code>(call - &#46;&#46;&#46;)</code> is
     * implemented by an object of this class.
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class Minus implements Calculate {
        /**
         * This function executes the code call and returns the result by
         * subtracting the second argument from the first one, the third argument
         * from the result of that subtraction, and so on.
         */
        public Term call(TList l) {
            double res = ((TermNumber) l.getHead()).getNumber();
            l = l.getRest();

            while (l != null) {
                res -= ((TermNumber) l.getHead()).getNumber();
                l = l.getRest();
            }

            return new TermNumber(res);
        }
    }

    /**
     * Each code call of the form <code>(call &#62; &#46;&#46;&#46;)</code> is
     * implemented by an object of this class
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class More implements Calculate {
        /**
         * This function executes the code call and returns something other than
         * <code>NIL</code> if and only if each argument in its argument list is
         * more than the next argument.
         */
        public Term call(TList l) {
            TermNumber t1;
            TermNumber t2;

            t1 = (TermNumber) l.getHead();
            l = l.getRest();

            while (l != null) {
                t2 = (TermNumber) l.getHead();
                if (t1.getNumber() <= t2.getNumber())
                    return TermList.NIL;
                l = l.getRest();
                t1 = t2;
            }

            return new TermNumber(1.0);
        }
    }

    /**
     * Each code call of the form <code>(call &#62;= &#46;&#46;&#46;)</code> is
     * implemented by an object of this class
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class MoreEq implements Calculate {
        /**
         * This function executes the code call and returns something other than
         * <code>NIL</code> if and only if each argument in its argument list is
         * more than or equal to the next argument.
         */
        public Term call(TList l) {
            TermNumber t1;
            TermNumber t2;

            t1 = (TermNumber) l.getHead();
            l = l.getRest();

            while (l != null) {
                t2 = (TermNumber) l.getHead();
                if (t1.getNumber() < t2.getNumber())
                    return TermList.NIL;
                l = l.getRest();
                t1 = t2;
            }

            return new TermNumber(1.0);
        }
    }

    /**
     * Each code call of the form <code>(call * &#46;&#46;&#46;)</code> is
     * implemented by an object of this class.
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class Mult implements Calculate {
        /**
         * This function executes the code call and returns the product of all its
         * arguments.
         */
        public Term call(TList l) {
            double res = 1;

            while (l != null) {
                res *= ((TermNumber) l.getHead()).getNumber();
                l = l.getRest();
            }

            return new TermNumber(res);
        }
    }

    /**
     * Each code call of the form <code>(call &#33;= &#46;&#46;&#46;)</code> is
     * implemented by an object of this class.
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class NotEq implements Calculate {
        /**
         * This function executes the code call and returns something other than
         * <code>NIL</code> if and only if each argument in its argument list is
         * not equal to the next argument.
         */
        public Term call(TList l) {
            Term t1;
            Term t2;

            t1 = l.getHead();
            l = l.getRest();

            while (l != null) {
                t2 = l.getHead();
                if (t1.equals(t2))
                    return TermList.NIL;
                l = l.getRest();
                t1 = t2;
            }

            return new TermNumber(1.0);
        }
    }

    /**
     * Each code call of the form <code>(call + &#46;&#46;&#46;)</code> is
     * implemented by an object of this class.
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class Plus implements Calculate {
        /**
         * This function executes the code call and returns the sum of all its
         * arguments.
         */
        public Term call(TList l) {
            double sum = 0;

            while (l != null) {
                sum += ((TermNumber) l.getHead()).getNumber();
                l = l.getRest();
            }

            return new TermNumber(sum);
        }
    }

    /**
     * Each code call of the form <code>(call ^ &#46;&#46;&#46;)</code> is
     * implemented by an object of this class.
     *
     * @author Okhtay Ilghami
     * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
     * @version 1.0.3
     */
    static class Power implements Calculate {
        /**
         * This function executes the code call and returns the result by raising
         * the first argument to the power of the second one, the result of that to
         * the power of the third argument, and so on.
         */
        public Term call(TList l) {
            double res = ((TermNumber) l.getHead()).getNumber();
            l = l.getRest();

            while (l != null) {
                res = Math.pow(res, ((TermNumber) l.getHead()).getNumber());
                l = l.getRest();
            }

            return new TermNumber(res);
        }
    }
}
