package me.siduzy.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked list implementation of Stack.
 *
 * @param <ITEM> type of data which stored in the Stack.
 */
public class LinkedStack<ITEM> implements Stack<ITEM> {

    private Node head;
    int size = 0;

    private class Node {
        ITEM data;
        Node next;
    }

    @Override
    public void push(ITEM t) {
        Node oldHead = head; // Old Node can simplify the code
        head = new Node();
        head.data = t;
        head.next = oldHead;
        ++size;
    }

    @Override
    public ITEM pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node oldHead = head;
        head = head.next;
        --size;
        return oldHead.data;
    }

    @Override
    public ITEM peek() {
        if (head == null) {
            return null;
        }
        return head.data;
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
            Node old = cur;
            cur = cur.next;
            return old.data;
        }
    }
}
