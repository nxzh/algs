package me.siduzy;

public class Matrix {
    public static double dot(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }


    public static double[][] mult(double[][] a, double[][] b) {
        if (a == null || b == null || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        double[][] bT = transpose(b);
        double[][] res = new double[a.length][bT.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < bT.length; j++) {
                res[i][j] = dot(a[i], bT[j]);
            }
        }
        return res;
    }

    public static double[][] transpose(double[][] a) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            throw new IllegalArgumentException();
        }
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }

    public static double[] mult(double[][] a, double[] x) {
        if (a == null || x == null || a[0].length != x.length) {
            throw new IllegalArgumentException();
        }

        double[] res = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = dot(a[i], x);
        }
        return res;
    }

    public static double[] mult(double[] y, double[][] a) {
        if (y == null || a == null || y.length != a[0].length) {
            throw new IllegalArgumentException();
        }
        double[] res = new double[a[0].length];
        double[][] aT = transpose(a);
        for (int i = 0; i < res.length; i++) {
            res[i] = dot(y, aT[i]);
        }
        return res;
    }
}
