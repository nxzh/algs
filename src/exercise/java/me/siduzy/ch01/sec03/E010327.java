package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

import static me.siduzy.ch01.sec03.Utils.createList;

public class E010327 {

    public static int max(Node<Integer> l) {
        if (l == null) {
            return 0;
        }
        int max = l.data;
        Node<Integer> p = l.next;
        while (p != null) {
            max = Math.max(max, p.data.intValue());
            p = p.next;
        }
        return max;
    }

    public static void main(String[] args) {
       Node l = createList(10);
       int max = max(l);
        StdOut.println(max);
    }
}
