package me.siduzy.ch01.sec04;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class E010408 {

    public static int countEqualNumber(int[] ary) {
        int count = 0;
        for (int i = 0; i < ary.length; i++) {
            for (int j = i + 1; j < ary.length; j++) {
                if (ary[j] == ary[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countEqualNumber2(int[] ary) {
        Arrays.sort(ary);
        int count = 0;
        int i = 0, j = 0;
        while (j < ary.length) {
            if (ary[j] != ary[i]) {
                int n = j - i;
                count += n * (n - 1) / 2;
                i = j;
            }
            j++;
        }
        int n = j - i;
        count += n * (n - 1) / 2;
        return count;
    }

    public static void main(String[] args) {
        int n = countEqualNumber(new int[]{1, 2, 3, 1, 1, 1, 2});
        StdOut.println(n);
        n = countEqualNumber2(new int[]{1, 2, 3, 1, 1, 1, 2});
        StdOut.println(n);
    }
}
