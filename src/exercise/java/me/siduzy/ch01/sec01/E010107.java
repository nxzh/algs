package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdOut;

public class E010107 {

    public static void a() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    public static void b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum); // 1000 * 999/2 = 499,500
    }

    public static void c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {// 1, 2, 4, 8, 16, 32, 64, 128, 256, 512
            for (int j = 0; j < 1000; j++) { //1000 * 10
                sum++;
            }
        }
        StdOut.println(sum);
    }

    public static void main(String[] args) {
        a();
        b();
        c();
    }
}
