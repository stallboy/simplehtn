package simplehtn;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem {
    final String name;
    final Domain domain;

    List<Predicate> state;
    TaskList taskList;

    final Map<String, Integer> constSymbols;
    final Map<String, Integer> varSymbols;


    public Problem(String name, Domain domain, Set<String> constants, Set<String> vars) {
        this.name = name;
        this.domain = domain;

        int id = domain.constSymbols.size();
        constSymbols = new LinkedHashMap<>(domain.constSymbols);
        for (String constant : constants) {
            if (!domain.constSymbols.containsKey(constant)) {
                constSymbols.put(constant, id);
                id++;
            }
        }

        id = 0;
        varSymbols = new LinkedHashMap<>(vars.size());
        for (String var : vars) {
            varSymbols.put(var, id);
            id++;
        }
    }

}
