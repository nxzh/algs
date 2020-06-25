package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E010124 {
    public static int gcd(int a, int b) {
        System.out.printf("a: %s, b: %d%n", a, b);
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        StdOut.printf("Please input the first number: ");
        int a = StdIn.readInt();
        StdOut.printf("Please input the second number: ");
        int b = StdIn.readInt();
        int gcd = gcd(a, b);
        System.out.println(gcd);
    }
}
