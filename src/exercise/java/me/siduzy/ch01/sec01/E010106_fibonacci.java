package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdOut;

public class E010106_fibonacci {

    /**
     * Print Fibonacci
     * @param n
     * @see  {@link E010119_fibonacci}
     */
    public static void fibonacci(int n) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= n; i++) {
            StdOut.println(f);  //      f: 0 1 1 2 3 5 8  13 21
                                //      g: 1 0 1 1 2 3 5  8  13
            f = f + g;          //  new f: 1 1 2 3 5 8 13 21 34
            g = f - g;          //  new g: 0 1 1 2 3 5 8  13 21
        }
    }


    public static void main(String[] args) {
        fibonacci(15);
    }
}
