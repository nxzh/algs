package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.awt.*;
import java.util.Arrays;

public class E010132 {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
//        double[] data = StdIn.readAllDoubles();
        double[] data = new double[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = StdRandom.uniform(l, r);
        }

        int[] histogram = toHistogram(l, r, N, data);
        System.out.println(Arrays.toString(histogram));
        drawHistogram(l, r, N, histogram);
    }

    private static void drawHistogram(double l, double r, int N, int[] histogram) {
        int maxH = StdStats.max(histogram);
        double stepX = stepX(N, l, r);
        double stepY = maxH > 50 ? maxH / 10 : 1;
        StdDraw.setCanvasSize(2000, 2000);
        int lSteps = 0;
        while (lSteps * stepX > l) {
            --lSteps;
        }

        StdDraw.setXscale(lSteps - 2, N + lSteps + 3);
        StdDraw.setYscale(-2 * stepY, StdStats.max(histogram) + 2*stepY);
        StdDraw.setPenColor(Color.BLUE);
        for (int i = 0; i < histogram.length; i++) {
            double x = l + i * stepX + stepX / 2;
            StdDraw.filledRectangle(x / stepX, (double) histogram[i] / 2, 0.5, (double) histogram[i] / 2);
        }


        StdDraw.setPenColor(Color.RED);
        StdDraw.line(lSteps - 1, 0, N + lSteps + 2, 0);
        StdDraw.line(0, -stepY, 0, maxH + 1);
        for (int i = 0; i > lSteps - 1; --i) {
            StdDraw.text(i, -0.5 * stepY, i * stepX + "", 90);
        }
        for (int i = 0; i < N + lSteps + 2; ++i) {
            StdDraw.text(i, -0.5 * stepY, i * stepX + "", 90);
        }
        for (int i = 0; i < maxH + 2; i++) {
            StdDraw.text(-0.5, i * stepY, i * stepY + "");
        }
    }

    private static double stepX(int n, double l, double r) {
        return (r - l) / n;
    }

    private static int[] toHistogram(double l, double r, int N, double[] data) {
        int[] histogram = new int[N];
        double step = stepX(N, l, r);
        for (double d : data) {
            if (d > l && d < r) {
                int pos = (int) ((d - l) / step);
                histogram[pos]++;
            }
        }
        return histogram;
    }
}
