package me.siduzy;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (qId != pId) {
            for (int i = 0; i < id.length; ++i) {
                if (id[i] == pId) {
                    id[i] = qId;
                }
            }
            count--;
        }
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind qf = new QuickFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (qf.connected(p, q)) {
                continue;
            }
            qf.union(p, q);
            StdOut.println(qf.count());
            StdOut.println(p + " " + q);
        }
    }
}
