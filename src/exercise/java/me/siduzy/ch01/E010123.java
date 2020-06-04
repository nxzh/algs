package me.siduzy.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import me.siduzy.Search;

import java.util.Arrays;

public class E010123 {
    public static void main(String[] args) {
        String val = args[0];
        if (!"-".equals(val) && !"+".equals(val)) {
            throw new IllegalArgumentException("absent flag should be -/+");
        }
        boolean onlyPrintAbsent = "+".equals(args[0]);
        int[] whitelist = new In(args[1]).readAllInts();
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            boolean absent = Search.binarySearchInLoop(whitelist, value) == -1;
            if (absent && onlyPrintAbsent) {
                StdOut.println(value);
            } else if (!absent && !onlyPrintAbsent) {
                StdOut.println(value);
            }
        }
    }
}
