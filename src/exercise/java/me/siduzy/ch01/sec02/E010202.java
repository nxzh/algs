package me.siduzy.ch01.sec02;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Comparator;

public class E010202 {

    public static void main(String[] args) {
        double[] input = StdIn.readAllDoubles();
        if ((input.length & 0x1) == 1) {
            throw new IllegalArgumentException();
        }
        Interval1D[] interval = composeIntervals(input);
        Arrays.sort(interval, Comparator.comparingDouble(i -> i.min()));
        printIntersects(interval);
    }

    private static Interval1D[] composeIntervals(double[] input) {
        Interval1D[] interval = new Interval1D[input.length / 2];
        for (int i = 0; i < interval.length; i++) {
            interval[i] = new Interval1D(input[i * 2], input[i * 2 + 1]);
        }
        return interval;
    }

    private static void printIntersects(Interval1D[] interval) {
        for (int i = 0; i < interval.length; i++) {
            for (int j = i + 1; j < interval.length; j++) {
                if (interval[i].intersects(interval[j])) {
                    System.out.println(interval[i] + " - " + interval[j]);
                } else {
                    break;
                }
            }
        }
    }
}
