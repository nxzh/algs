package me.siduzy.ch01.sec03;

import static me.siduzy.ch01.sec03.Utils.print;

public class E010326 {

    public static Node remove(Node l, Integer i) {
        if (l == null) {
            return null;
        }
        Node dummy = new Node();
        dummy.next = l;
        Node p = dummy;
        while (p.next != null) {
            if (p.next.data.equals(i)) {
               p.next = p.next.next;
            } else {
               p = p.next;
            }
        }
        l = dummy.next;
        return l;
    }

    public static void main(String[] args) {
        Node l = Utils.createList(10);
        Node p = l;
        while (p != null && p.next != null) {
            p.data  = 4;
            p = p.next.next;
        }
        Node res = remove(l, 4);
        print(res);
    }
}
