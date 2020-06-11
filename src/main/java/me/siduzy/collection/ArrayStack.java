package me.siduzy.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array implementation of Stack.
 *
 * @param <ITEM> type of data which stored in the Stack.
 */
public class ArrayStack<ITEM> implements Stack<ITEM> {

    private static int DEFAULT_INITIAL_SIZE = 2;
    private ITEM[] storage;
    private int size = 0;

    public ArrayStack() {
        storage = (ITEM[]) new Object[DEFAULT_INITIAL_SIZE];
    }

    @Override
    public void push(ITEM item) {
        if (size == storage.length) {
            resize(2 * storage.length);
        }
        storage[size++] = item;
    }

    @Override
    public ITEM pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ITEM ret = storage[--size];
        storage[size] = null;
        if (size > 0 && size == storage.length / 4) {
            resize(storage.length / 2);
        }
        return ret;
    }

    @Override
    public ITEM peek() {
        return storage[size - 1];
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
        return new ReverseArrayIterator();
    }

    private void resize(int newSize) {
        ITEM[] newStorage = (ITEM[]) new Object[newSize];
        for (int i = 0; i < size; ++i) {
            newStorage[i] = storage[i];
        }
        storage = newStorage;
    }

    private class ReverseArrayIterator implements Iterator<ITEM> {
        private int index;

        public ReverseArrayIterator() {
            index = size;
        }

        @Override
        public boolean hasNext() {
            return index != 0;
        }

        @Override
        public ITEM next() {
            return storage[--index];
        }
    }
}
