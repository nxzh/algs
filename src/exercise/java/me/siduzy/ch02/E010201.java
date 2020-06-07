package me.siduzy.ch02;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class E010201 {

    public static final int CANVAS_SIZE = 2000;
    public static final int SCALE_SIZE = 100;

    public static int[] p1;
    public static int[] p2;

    private static double distance(int[] p1, int[] p2) {
        return Math.sqrt((Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2)));
    }

    public static double getShortest(int[][] points) {
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; ++j) {
                double dist = distance(points[i], points[j]);
                if (dist < minDist) {
                    minDist = dist;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = StdRandom.uniform(SCALE_SIZE);
            points[i][1] = StdRandom.uniform(SCALE_SIZE);
        }
        StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
        StdDraw.setScale(0, SCALE_SIZE);
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        for (int i = 0; i < SCALE_SIZE; i++) {
            StdDraw.line(i, 0, i, SCALE_SIZE);
            StdDraw.line(0, i, SCALE_SIZE, i);
        }
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(Color.BLUE);
        for (int i = 0; i < N; i++) {
            StdDraw.point(points[i][0], points[i][1]);
        }
        System.out.println("Shortest distance is " + getShortest(points));
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(p1[0], p1[1]);
        StdDraw.point(p2[0], p2[1]);
    }
}
