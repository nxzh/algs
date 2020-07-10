package me.siduzy.ch01.sec04;

import edu.princeton.cs.algs4.StdOut;

public class E010412 {

    public static void printCommon(int[] ary1, int[] ary2) {
        int i = 0, j = 0;
        int c;
        while (i < ary1.length && j < ary2.length) {
            if (ary1[i] != ary2[j]) {
                if (ary1[i] < ary2[j]) {
                    i++;
                } else if (ary1[i] > ary2[j]) {
                    j++;
                }
            } else {
                c = ary1[i];
                StdOut.println(c);
                while (i < ary1.length && ary1[i] == c) {
                    ++i;
                }
                while (j < ary2.length && ary2[j] == c) {
                    ++j;
                }
            }
        }
    }

    public static void main(String[] args) {
        printCommon(new int[]{0, 1, 1, 2, 2, 2, 3}, new int[]{-1, 1, 2, 4});
        printCommon(new int[]{0}, new int[]{1});
        printCommon(new int[]{1}, new int[]{1});
    }
}
