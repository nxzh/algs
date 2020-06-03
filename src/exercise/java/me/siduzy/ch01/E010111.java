package me.siduzy.ch01;

import edu.princeton.cs.algs4.StdOut;

public class E010111 {

    public static void print(boolean[][] bool2dAry) {
        StringBuilder header = new StringBuilder();
        for (int i = 0; i < bool2dAry[0].length; ++i) {
            header.append('\t').append(i);
        }
        StdOut.println(header);
        for (int i = 0; i < bool2dAry.length; i++) {
            StringBuilder line = new StringBuilder(i + "");
            for (int j = 0; j < bool2dAry[i].length; j++) {
                char c = bool2dAry[i][j] ? '*' : ' ';
                line.append('\t').append(c);
            }
            StdOut.println(line);
        }
    }

    public static void main(String[] args) {
        E010111.print(new boolean[][]{
                {true, false, true, true},
                {false, true, false, true},
                {false, true, false, true}
        });
    }
}
