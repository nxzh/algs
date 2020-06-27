package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

public class E010319 {

    static class Node {
        Node next;
        int data;

        public void removeTail() {
            Node p = this;
            if (p.next == null) {
                return;
            }
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
        }

        public int length() {
            Node p = this;
            int len = 0;
            while (p != null) {
                p = p.next;
                ++len;
            }
            return len;
        }
    }

    public static Node createList(int len) {
        Node[] node = new Node[len];
        for (int i = 0; i < len; i++) {
            node[i] = new Node();
            node[i].data = i;
        }
        for (int i = 1; i < len; i++) {
            node[i - 1].next = node[i];
        }
        return node[0];
    }

    public static void main(String[] args) {
        Node n2 = createList(2);
        n2.removeTail();
        StdOut.println(n2.length());
        Node n3 = createList(3);
        n3.removeTail();
        StdOut.println(n3.length());
        Node n4 = createList(4);
        n4.removeTail();
        StdOut.println(n4.length());
    }
}
