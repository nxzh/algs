package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010103 {

    private static void printEqual(int a, int b, int c) {
        if (a == b && b == c) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            StdOut.println("Expecting 3 arguments but actually got " + args.length);
            System.exit(-1);
        }
        printEqual(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }
}
