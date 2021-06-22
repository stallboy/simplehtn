package simplehtn;

public abstract class DelAddElement {
    /**
     * @return 如果有要删除的predicate，在state的protection里，返回false，表示需要重做
     */
    public abstract boolean del(State s, Term[] binding, StateChanged changed);

    public abstract void add(State s, Term[] binding, StateChanged changed);
}
