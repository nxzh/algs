package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010119_fibonacci {
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long fibonacci(int n) {
        long f = 0;
        long g = 1;
        for (int i = 0; i < n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    public static void main(String[] args) {

        for (int N = 0; N < 100; N++) {
            StdOut.println(N + " " + fibonacci(N));
        }
        for (int N = 0; N < 100; N++) {
            StdOut.println(N + " " + F(N));
        }
    }
}
