package simplehtn;

import java.util.Comparator;

public class ComparatorCreators {
    public static final ComparatorCreator less = Less::new;
    public static final ComparatorCreator more = More::new;

    static record Less(int varIdx) implements Comparator<Term[]> {
        public int compare(Term[] t1, Term[] t2) {
            double n1 = ((TermNumber) t1[varIdx]).getNumber();
            double n2 = ((TermNumber) t2[varIdx]).getNumber();
            return Double.compare(n1, n2);
        }
    }

    static record More(int varIdx) implements Comparator<Term[]> {
        public int compare(Term[] t1, Term[] t2) {
            double n1 = ((TermNumber) t1[varIdx]).getNumber();
            double n2 = ((TermNumber) t2[varIdx]).getNumber();
            return Double.compare(n2, n1);
        }
    }
}
