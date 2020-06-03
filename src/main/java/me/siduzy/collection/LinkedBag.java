package me.siduzy.collection;

import java.util.Iterator;

/**
 * Linked list implementation of Bag.
 *
 * @param <ITEM> type of data which stored in the Bag.
 */
public class LinkedBag<ITEM> implements Bag<ITEM> {
    private Node head;
    private int size;

    private class Node {
        ITEM data;
        Node next;
    }

    @Override
    public void add(ITEM t) {
        Node oldHead = head;
        head = new Node();
        head.data = t;
        head.next = oldHead;
        ++size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<ITEM> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<ITEM> {
        private Node cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public ITEM next() {
            Node ret = cur;
            cur = cur.next;
            return ret.data;
        }
    }
}
