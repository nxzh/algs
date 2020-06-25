package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdOut;

public class E010113_matrix_transpose {
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                StdOut.print(matrix[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        int[][] result = transpose(new int[][]{
                {1, 2, 3, 4},
                {2, 2, 3, 4},
                {3, 2, 3, 4},
                {4, 2, 3, 4}

        });
        print(result);
    }
}
