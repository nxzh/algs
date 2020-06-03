package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010117 {
    public static String exR1(int n) {
        String s = exR1(n - 3) + n + exR1(n - 2) + n;
        if (n <= 0) return ""; // this line will never be called.
        return s;
    }

    public static void main(String[] args) {
        StdOut.println(exR1(6));
    }
}
