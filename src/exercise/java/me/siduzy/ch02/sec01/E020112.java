package me.siduzy.ch02.sec01;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class E020112 {

    public static void shellSort(double[] ary) {
        int n = ary.length;
        long[] cmpTimes = new long[n];
        int h = 0;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = h; i < n; ++i) {
                for (int j = i; j - h >= 0; j -= h) {
                    cmpTimes[j - h]++;
                    cmpTimes[j]++;
                    if (Double.compare(ary[j - h], ary[j]) > 0) {
                        swap(j - h, j, cmpTimes);
                        swap(j - h, j, ary);
                    }
                }
            }
            h = h / 3;
        }
        printRate(cmpTimes);
    }

    private static void swap(int i, int j, long ary[]) {
        long temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    private static void swap(int i, int j, double ary[]) {
        double temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    public static void main(String[] args) {
        for (int i = 100; i <= 10000; i *= 10) {
            int n = i;
            double[] ary = new double[n];
            for (int j = 0; j < n; j++) {
                ary[j] = StdRandom.uniform();
            }
            shellSort(ary);
        }
    }

    private static void printRate(long[] compareTimes) {
        StdOut.println("------------------------------------------------------------");
        int n = compareTimes.length;
        for (int i = 0; i < n; i++) {
            StdOut.println(i + "\t\t\t\t" + compareTimes[i] / (double) n);
        }
    }
}
