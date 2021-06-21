package simplehtn;

/**
 * taskatom: (:immediate? (ID | OPID) terml )
 * 可能immediate，跟上层tasklist的unordered配合
 */
public class TaskAtom {
    private final Predicate head;
    private final boolean immediate;
    private final boolean primitive;

    public TaskAtom(Predicate head, boolean immediate, boolean primitive) {
        this.head = head;
        this.immediate = immediate;
        this.primitive = primitive;
    }

    public TaskAtom bind(Term[] binding) {
        return new TaskAtom(head.applySubstitution(binding), immediate, primitive);
    }

    public Predicate getHead() {
        return head;
    }

    public boolean isImmediate() {
        return immediate;
    }

    public boolean isPrimitive() {
        return primitive;
    }


    @Override
    public String toString() {
        if (isImmediate()) {
            return String.format("(:immediate %s %s)", head.getName(), head.getParam().toUnpairString());
        } else {
            return head.toString();
        }
    }
}
