package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010129 {

    public static int rank(int k, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        if (k <= a[lo]) {
            return 0;
        }
        if (k > a[hi]) {
            return a.length;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= k) {
                if (a[mid - 1] < k) { //
                    return mid;
                }
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return 1;
    }

    public static void testRank() {
        StdOut.println(rank(1, new int[]{2}));      // 0
        StdOut.println(rank(2, new int[]{1}));      // 1

        StdOut.println(rank(1, new int[]{1, 2}));   // 0
        StdOut.println(rank(2, new int[]{1, 2}));   // 1
        StdOut.println(rank(2, new int[]{1, 3}));   // 1
        StdOut.println(rank(4, new int[]{1, 3}));   // 2

        StdOut.println(rank(2, new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2}));       // 1
        StdOut.println(rank(2, new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));    // 1
        StdOut.println(rank(3, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));    // 10
        StdOut.println(rank(2, new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3}));    // 2
        StdOut.println(rank(4, new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3}));    // 11
    }

    public static void main(String[] args) {
        
    }
}
