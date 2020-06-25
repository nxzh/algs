package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdIn;
import me.siduzy.collection.ArrayQueue;
import me.siduzy.collection.Queue;

public class E010315 {
    public static String printReverseKth(Queue<String> queue, int k) {
        int n = queue.size() - k;
        int i = 0;
        while (i++ < n) {
            queue.dequeue();
        }
        return queue.dequeue();
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String[] input = StdIn.readAllStrings();
        Queue<String> queue = new ArrayQueue<>();
        for (String s : input) {
            queue.enqueue(s);
        }
        String result = printReverseKth(queue, k);
        System.out.println(result);
    }
}
