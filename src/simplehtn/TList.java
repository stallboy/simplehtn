package simplehtn;

import java.util.LinkedList;

/**
 * lisp cons pair
 */
public class TList {
    private final Term head;
    private Term tail;


    public TList(Term head, Term tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * To append another term to the end of this list. Note that this function
     * is destructive, i.e., it appends the given term to this list, and not a
     * copy of it.
     *
     * @param t the term to be appended to this list.
     * @return the result of appending.
     */
    public TList append(Term t) {
        TList l = this;

        while (!l.tail.isNil())
            l = l.getRest();

        //-- Replace the NIL tail with 't'.
        l.tail = t;

        return this;
    }

    /**
     * To apply a given binding to this list. Note that this function does NOT
     * change this list, rather, it creates a new list which is the result of
     * binding.
     *
     * @param binding an array of terms, indexed by the integers associated with
     *                variable symbols.
     * @return the result of binding.
     */
    public TList bindList(Term[] binding) {
        return new TList(head.bind(binding), tail.bind(binding));
    }

    public boolean findUnifierList(TList l, Term[] binding) {
        //-- If 'l' is null, there will be no unifier.
        if (l == null)
            return false;

        return head.findUnifier(l.head, binding) &&
                tail.findUnifier(l.tail, binding);
    }

    public boolean equals(TList t) {
        return head.equals(t.head) && tail.equals(t.tail);
    }


    public Term getHead() {
        return head;
    }

    public Term getTail() {
        return tail;
    }

    public TList getRest() {
        return ((TermList) tail).getList();
    }

    public boolean isGroundList() {
        return head.isGround() && tail.isGround();
    }

    /**
     * This function gets a <code>LinkedList</code> of terms as input and
     * returns a list the elements of which are the terms in the input
     * <code>LinkedList</code> in the reverse order.
     *
     * @param listIn the input <code>LinkedList</code>.
     * @return the resulting list.
     */
    public static TList MakeList(LinkedList<Term> listIn) {
        TList retVal = null;

        //-- Iterate over the linked list, add each element to the head of the
        //-- return value.
        for (Term t : listIn)
            retVal = new TList(t, new TermList(retVal));

        return retVal;
    }


    @Override
    public String toString() {
        //-- If tail is a list itself,
        if (tail instanceof TermList) {
            if (tail.isNil())
                //-- Converting "(a . NIL) to "(a)"
                return head.toString();
            else {
                //-- Converting "(a . (b)) to "(a b)"
                String s = tail.toString();

                return head.toString() + " " + s.substring(1, s.length() - 1);
            }
        }
        //-- If tail is not a list,
        else
            return head.toString() + " . " + tail.toString();
    }
}
