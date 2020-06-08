package me.siduzy.ch02;

import edu.princeton.cs.algs4.StdOut;

public class E010209 {

    public static class Counter {
        int examed;
    }

    public static int rank(int k, int[] a, Counter counter) {
        int lo = 0, hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            counter.examed++;
            if (a[mid] > k) {
                hi = mid - 1;
            } else if (a[mid] < k) {
                counter.examed++;
                lo = mid + 1;
            } else {
                counter.examed++;
                return mid;
            }
        }
        return -1; // a[0]
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        rank(2, new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3}, counter);
        StdOut.println(counter.examed);
    }
}
