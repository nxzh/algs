package me.siduzy;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUF {

    private int id[];
    private int sz[];
    private int count;

    public WeightedQuickUF(int n) {
        id = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            if (sz[p] > sz[q]) {
                id[rootQ] = rootP;
                sz[p] += sz[q];
            } else {
                id[rootP] = rootQ;
                sz[q] += sz[p];
            }
            count--;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUF qf = new WeightedQuickUF(N);
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
