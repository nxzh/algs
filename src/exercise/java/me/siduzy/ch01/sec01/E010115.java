package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class E010115 {
    public static int[] histogram(int[] a, int m) {
        int[] ret = new int[m];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < m) {
                ret[a[i]]++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ary = new int[]{1, 3, 4, 3, 5, 7, 10, 30};
        int[] ret = histogram(ary, 2);
        StdOut.println(Arrays.toString(ret));
    }
}
