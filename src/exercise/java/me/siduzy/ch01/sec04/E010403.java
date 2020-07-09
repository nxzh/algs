package me.siduzy.ch01.sec04;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class E010403 {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        int N = 8000;
        Double[] timePoints = new Double[N];
        StdDraw.setCanvasSize(1024, 1024);
        for (int i = 0; i < N; i++) {
            timePoints[i] = timeTrial(i);
        }
        StdDraw.setPenRadius(0.03);
        StdDraw.setXscale(-2, N + 2);
        StdDraw.setYscale(0, timePoints[N - 1]); // timing
        StdDraw.line(0, 0, N, 0);
        StdDraw.line(0, 0, 0, timePoints[N-1]);
        for (int i = 1; i < N; i++) {
            StdDraw.line(i-1, timePoints[i-1], i, timePoints[i]);
        }
    }
}
