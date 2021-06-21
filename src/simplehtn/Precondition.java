package simplehtn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 前置条件
 * domain里包含的是Static状态
 * ----------
 * | Static |
 * ---------
 * 经过setUnifier得到新的Precondition，处于Unified状态
 * -----------                          ---------------------
 * | Unified | --resetNextSatisfier--> | NextSatisfierReady |
 * ----------              ^           ---------------------
 * -                      |--------------------|
 * 在NextSatisfierReady状态，调用nextSatisfier方法 返回下一个满足当前状态的satisfier
 */
public abstract class Precondition {
    private boolean first;             // :first
    private Comparator<Term[]> sortBy; // :sort-by

    private boolean isCalledOnce;
    private Term[][] bindings;
    private int bindingsIdx;

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setSortBy(Comparator<Term[]> sorter) {
        this.sortBy = sorter;
    }


    /**
     * operator，method，axiom这些unify得到unifier后，设置到precondition上
     *
     * @param unifier 不为null，外层不会再修改unifier，子类也不会修改。
     * @return 返回新的Precondition，这样不会修改domain里的static部分，允许多个findPlans
     */
    public abstract Precondition setUnifier(Term[] unifier);

    /**
     * 在调用nextSatisfier前要调用的初始化，调用后进入NextSatisfierReady状态
     * 在forall的复合语句中会用到
     *
     * @param binding 可为null，表示不用额外加binding。
     *                当处理复合语句时，后面的precondition会使用前面nextSatisfier的绑定
     */
    public void resetNextSatisfier(State state, Term[] binding) {
        isCalledOnce = false;
        resetNextSatisfierHelper(state, binding);
    }


    protected abstract void resetNextSatisfierHelper(State state, Term[] binding);

    /**
     * 寻找下一个符合当前状态的binding，（现在的实现可能会返回重复的satisfier，参考And/Or子类实现）
     *
     * @return 下一个satisfier，如果没有返回null
     */
    public Term[] nextSatisfier(State state) {
        if (first && isCalledOnce)
            return null;

        if (sortBy == null) {
            isCalledOnce = true;
            return nextSatisfierHelper(state);
        }

        if (!isCalledOnce) {
            List<Term[]> v = new ArrayList<>();
            Term[] b;
            while ((b = nextSatisfierHelper(state)) != null)
                v.add(b);

            bindings = new Term[v.size()][];
            bindings = v.toArray(bindings);
            Arrays.sort(bindings, sortBy);

            bindingsIdx = 0;
            isCalledOnce = true;
        }

        if (bindingsIdx == bindings.length)
            return null;

        return bindings[bindingsIdx++];
    }

    protected abstract Term[] nextSatisfierHelper(State state);

}
