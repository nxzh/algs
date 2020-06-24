package me.siduzy.ch03;

import java.util.Iterator;

public class E010312 {

    static class Stack<Item> implements Iterable<Item> {

        private Item[] storage;
        private int N;

        public Stack(int capacity) {
            storage = (Item[]) new Object[capacity];
        }


        public void push(Item item) {
            storage[N++] = item;
        }

        public Item pop() {
            Item ret = storage[--N];
            storage[N] = null;
            return ret;
        }

        public int size() {
            return N;
        }


        public static Stack<String> copy(Stack<String> stack) {
            Stack<String> copy = new Stack<>(stack.size());
            Iterator<String> iter = stack.fifoIterator();
            while (iter.hasNext()) {
                copy.push(iter.next());
            }
            return copy;
        }

        @Override
        public Iterator<Item> iterator() {
            return new LastInFirstOutIterator();
        }

        public Iterator<Item> fifoIterator() {
            return new FirstInFirstOutIterator();
        }

        private class FirstInFirstOutIterator implements Iterator<Item> {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index != N;
            }

            @Override
            public Item next() {
                return storage[index++];
            }
        }

        private class LastInFirstOutIterator implements Iterator<Item> {
            int index = N;

            @Override
            public boolean hasNext() {
                return index != 0;
            }

            @Override
            public Item next() {
                return storage[--index];
            }
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(5);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        Stack<String> copy = Stack.copy(stack);
        System.out.println(copy.size());
        System.out.println(stack.size());
        if (!(copy.size() == stack.size())) {
            throw new IllegalStateException();
        }
        Iterator<String> iter1 = stack.iterator();
        Iterator<String> iter2 = copy.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            if (!iter1.next().equals(iter2.next())) {
                throw new IllegalStateException();
            }
        }
    }
}
