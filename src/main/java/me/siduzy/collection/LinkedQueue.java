package me.siduzy.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked list implementation of Queue.
 *
 * @param <ITEM> Type of data which stored in the Queue.
 */
public class LinkedQueue<ITEM> implements Queue<ITEM> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        ITEM data;
        Node next;
    }

    @Override
    public void enqueue(ITEM item) {
        Node old = tail;    // should always use an old node. It can simplify the code.
        tail = new Node();
        tail.data = item;
        if (old != null) {
            old.next = tail;
        } else {
            head = tail; // first node
        }
        ++size;
    }

    @Override
    public ITEM dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node old = head;
        head = head.next;
        if (--size == 0) {
            head = tail = null;
        }
        return old.data;
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
        Node cur = head;

        @Override
        public boolean hasNext() {
            return cur == null;
        }

        @Override
        public ITEM next() {
            Node ret = cur;
            cur = cur.next;
            return ret.data;
        }
    }
}
