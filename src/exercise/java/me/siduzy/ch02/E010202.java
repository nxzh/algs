package me.siduzy.ch02;

import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class E010202 {


    private static class Interval {
        private double begin;
        private double end;

        public Interval(double d1, double d2) {
            this.begin = Math.min(d1, d2);
            this.end = Math.max(d1, d2);
        }

        public Interval inter(Interval interval) {
            Interval first, second;
            if (this.begin < interval.begin) {
                first = this;
                second = interval;
            } else {
                first = interval;
                second = this;
            }
            if (first.end >= second.begin) {
                return new Interval(second.begin, Math.min(first.end, second.end));
            }
            return null;
        }

        public Interval union(Interval interval) {
            return new Interval(Math.min(this.begin, interval.begin), Math.max(this.end, interval.end));
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Interval.class.getSimpleName() + "[", "]")
                    .add("d1=" + begin)
                    .add("d2=" + end)
                    .toString();
        }
    }


    public static void main(String[] args) {
        double[] input = StdIn.readAllDoubles();
        if ((input.length & 0x1) == 1) {
            throw new IllegalArgumentException();
        }
        Interval[] interval = composeIntervals(input);
        Arrays.sort(interval, Comparator.comparingDouble(i -> i.begin));
        List<Interval> intersects = getIntersects(interval);
        System.out.println(intersects);
    }

    private static Interval[] composeIntervals(double[] input) {
        Interval[] interval = new Interval[input.length / 2];
        for (int i = 0; i < interval.length; i++) {
            interval[i] = new Interval(input[i * 2], input[i * 2 + 1]);
        }
        return interval;
    }

    private static List<Interval> getIntersects(Interval[] interval) {
        Interval unioned = interval[0];
        List<Interval> intersects = new ArrayList<>();
        for (int i = 1; i < interval.length; i++) {
            intersects.add(unioned.inter(interval[i]));
            unioned = unioned.union(interval[i]);
        }
        return intersects;
    }
}
