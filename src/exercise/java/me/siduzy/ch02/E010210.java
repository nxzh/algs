package me.siduzy.ch02;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class E010210 {

    public static class VisualCounter {
        private int value;
        private int count;
        private final int N;
        private final int max;

        public VisualCounter(int N, int max) {
            this.N = N;
            this.max = max;
            StdDraw.setCanvasSize(1024, 1024);
            StdDraw.setXscale(-2, N + 2);
            StdDraw.setYscale(-max - 3, max + 3);
            StdDraw.setPenRadius(0.01);
        }

        public void increase() {
            if (count < N && (Math.abs(value) < max || -value == max)) {
                value++;
                count++;
            }
            StdDraw.point(count, value);
        }

        public void descrease() {
            if (count < N && (Math.abs(value) < max || value == max)) {
                --value;
                count++;
            }
            StdDraw.point(count, value);
        }
    }

    public static void main(String[] args) {
        VisualCounter vc = new VisualCounter(100, 50);
        for (int i = 0; i < 200; ++i) {
            if ((StdRandom.uniform(2) & 0x01) == 0) {
                vc.increase();
            } else {
                vc.descrease();
            }
        }
    }
}
