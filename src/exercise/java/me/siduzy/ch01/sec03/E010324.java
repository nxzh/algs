package me.siduzy.ch01.sec03;

import static me.siduzy.ch01.sec03.Utils.createList;
import static me.siduzy.ch01.sec03.Utils.print;

public class E010324 {

    public static void removeAfter(Node pos) {
        if (pos == null) {
            return;
        }
        pos.next = null;
    }

    public static void main(String[] args) {
        Node<Integer> n5 = createList(5);
        removeAfter(n5.next);
        print(n5);
    }
}
