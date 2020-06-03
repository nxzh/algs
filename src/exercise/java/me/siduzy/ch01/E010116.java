package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010116 {

    // exR1(6)
    // exR1(3) + 6 + exR1(4) + 6
    // {exR1(0) + 3 + [exR1(1)] + 3} + 6 + {[exR1(1)] + 4 + [exR1(2)] + 4} + 6
    // {exR1(0) + 3 + [ex(-2) + 1 + exR1(-1) +1)] + 3} + 6 + {[exR1(-2) + 1 + exR1(-1) + 1] + 4 + [exR1(-1) + 2 + exR1(0) + 2] + 4} + 6
    // "3" + "113" + 6 + "114" + "224" + 6
    // 311361142246
    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        StdOut.println(exR1(6));
    }
}
