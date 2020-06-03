package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010114_lg {
    public static int lg(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("expect n > 0");
        }
        int cnt = 0, val = 1;
        while ((val = val << 1) <= n) {
            cnt++;
        }
        return cnt;
    }

    public static int lg2(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("expect n > 0");
        }
        int ret = 0;
        while (n > 0) {
            n /= 2;
            ret++;
        }
        return ret - 1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1025; i++) {
            StdOut.println("i: " + i + " -> " + lg(i));
        }
        for (int i = 1; i < 1025; i++) {
            StdOut.println("i: " + i + " -> " + lg2(i));
        }
    }
}
