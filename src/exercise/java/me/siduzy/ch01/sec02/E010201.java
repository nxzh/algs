package me.siduzy.ch01.sec02;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class E010201 {

    public static final int CANVAS_SIZE = 2000;
    public static final int SCALE_SIZE = 100;

    public static Point2D p1;
    public static Point2D p2;



    public static double getShortest(Point2D[] points) {
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; ++j) {
                double dist = points[i].distanceTo(points[j]);
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
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(StdRandom.uniform(SCALE_SIZE), StdRandom.uniform(SCALE_SIZE));
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
            StdDraw.point(points[i].x(), points[i].y());
        }
        System.out.println("Shortest distance is " + getShortest(points));
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(p1.x(), p1.y());
        StdDraw.point(p2.x(), p2.y());
    }
}
