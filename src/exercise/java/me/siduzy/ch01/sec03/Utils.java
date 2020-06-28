package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

class Utils {

    public static void print(Node<?> head) {
        if (head == null) {
            StdOut.print(null);
        }
        StringBuilder output = new StringBuilder();
        output.append(head.data);
        Node p = head.next;
        while (p != null) {
            output.append("->");
            output.append(p.data);
            p = p.next;
        }
        StdOut.println(output);
    }

    public static <ITEM> Node<ITEM> createList(int len) {
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

    public static Node<String> createStringList(int len) {
        Node[] node = new Node[len];
        for (int i = 0; i < len; i++) {
            node[i] = new Node();
            node[i].data = i + "";
        }
        for (int i = 1; i < len; i++) {
            node[i - 1].next = node[i];
        }
        return node[0];
    }

    public static <ITEM> int length(Node<ITEM> head) {
        Node p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }
}
