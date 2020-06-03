package me.siduzy.collection;

/**
 * Bag is a data structure which can collect items.
 * @param <ITEM> type of data which stored in the Bag.
 */
public interface Bag<ITEM> extends Iterable<ITEM> {
    void add(ITEM item);
    boolean isEmpty();
    int size();
}
