package simplehtn;

/**
 * This class represents a predicate with an integer number associated with
 * it. It serves two different purposes: First, to represent a protection on
 * some predicate (the integer number being the number of times the predicate
 * is protected), and second, when a predicate is deleted from the current
 * state of the world, an object of this class represents the deleted
 * predicate and where it was deleted from so that in case of a backtrack the
 * deleted predicate can be added back exactly where it was before.
 *
 * @author Okhtay Ilghami
 * @author <a href="http://www.cs.umd.edu/~okhtay">http://www.cs.umd.edu/~okhtay</a>
 * @version 1.0.3
 */
public class NumberedPredicate {
    private int number;
    private final Predicate pre;


    public NumberedPredicate(Predicate preIn) {
        pre = preIn;
        number = 1;
    }

    public NumberedPredicate(Predicate preIn, int numberIn) {
        pre = preIn;
        number = numberIn;
    }

    /**
     * To increase the integer by one. This is used when a protection is added.
     */
    public void inc() {
        number++;
    }

    /**
     * To decrease the integer by one. This is used when a protection is
     * deleted.
     *
     * @return <code>false</code> if the integer become zero, <code>true</code>
     * otherwise.
     */
    public boolean dec() {
        if (number > 1) {
            number--;
            return true;
        } else
            return false;
    }

    public int getHead() {
        return pre.getHead();
    }

    public int getNumber() {
        return number;
    }

    public Term getParam() {
        return pre.getParam();
    }


    public String toString() {
        return pre.toString();
    }
}
