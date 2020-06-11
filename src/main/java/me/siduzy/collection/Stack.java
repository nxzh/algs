package me.siduzy.collection;

/**
 * Stack is a last-in-first-out data structure.
 * @param <ITEM> type of data stored in the Stack.
 */
public interface Stack<ITEM> extends Iterable<ITEM> {
    void push(ITEM item);
    ITEM pop();
    ITEM peek();
    boolean isEmpty();
    int size();
}
