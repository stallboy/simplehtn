package simplehtn;


import java.util.*;

public class Domain {
    final String name;

    /**
     * 第一层是primitiveTask索引，第二层是此task实现方法索引
     */
    final List<List<Operator>> operators;
    final Map<String, Integer> primitiveTaskSymbols;

    /**
     * 第一层是compoundTask索引，第二层是此task实现方法索引
     */
    final List<List<Method>> methods;
    final Map<String, Integer> compoundTaskSymbols;

    /**
     * 第一层是constantSymbols索引，第二层是此axiom实现方法索引
     * 让axioms的名称位于constantSymbols最前面
     */
    final List<List<Axiom>> axioms;
    final Map<String, Integer> constSymbols;


    public Domain(String name, Set<String> primitives, Set<String> compounds, Set<String> axiomConstants, Set<String> constants) {
        this.name = name;

        int id = 0;
        operators = new ArrayList<>(primitives.size());
        primitiveTaskSymbols = new LinkedHashMap<>(primitives.size());
        for (String sym : primitives) {
            primitiveTaskSymbols.put(sym, id);
            id++;
            operators.add(new ArrayList<>());
        }

        methods = new ArrayList<>(compounds.size());
        compoundTaskSymbols = new LinkedHashMap<>(compounds.size());
        id = 0;
        for (String sym : compounds) {
            compoundTaskSymbols.put(sym, id);
            id++;
            methods.add(new ArrayList<>());
        }

        axioms = new ArrayList<>(axiomConstants.size());
        constSymbols = new LinkedHashMap<>();
        id = 0;
        for (String sym : axiomConstants) {
            constSymbols.put(sym, id);
            id++;
            axioms.add(new ArrayList<>());
        }
        for (String sym : constants) {
            if (!axiomConstants.contains(sym)) {
                constSymbols.put(sym, id);
                id++;
            }
        }
    }

    public void addOperator(Operator op) {
        operators.get(op.getHead().getHead()).add(op);
    }

    public void addMethod(Method m) {
        methods.get(m.getHead().getHead()).add(m);
    }

    public void addAxiom(Axiom ax) {
        axioms.get(ax.getHead().getHead()).add(ax);
    }
}
