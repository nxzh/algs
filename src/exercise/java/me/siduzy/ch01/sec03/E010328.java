package me.siduzy.ch01.sec03;

import static me.siduzy.ch01.sec03.Utils.createList;

public class E010328 {
    public static int max(Node<Integer> l, int max) {
       if (l == null) {
           return max;
       }
       return max(l.next, Math.max(max, l.data));
    }

    public static void main(String[] args) {
        Node l = createList(10);
        int max = max(l, 0);
        System.out.println(max);
    }
}
