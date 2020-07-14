package me.siduzy.ch01.sec05;

import edu.princeton.cs.algs4.StdOut;

public class E010512 {
    private int[] id;
    private int count;

    public E010512(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < id.length; ++i) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int nextP = id[p];
            id[p] = root;
            p = nextP;
        }
        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            id[rootP] = rootQ;
            count--;
        }
    }


    public static void main(String[] args) {
        E010512 qu = new E010512(16);
        for (int i = 0; i < 15; i++) {
            qu.union(i, i + 1);
        }
        // 0-1, 2-3, 4-5, 6-7,
        for (int i = 0; i < 15; i += 2) {
            qu.union(i, i + 1);
        }
        // 0-3, 4-7, 8-11, 12-15
        for (int i = 0; i < 13; i += 4) {
            qu.union(i, i + 2);
        }
        // 0-7, 8-15
        for (int i = 0; i < 9; i += 8) {
            qu.union(i, i + 4);
        }
        qu.union(0, 8);
        StdOut.println(qu.count);
    }
}