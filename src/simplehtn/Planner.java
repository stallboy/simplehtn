package simplehtn;

import java.util.LinkedList;
import java.util.List;

/**
 * planner算法
 */
public class Planner {
    private final Problem problem;
    private final Domain domain;
    private final int planNo;
    private final PlanStepListener step;

    private State state;
    private TaskList tasks;

    private List<Plan> plans;
    private Plan currentPlan;


    public Planner(Problem problem, int planNo, PlanStepListener step) {
        this.problem = problem;
        this.domain = problem.domain;
        this.planNo = planNo;
        this.step = step;
    }


    public List<Plan> findPlans() {
        state = new State(problem);
        tasks = problem.taskList;

        step.startGoal(tasks);
        plans = new LinkedList<>();
        currentPlan = new Plan();
        findPlanHelper(tasks);
        return plans;
    }

    /**
     * @return 返回true表示plan成功，false表示失败
     */
    private boolean findPlanHelper(TaskList chosenTask) {
        List<TaskList> t0 = chosenTask.getFirst(); // t0是下一步要做的task 列表

        if (t0.size() == 0) {
            if (chosenTask != tasks)
                return findPlanHelper(tasks);
            else {
                if (planNo != 1) {
                    plans.add(currentPlan.clonePlan());
                } else {
                    plans.add(currentPlan);
                }

                step.planFound(currentPlan);
                return true;
            }
        }

        for (TaskList tl : t0) { //tl是 atom task list
            TaskAtom t = tl.getTask(); // t是 atom task
            step.trying(t, state);

            if (t.isPrimitive()) {
                tl.decompose(TaskList.empty); // 把tasks里的这项去除，下次chosenTask.getFirst时就找下一个了

                List<Operator> operators = domain.operators.get(t.getHead().getHead()); // 找到t对应的operator，可能有多个
                for (Operator op : operators) {
                    Term[] unifier = op.unify(t.getHead());
                    if (unifier == null) {
                        continue;
                    }

                    Precondition pre = op.pre.setUnifier(unifier);
                    pre.resetNextSatisfier(state, null);

                    StateChanged changed = new StateChanged();
                    Term[] satisfier;
                    while ((satisfier = pre.nextSatisfier(state)) != null) {
                        Term.merge(satisfier, unifier);

                        changed.clear();
                        if (op.apply(satisfier, state, changed)) {
                            Predicate opInstance = op.getHead().applySubstitution(satisfier);
                            double opCost = op.getCost(satisfier);
                            currentPlan.addOperator(opInstance, opCost);
                            step.stateChanged(t, opInstance, state);
                            if (findPlanHelper(tasks) && plans.size() >= planNo) {
                                return true;
                            }
                            currentPlan.removeOperator(opCost);
                        }

                        // 后面task的findPlan失败，在要寻找下一个satisfier前把上个satisfier导致的状态变化回退
                        state.undo(changed);
                    }
                }
                // 整个primitive task失败，回退，之后从t0里去找下一个unordered的任务
                tl.undoDecompose();

            } else {
                List<Method> methods = domain.methods.get(t.getHead().getHead());
                for (Method method : methods) {
                    Term[] unifier = method.unify(t.getHead());
                    if (unifier == null) {
                        continue;
                    }

                    boolean found = false;
                    for (Method.MethodSub sub : method.subs) {
                        Precondition pre = sub.pre.setUnifier(unifier);
                        pre.resetNextSatisfier(state, null);

                        Term[] satisfier;
                        while ((satisfier = pre.nextSatisfier(state)) != null) {
                            Term.merge(satisfier, unifier);

                            tl.decompose(sub.tasklist.bind(satisfier));
                            step.reduced(t, sub.label, tl);
                            if (findPlanHelper(tl) && plans.size() >= planNo) {
                                return true;
                            }

                            found = true;
                            tl.undoDecompose();
                        }

                        if (found) {
                            break;
                        }
                    }
                }
            }

            step.backtracking(t);
        }
        if (t0.size() > 1) {
            step.backtrackingOver(chosenTask);
        }
        return false;
    }


}
