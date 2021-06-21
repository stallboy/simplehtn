package simplehtn;

public interface PlanStepListener {
    void startGoal(TaskList goal);

    void trying(TaskAtom task, State state);

    void stateChanged(TaskAtom task, Predicate operatorInstance, State newState);

    void reduced(TaskAtom task, String methodLabel, TaskList decomposedTo);

    void backtracking(TaskAtom task);

    void backtrackingOver(TaskList task);

    void planFound(Plan plan);


    PlanStepListener NULL = new PlanStepListener() {
        @Override
        public void startGoal(TaskList goal) {

        }

        @Override
        public void trying(TaskAtom task, State state) {

        }

        @Override
        public void stateChanged(TaskAtom task, Predicate operatorInstance, State newState) {

        }

        @Override
        public void reduced(TaskAtom task, String methodLabel, TaskList decomposedTo) {

        }

        @Override
        public void backtracking(TaskAtom task) {

        }

        @Override
        public void backtrackingOver(TaskList task) {

        }

        @Override
        public void planFound(Plan plan) {

        }
    };

    PlanStepListener PRINT_TO_CONSOLE = new PlanStepListener() {
        @Override
        public void startGoal(TaskList goal) {
            System.out.println("SetGoal " + goal);
        }

        @Override
        public void trying(TaskAtom task, State state) {
            System.out.println("Trying " + task);
        }

        @Override
        public void stateChanged(TaskAtom task, Predicate operatorInstance, State newState) {
            System.out.println("StateChanged " + task + " op=" + operatorInstance);
        }

        @Override
        public void reduced(TaskAtom task, String methodLabel, TaskList decomposedTo) {
            System.out.println("Reduced " + task + ", methodSub=" + methodLabel + ", decomposedTo=" + decomposedTo);
        }

        @Override
        public void backtracking(TaskAtom task) {
            System.out.println("Backtracking " + task);
        }

        @Override
        public void backtrackingOver(TaskList task) {
            System.out.println("BacktrackingOver " + task);
        }

        @Override
        public void planFound(Plan plan) {
            System.out.println("PlanFound " + plan);
            System.out.println();
        }
    };

}
