package simplehtn;

import java.util.Comparator;

public class ComparatorCreators {

    public static ComparatorCreator less;
    public static ComparatorCreator more;

    static {
        less = CompLess::new;
        more = CompMore::new;
    }


    static class CompLess implements Comparator<Term[]> {
        private final int varIdx;

        private CompLess(int varIdx) {
            this.varIdx = varIdx;
        }

        public int compare(Term[] t1, Term[] t2) {
            double n1 = ((TermNumber) t1[varIdx]).getNumber();
            double n2 = ((TermNumber) t2[varIdx]).getNumber();
            return Double.compare(n1, n2);
        }
    }


    static class CompMore implements Comparator<Term[]> {
        private final int varIdx;

        private CompMore(int varIdxIn) {
            varIdx = varIdxIn;
        }

        public int compare(Term[] t1, Term[] t2) {
            double n1 = ((TermNumber) t1[varIdx]).getNumber();
            double n2 = ((TermNumber) t2[varIdx]).getNumber();
            return Double.compare(n2, n1);
        }
    }


}
