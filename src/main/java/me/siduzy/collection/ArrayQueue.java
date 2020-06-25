package me.siduzy.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array implementation of Queue.
 *
 * @param <ITEM>
 */
public class ArrayQueue<ITEM> implements Queue<ITEM> {

    private static final int DEFAULT_SIZE = 2;
    private ITEM[] storage;
    private int begin;
    private int N;


    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int capacity) {
        storage = (ITEM[]) new Object[capacity];
    }

    @Override
    public void enqueue(ITEM item) {
        if (size() == storage.length) {
            resize(storage.length * 2);
        }
        int end = (begin + N) % storage.length;
        storage[end] = item;
        ++N;
    }

    @Override
    public ITEM dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        if (size() == storage.length / 4) {
            resize(storage.length / 2);
        }
        ITEM ret = storage[begin];
        storage[begin++] = null;
        if (begin == storage.length) {
            begin = begin % storage.length;
        }
        --N;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<ITEM> iterator() {
        return new FifoIterator(begin, N);
    }

    private void resize(int newSize) {
        ITEM[] newStorage = (ITEM[]) new Object[newSize];
        for (int i = 0; i < N; i++, begin++) {
            if (begin == storage.length) {
                begin = 0;
            }
            newStorage[i] = storage[begin];
        }
        begin = 0;
        storage = newStorage;

    }

    public class FifoIterator implements Iterator<ITEM> {
        private int begin;
        private int N;

        public FifoIterator(int begin, int N) {
            this.begin = begin;
            this.N = N;
        }

        @Override
        public boolean hasNext() {
            return N != 0;
        }

        @Override
        public ITEM next() {
            ITEM ret = storage[begin++];
            if (begin == storage.length) {
                begin = 0;
            }
            --N;
            return ret;
        }
    }
}
