package me.siduzy.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array implementation of Queue.
 *
 * @param <ITEM>
 */
public class ArrayQueue<ITEM> implements Queue<ITEM> {
    private static int DEFAULT_INITIAL_SIZE = 2;
    private ITEM[] storage;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public ArrayQueue() {
        storage = (ITEM[]) new Object[DEFAULT_INITIAL_SIZE];
    }

    @Override
    public void enqueue(ITEM item) {
        if (size() == storage.length) {
            resize(storage.length * 2);
        }
        if (tail == storage.length) {
            tail = tail % storage.length;
        }
        storage[tail++] = item;
        ++size;
    }

    private void resize(int newSize) {
        ITEM[] newStorage = (ITEM[]) new Object[newSize];
        int newTail = 0;
        if (tail > head) {
            for (int i = head; i < tail; i++, newTail++) {
                newStorage[newTail] = storage[i];
            }
        } else {
            for (int i = head; i < size(); i++, newTail++) {
                newStorage[newTail] = storage[i];
            }
            for (int i = 0; i < tail; i++, newTail++) {
                newStorage[newTail] = storage[i];
            }
        }
        head = 0;
        tail = newTail;
        storage = newStorage;
    }

    @Override
    public ITEM dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ITEM ret = storage[head];
        storage[head++] = null;
        --size;
        if (head == storage.length) {
            head = head % storage.length;
        }
        if (size() > 0 && size() == storage.length / 4) {
            resize(storage.length / 2);
        }
        return ret;
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
        return new NaturalOrderIterator();
    }

    private class NaturalOrderIterator implements Iterator<ITEM> {
        private int head;
        private int tail;

        public NaturalOrderIterator() {
            this.head = ArrayQueue.this.head;
            this.tail = ArrayQueue.this.tail;
        }

        @Override
        public boolean hasNext() {
            return head == tail;
        }

        @Override
        public ITEM next() {
            ITEM ret = storage[head++];
            if (tail < head && head == storage.length) {
                head = head % storage.length;
            }
            return ret;
        }
    }
}
