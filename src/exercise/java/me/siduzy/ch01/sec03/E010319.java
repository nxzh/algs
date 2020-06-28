package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

import static me.siduzy.ch01.sec03.Utils.createList;
import static me.siduzy.ch01.sec03.Utils.length;

public class E010319 {

    public static <ITEM> void removeTail(Node<ITEM> head) {
        Node p = head;
        if (p.next == null) {
            return;
        }
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
    }


    public static void main(String[] args) {
        Node n2 = createList(2);
        removeTail(n2);
        StdOut.println(length(n2));
        Node n3 = createList(3);
        removeTail(n3);
        StdOut.println(length(n3));
        Node n4 = createList(4);
        removeTail(n4);
        StdOut.println(length(n4));
    }
}
