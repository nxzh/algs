package me.siduzy.ch02.sec01;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class E020111 {

    private static int[] hs = new int[20];

    static {
        hs[0] = 1;
        for (int i = 1; i < hs.length; i++) {
            hs[i] = hs[i - 1] * 3 + 1;
        }
    }

    public static void shellSort(int[] a) {
        int hi = 0;
        for (int i = 1; i < hs.length; hi = i, i++) {
            if (hs[i] >= a.length) {
                break;
            }
        }
        while (hi >= 0) {
            int h = hs[hi];
            for (int i = h; i < a.length; i++) {
                for (int j = i; j - h >= 0; j -= h) {
                    if (a[j - h] > a[j]) {
                        swap(j - h, j, a);
                    }
                }
            }
            hi--;
        }
    }

    private static void swap(int i, int j, int[] ary) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    public static void main(String[] args) {
        StdOut.println(Arrays.toString(hs));
        int[] ary = {13, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        shellSort(ary);
        StdOut.println(Arrays.toString(ary));
    }


}
