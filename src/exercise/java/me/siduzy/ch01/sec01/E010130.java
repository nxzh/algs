package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdOut;
import me.siduzy.Number;

public class E010130 {

    public static void setValue(boolean[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = false;
                } else {
                    matrix[i][j] = Number.gcd(i, j) == 1 ? true : false;
                }
            }
        }
    }

    public static void print(boolean[][] matrix, int N) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append("\t\t\t" + i);
        }
        StdOut.println(builder.toString());
        builder = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            builder.append(i +"\t\t");
            for (int j = 0; j < N; j++) {
                builder.append(matrix[i][j] +"\t\t");
            }
            builder.append("\n");
        }
        StdOut.println(builder);
    }

    public static void main(String[] args) {
        int N = 10;
        boolean[][] matrix = new boolean[N][N];
        setValue(matrix, N);
        print(matrix, N);
    }
}
