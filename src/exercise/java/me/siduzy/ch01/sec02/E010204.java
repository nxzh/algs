package me.siduzy.ch01.sec02;

import edu.princeton.cs.algs4.StdOut;

public class E010204 {

    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
