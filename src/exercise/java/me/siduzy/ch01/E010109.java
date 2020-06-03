package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010109 {

    public static String toBinary(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("expect n > 0 but got " + n);
        }
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            builder.insert(0, n % 2);
            n = n >> 1;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        StdOut.println(toBinary(6));
        StdOut.println(toBinary(9));
        StdOut.println(toBinary(255));
    }
}
