package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

public class E010320 {
    static class Node {
        Node next;
        int data;


        public int length() {
            Node p = this;
            int len = 0;
            while (p != null) {
                len++;
                p = p.next;
            }
            return len;
        }

        public void print() {
            Node p = this;
            while (p != null) {
                StdOut.println(p.data);
                p = p.next;
            }
        }
    }

    public static Node removeKth(Node list, int k) {
        Node dummy = new Node();
        dummy.next = list;
        Node p = dummy;
        int n = 1;
        while (n++ != k && p != null) {
            p = p.next;
        }
        if (n != k + 1 || p.next == null) {
            return dummy.next;
        }
        p.next = p.next.next;
        return dummy.next;
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
        Node node = createList(10);
        Node res = removeKth(node, 10);
        StdOut.println(res.length());
        res = removeKth(node, 10);
        StdOut.println(res.length());
        res = removeKth(node, 9);
        StdOut.println(res.length());
        res.print(); // 0 1 2 3 4 5 6 7
        res = removeKth(node, 1);
        res.print(); // 1 2 3 4 5 6 7

        res = removeKth(node, 4);
        res.print(); // 0 1 2 4 5 6 7
    }
}
