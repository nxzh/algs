package me.siduzy;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; ++i) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return false;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            id[rootP] = id[rootQ];
        }
    }


    public static void main(String[] args) {

        int N = StdIn.readInt();
        QuickUnion qf = new QuickUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (qf.connected(p, q)) {
                continue;
            }
            qf.union(p, q);
            StdOut.println(p + " " + q);
        }
    }
}
