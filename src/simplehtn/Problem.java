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

    /**
     * 先包含domain里的constant，再包含problem里的
     */
    final Map<String, Integer> constSymbols;
    /**
     * var只会在taskList里出现，大多数情况下应该不会有，但算法应该是支持的
     */
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
