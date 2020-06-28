package me.siduzy.ch01.sec03;

import static me.siduzy.ch01.sec03.Utils.createList;
import static me.siduzy.ch01.sec03.Utils.print;

public class E010325 {

    public static void insertAfter(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return;
        }
        Node p = l1;
        while (p.next!=null) {
            p = p.next;
        }
        p.next = l2;
    }

    public static void main(String[] args) {
        Node l1 = createList(5);
        Node l2 = createList(1);
        insertAfter(l1, l2);
        print(l1);
    }
}
