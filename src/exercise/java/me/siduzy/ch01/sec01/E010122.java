package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdOut;

public class E010122 {
    public static int rank(int n, int[] ary, int from, int to, int level) {
        if (from > to) {
            return -1;
        }
        StdOut.printf("lo:%d hi:%d lv:%d%n", from, to, level);
        int mid = from + (to - from) / 2;
        if (ary[mid] > n) {
            return rank(n, ary, from, mid - 1, level + 1);
        } else if (ary[mid] < n) {
            return rank(n, ary, mid + 1, to, level + 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        rank(1, new int[] {1, 2, 3, 4, 5, 6, 7}, 0, 6, 1);
    }
}
