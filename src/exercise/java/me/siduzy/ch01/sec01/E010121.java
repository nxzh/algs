package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E010121 {

    public static String row(String[] input) {
        return String.format("%s, %.3f%n", String.join(", ", input), Double.parseDouble(input[1]) / Double.parseDouble(input[2]));
    }

    public static void main(String[] args) {
        String line;
        StringBuilder table = new StringBuilder();
        while ((line = StdIn.readLine()) != null) {
            table.append(row(line.split("\\s+")));
        }
        StdOut.print(table);
    }
}
