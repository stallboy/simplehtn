package simplehtn;

import java.util.LinkedList;
import java.util.List;

public class Plan {
    /**
     * list里的op是ground的，不含变量
     */
    private final LinkedList<Predicate> ops = new LinkedList<>();
    private double cost;


    public List<Predicate> getOps() {
        return ops;
    }

    public double getCost() {
        return cost;
    }

    public void addOperator(Predicate opInstance, double opCost) {
        ops.addLast(opInstance);
        this.cost += opCost;
    }


    public void removeOperator(double opCost) {
        ops.removeLast();
        cost -= opCost;
    }

    @Override
    public String toString() {
        int sz = ops.size();
        StringBuilder sb = new StringBuilder();
        for (Predicate op : ops) {
            if (op.getName().startsWith("!!")){
                continue;
            }
            sb.append(op);
            if (sz < 4) {
                sb.append(" -> ");
            } else {
                sb.append("\n");
            }
        }
        sb.append("cost=").append(cost);
        return sb.toString();
    }

    public Plan clonePlan() {
        Plan np = new Plan();
        np.ops.addAll(ops);
        np.cost = cost;
        return np;
    }
}
