package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdOut;

public class E010105 {

    public static void printStrictlyBetween(double d1, double d2) {
        if (d1 > 0 && d1 < 1 && d2 > 0 && d2 < 1) {
            StdOut.println(true);
        } else {
            StdOut.println(false);
        }
    }

    public static void main(String[] args) {
        printStrictlyBetween(1.00000001, 0.99999999);   // false
        printStrictlyBetween(0.9999999999999999, 0.9999999999999999); // true
        printStrictlyBetween(0.99999999999999999, 0.99999999999999999); // false
    }
}
