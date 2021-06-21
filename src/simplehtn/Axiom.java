package simplehtn;

import java.util.Set;

public class Axiom extends DomainElement {

    static class AxiomSub {
        String label;
        Precondition pre;
    }

    AxiomSub[] subs;

    public Axiom(Domain domain, Set<String> vars) {
        super(domain, vars);
    }
}
