package simplehtn;

public class PreconditionAnd2 extends Precondition {
    private final Precondition ele1;
    private final Precondition ele2;

    private Term[] b0;
    private Term[] b1;
    private Term[] b2;

    public PreconditionAnd2(Precondition ele1, Precondition ele2) {
        setFirst(false);
        this.ele1 = ele1;
        this.ele2 = ele2;
    }

    @Override
    public Precondition setUnifier(Term[] unifier) {
        Precondition p1 = ele1.setUnifier(unifier);
        Precondition p2 = ele2.setUnifier(unifier);
        return new PreconditionAnd2(p1, p2);
    }

    @Override
    protected void resetNextSatisfierHelper(State state, Term[] binding) {
        ele1.resetNextSatisfier(state, binding);
        b0 = binding;
        b1 = null;
        b2 = null;
    }

    /**
     * 注意这里可能会返回相同的satisfier，但不好在这里去优化去重，因为call这种语句，状态的修改可能再系统外发生
     * 如果要去掉相同的plan，那就在最后取得plan列表时再做去重
     */
    @Override
    protected Term[] nextSatisfierHelper(State state) {
        while (b2 == null) { // 用while是因为：当ele2遍历完之后要开始 找ele1的下一个satisfier
            if (b1 == null) {
                b1 = ele1.nextSatisfier(state);
                if (b1 == null)
                    return null;
                if (b0 != null) {
                    Term.mergeIfAbsent(b1, b0);
                }

                ele2.resetNextSatisfier(state, b1);
            }

            b2 = ele2.nextSatisfier(state);

            if (b2 == null) {
                b1 = null; // 让b1开始找下一个
            }
        }

        Term[] res = Term.newMerge(b2, b1);
        b2 = null; //让下次next时可以正常进入while(b2 == null)循环里
        return res;
    }

    @Override
    public String toString() {
        return String.format("(and %s %s)", ele1, ele2);
    }
}
