package simplehtn;

import java.util.LinkedList;
import java.util.List;

/**
 * 出现在problem 和 method里
 * 可能unordered
 */
public class TaskList {
    public static TaskList empty = new TaskList();


    private final boolean ordered;
    private TaskList[] subtasks;
    private final TaskAtom task;

    public static TaskList of(List<TaskList> subs, boolean isOrdered) {
        if (subs.size() == 0)
            return empty;

        TaskList retVal = new TaskList(subs.size(), isOrdered);

        for (int i = 0; i < subs.size(); i++)
            retVal.subtasks[i] = subs.get(i);

        return retVal;
    }

    public static TaskList of(TaskAtom atom) {
        return new TaskList(atom);
    }

    private TaskList() {
        ordered = true;
        subtasks = new TaskList[0];
        task = null;
    }

    private TaskList(TaskAtom atomTask) {
        ordered = true;  //-- A task atom is ordered by definition.
        subtasks = null;
        task = atomTask;
    }

    private TaskList(int size, boolean orderedIn) {
        ordered = orderedIn;
        subtasks = new TaskList[size];
        task = null;
    }

    public TaskList bind(Term[] binding) {
        if (subtasks == null) {
            return new TaskList(task.bind(binding));
        }

        TaskList retVal = new TaskList(subtasks.length, ordered);
        for (int i = 0; i < subtasks.length; i++) {
            retVal.subtasks[i] = subtasks[i].bind(binding);
        }
        return retVal;
    }


    public List<TaskList> getFirst() {
        List<TaskList> retVal = new LinkedList<>();
        getFirstHelper(retVal);
        return retVal;
    }


    /**
     * @return 如果immediate 的task被发现就返回true，否则false
     */
    private boolean getFirstHelper(List<TaskList> res) {
        if (subtasks == null) {
            if (task.isImmediate()) {
                res.clear();
                res.add(this);
                return true;
            } else {
                res.add(this);
                return false;
            }
        } else if (ordered) {
            int listSize = res.size();
            for (TaskList subtask : subtasks) {
                if (subtask.getFirstHelper(res)) {
                    return true;
                } else if (res.size() != listSize) { //因为有TaskList.empty的存在
                    return false;
                }
            }
            return false;

        } else {
            for (TaskList subtask : subtasks) {
                if (subtask.getFirstHelper(res)) {
                    return true;
                }
            }
            return false;
        }
    }


    public TaskAtom getTask() {
        return task;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public TaskList[] getSubtasks() {
        return subtasks;
    }

    /**
     * Whether or not this task list is, or has become as result of task
     * decomposition, an empty one.
     *
     * @return <code>true</code> if this task list is equivalent to an empty
     * task list, <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        //-- Atomic task lists can not be empty.
        if (subtasks == null)
            return false;

        //-- If any of the subtasks is not empty, then the task list is not empty.
        for (TaskList subtask : subtasks)
            if (!subtask.isEmpty())
                return false;

        //-- If this is a non-atomic task list and all its subtasks are empty, then
        //-- it is an empty task list.
        return true;
    }


    /**
     * decompose atom to list
     */
    public void decompose(TaskList tasksIn) {
        subtasks = tasksIn.subtasks;
    }

    /**
     * undo decompose
     */
    public void undoDecompose() {
        subtasks = null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "()";
        } else if (subtasks == null) {
            return task.toString();
        } else {
            StringBuilder s = new StringBuilder("(");
            if (!ordered) {
                s.append(":unordered");
            }
            for (TaskList subtask : subtasks) {
                if (!subtask.isEmpty()) {
                    if (!s.toString().equals("("))
                        s.append(" ");
                    s.append(subtask);
                }
            }
            s.append(")");

            return s.toString();
        }
    }
}
