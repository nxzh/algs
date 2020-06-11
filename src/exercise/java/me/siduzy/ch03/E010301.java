package me.siduzy.ch03;

public class E010301 {
    public static class FixedCapacityStackOfStrings {
        private String[] storage;
        private int N;

        public FixedCapacityStackOfStrings(int capacity) {
            this.storage = new String[capacity];
        }

        public void push(String str) {
            if (N < storage.length) {
                storage[N++] = str;
            }
        }

        public String pop() {
            String ret = storage[--N];
            storage[N] = null;
            return ret;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public boolean isFull() {
            return N == storage.length;
        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stringStack = new FixedCapacityStackOfStrings(10);
        System.out.println(stringStack.isEmpty());
        for (int i = 0; i < 10; i++) {
            stringStack.push(i + "");
        }
        System.out.println(stringStack.isFull());
        for (int i = 0; i < 10; i++) {
            stringStack.pop();
        }
        System.out.println(stringStack.isEmpty());
    }
}
