package me.siduzy.collection;

/**
 * Queue is a first-in-first-out data structure.
 * @param <ITEM> type of data which stored in the Queue.
 */
public interface Queue<ITEM> extends Iterable<ITEM> {
    void enqueue(ITEM item);
    ITEM dequeue();
    boolean isEmpty();
    int size();
}