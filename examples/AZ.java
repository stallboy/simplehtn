import simplehtn.*;

public class AZ {
    static class Combine implements Calculate {
        public Term call(TList l) {
            double sum = 0;

            while (l != null) {
                sum = sum * 10 + ((TermNumber) l.getHead()).getNumber();
                l = l.getRest();
            }

            return new TermNumber(sum);
        }
    }

    public static void main(String[] args) {
        Main.solve("az.lisp", "az_problem.lisp", 100, false, new Combine());
    }
}
