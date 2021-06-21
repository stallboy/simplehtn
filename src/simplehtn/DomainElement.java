package simplehtn;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class DomainElement {
    final Domain domain;
    Predicate head;
    final Map<String, Integer> varSymbols;

    public DomainElement(Domain domain, Set<String> vars) {
        this.domain = domain;
        varSymbols = new LinkedHashMap<>(vars.size());
        int id = 0;
        for (String var : vars) {
            varSymbols.put(var, id);
            id++;
        }
    }

    public Predicate getHead() {
        return head;
    }

    public Term[] unify(Predicate p) {
        return head.findUnifier(p.getParam());
    }


    @Override
    public String toString() {
        return head.toString();
    }
}
