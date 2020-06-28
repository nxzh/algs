package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

import static me.siduzy.ch01.sec03.Utils.*;

public class E010320 {
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
    public static void main(String[] args) {
        Node node = createList(10);
        Node res = removeKth(node, 10);
        StdOut.println(length(res));
        res = removeKth(node, 10);
        StdOut.println(length(res));
        res = removeKth(node, 9);
        StdOut.println(length(res));
        print(res); // 0 1 2 3 4 5 6 7
        res = removeKth(node, 1);
        print(res); // 1 2 3 4 5 6 7

        res = removeKth(node, 4);
        print(res); // 0 1 2 4 5 6 7
    }
}
