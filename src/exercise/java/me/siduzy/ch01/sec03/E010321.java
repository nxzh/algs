package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

public class E010321 {
    static class Node {
        Node next;
        String item;
    }
    public static boolean find(Node head, String key) {
        Node p = head;
        while (p != null) {
            if (p.item.equals(key)) {
               return true;
            }
            p = p.next;
        }
        return false;
    }
    public static Node createList(int len) {
        Node[] node = new Node[len];
        for (int i = 0; i < len; i++) {
            node[i] = new Node();
            node[i].item = i+"";
        }
        for (int i = 1; i < len; i++) {
            node[i - 1].next = node[i];
        }
        return node[0];
    }
    
    public static void main(String[] args) {
        StdOut.println(find(createList(4), "3"));
        StdOut.println(find(createList(1), "2"));
    }
}
