package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class E010134 {

    public static int getLargest(int[] ary) {
        int max = ary[0];
        for (int i = 0; i < ary.length; i++) {
            max = Math.max(max, ary[i]);
        }
        return max;
    }

    public static int getSmallest(int[] ary) {
        int min = ary[0];
        for (int i = 0; i < ary.length; i++) {
            min = Math.min(min, ary[i]);
        }
        return min;
    }

    public static int getMedians(int[] ary) {
        Arrays.sort(ary);
        int n = ary.length;
        if ((ary.length & 0x1) == 0) {
            return (ary[(n - 1) / 2] + ary[(n + 1) / 2]) / 2;
        }
        return ary[n / 2];
    }

    public static int getKthSmallest(int k, int[] ary) {
        if (k > ary.length) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.offer(ary[i]);
        }
        for (int i = k; i < ary.length; ++i) {
            if (ary[i] < queue.peek().intValue()) {
                queue.poll();
                queue.add(ary[i]);
            }
        }
        return queue.peek().intValue();
    }

    public static int getSumOfSquares(int[] ary) {
        int sum = 0;
        for (int i = 0; i < ary.length; i++) {
            sum += ary[i] * ary[i];
        }
        return sum;
    }

    public static double getAverage(int[] ary) {
        int sum = 0;
        for (int i = 0; i < ary.length; i++) {
            sum += ary[i];
        }
        return sum / (double) ary.length;
    }

    public static double getPercentage(int[] ary) {
        double average = getAverage(ary);
        Arrays.sort(ary);
        int n = E010129_binary_search.rankLarger((int) average, ary);
        return n / (double) ary.length;
    }

    public static int[] sort(int[] ary) {
        Arrays.sort(ary);
        return ary;
    }

    public static int[] random(int[] ary) {
        StdRandom.shuffle(ary);
        return ary;
    }

    public static void main(String[] args) {
        int largest = getLargest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(largest);
        int medianEven = getMedians(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(medianEven);
        int medianOdd = getMedians(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(medianOdd);

        double averageEven = getAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        double averageOdd = getAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(averageEven);
        System.out.println(averageOdd);

        int kSmallestEven = getKthSmallest(9, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        int kSmallestOdd = getKthSmallest(9, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(kSmallestEven);
        System.out.println(kSmallestOdd);

        int sum = getSumOfSquares(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(sum);
    }
}
