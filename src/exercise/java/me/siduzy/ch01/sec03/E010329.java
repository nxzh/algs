package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class E010329 {
    static class Queue<Item> implements Iterable<Item> {
        private Node<Item> last;
        int N;

        public void enqueue(Item item) {
            if (last == null) {
                last = new Node<>();
                last.data = item;
                last.next = last;
            } else {
                Node<Item> first = last.next;
                last.next = new Node<>();
                last.next.data = item;
                last = last.next;
                last.next = first;
            }
            ++N;
        }

        public Item dequeue() {
            if (N == 0) {
                throw new NoSuchElementException();
            }
            Node<Item> ret;
            if (N == 1) {
                ret = last;
                last = null;
            } else {
                ret = last.next;
                last.next = last.next.next;
                ret.next = null;
            }
            --N;
            return ret.data;
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        @Override
        public Iterator<Item> iterator() {
            return new FifoIterator(last, N);
        }

        private class FifoIterator implements Iterator<Item> {
            private Node<Item> pointer;
            private int n;

            public FifoIterator(Node<Item> last, int n) {
                this.n = n;
                this.pointer = this.n == 0 ? null : last.next;
            }

            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Item next() {
                if (n == 0) {
                    throw new NoSuchElementException();
                }
                Node<Item> ret = pointer;
                pointer = pointer.next;
                --n;
                return ret.data;
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        Iterator<Integer> iter = queue.iterator();
        for (Integer n : queue) {
            StdOut.println(n);
        }
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.size());
        StdOut.println(queue.isEmpty());
    }
}
