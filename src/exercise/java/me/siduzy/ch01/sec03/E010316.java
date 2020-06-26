package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import me.siduzy.collection.ArrayQueue;
import me.siduzy.collection.Queue;

public class E010316 {
    public static Date[] readDates() {
        Queue<Date> queue = new ArrayQueue<>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(new Date(StdIn.readLine()));
        }
        int N = queue.size();
        Date[] dates = new Date[N];
        for (int i = 0; i < N; i++) {
            dates[i] = queue.dequeue();
        }
        return dates;
    }


    public static void main(String[] args) {
        Date[] dates = readDates();
        for (Date d : dates) {
            StdOut.println(d);
        }
    }
}
