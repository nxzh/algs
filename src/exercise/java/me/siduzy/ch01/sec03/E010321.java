package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;

import static me.siduzy.ch01.sec03.Utils.createList;
import static me.siduzy.ch01.sec03.Utils.createStringList;

public class E010321 {
    public static boolean find(Node head, String key) {
        Node p = head;
        while (p != null) {
            if (p.data.equals(key)) {
               return true;
            }
            p = p.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        StdOut.println(find(createStringList(4), "3"));
        StdOut.println(find(createStringList(1), "2"));
    }
}
