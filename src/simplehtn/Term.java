package simplehtn;

/**
 * term的核心是  bind, findUnifier方法
 */
public abstract class Term {

    /**
     * 加上binding，返回更具体化的term
     *
     * @param binding 这个参数不会被修改
     */
    public abstract Term bind(Term[] binding);

    /**
     * 目标是t，看本term能否 通过做binding，unify成t
     *
     * @param binding 结果放到这个数组里
     */
    public abstract boolean findUnifier(Term t, Term[] binding);


    public abstract boolean equals(Term t);

    public abstract boolean isGround();

    public boolean isNil() {
        return (this instanceof TermList) && (((TermList) this).getList() == null);
    }

    /**
     * 合并b的binding到res上
     */
    public static void mergeIfAbsent(Term[] res, Term[] b) {
        for (int i = 0; i < res.length; i++) {
            if (res[i] == null) {
                res[i] = b[i];
            }
        }
    }

    /**
     * @return 返回一个新的合并后的binding
     */
    public static Term[] newMerge(Term[] a, Term[] b) {
        Term[] res = new Term[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                res[i] = a[i];
            } else if (b[i] != null) {
                res[i] = b[i];
            }
        }
        return res;
    }

    String toUnpairString() {
        return toString();
    }
}
