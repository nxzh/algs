package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;
import me.siduzy.collection.Queue;

import java.util.Iterator;

public class E010314 {
    public static class ResizingArrayQueueOfStrings<Item> implements Queue<Item> {

        private static final int DEFAULT_SIZE = 2;
        private Item[] storage;
        private int begin;
        private int N;


        public ResizingArrayQueueOfStrings() {
            this(DEFAULT_SIZE);
        }

        public ResizingArrayQueueOfStrings(int capacity) {
            storage = (Item[]) new Object[capacity];
        }

        @Override
        public void enqueue(Item item) {
            if (size() == storage.length) {
                resize(storage.length * 2);
            }
            int end = (begin + N) % storage.length;
            storage[end] = item;
            ++N;
        }

        @Override
        public Item dequeue() {
            if (size() == 0) {
                return null;
            }
            if (size() > 0 && size() == storage.length / 4) {
                resize(storage.length / 2);
            }
            Item ret = storage[begin];
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
        public Iterator<Item> iterator() {
            return new FifoIterator(begin, N);
        }

        private void resize(int newSize) {
            Item[] newStorage = (Item[]) new Object[newSize];
            for (int i = 0; i < N; i++, begin++) {
                if (begin == storage.length) {
                    begin = 0;
                }
                newStorage[i] = storage[begin];
            }
            begin = 0;
            storage = newStorage;

        }

        public class FifoIterator implements Iterator<Item> {
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
            public Item next() {
                Item ret = storage[begin++];
                if (begin == storage.length) {
                    begin = 0;
                }
                --N;
                return ret;
            }
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings<Integer> queue = new ResizingArrayQueueOfStrings<>();
        queue.enqueue(0);
        queue.enqueue(1); // en
        queue.enqueue(2);
        queue.enqueue(3);
        StdOut.println(queue.size());
        queue.dequeue();
        queue.dequeue();
        StdOut.println(queue.size());
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        StdOut.println(queue.size());

        Iterator<Integer> iter = queue.iterator();
        while (iter.hasNext()) {
            StdOut.println(iter.next());
        }
    }
}
