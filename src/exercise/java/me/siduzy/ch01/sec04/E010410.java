package me.siduzy.ch01.sec04;

import edu.princeton.cs.algs4.StdOut;

public class E010410 {

    public static int binarySearch(int[] ary, int k) {
        int lo = 0;
        int hi = ary.length - 1;
        int lastFind = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (ary[mid] > k) {
                hi = mid - 1;
            } else if (ary[mid] < k) {
                lo = mid + 1;
            } else {
                if (mid == lastFind) {
                    return lastFind;
                } else {
                    lastFind = hi = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ary = new int[]{-1, 1, 1, 1, 2};
        StdOut.println(binarySearch(ary, 1));
    }
}
