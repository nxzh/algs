package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;
import me.siduzy.collection.ArrayQueue;
import me.siduzy.collection.Queue;

import java.util.Arrays;

public class E010317 {

    public static Transaction[] readTransactions() {
        Queue<Transaction> queue = new ArrayQueue<>();
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] params = line.split(",");
            String name = params[0];
            Date date = new Date(params[1]);
            Double amount = Double.valueOf(params[2]);
            Transaction transaction = new Transaction(name, date, amount);
            queue.enqueue(transaction);
        }
        int N = queue.size();
        Transaction[] transactions = new Transaction[N];
        for (int i = 0; i < N; i++) {
            transactions[i] = queue.dequeue();
        }
        return transactions;
    }

    public static void main(String[] args) {
        Transaction[] transactions = readTransactions();
        StdOut.println(Arrays.toString(transactions));
    }
}
