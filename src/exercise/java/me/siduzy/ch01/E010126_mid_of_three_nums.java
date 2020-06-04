package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010126_mid_of_three_nums {
    public static int getMid(int a, int b, int c) {
        int t;
        if (a > b) {  // make sure a <= b
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {  // make sure a <= c, since a <= b, so now a is the smallest
            t = a;
            a = c;
            c = t;
        }
        if (b > c) { // then we compare b and c, the smaller one is the second largest one.
            t = b;
            b = c;
            c = t;
        }
        return b;
    }

    public static void main(String[] args) {

        StdOut.println(getMid(2,2,2));

        StdOut.println(getMid(1,1,2));
        StdOut.println(getMid(1,2,2));
        StdOut.println(getMid(2,2,1));
        StdOut.println(getMid(2,1,1));
        StdOut.println(getMid(1,2,1));
        StdOut.println(getMid(2,1,2));

        StdOut.println(getMid(1, 2, 3));
        StdOut.println(getMid(1, 3, 2));
        StdOut.println(getMid(2, 1, 3));
        StdOut.println(getMid(2, 3, 1));
        StdOut.println(getMid(3, 1, 2));
        StdOut.println(getMid(3, 2, 1));
    }
}
