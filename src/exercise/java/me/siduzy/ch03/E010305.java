package me.siduzy.ch03;


import edu.princeton.cs.algs4.StdOut;
import me.siduzy.collection.ArrayStack;
import me.siduzy.collection.Stack;

public class E010305 {
    public static void toBinaryString(int N) {
        Stack<Integer> stack = new ArrayStack<>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) {
            StdOut.print(d);
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        E010305.toBinaryString(255);
    }
}
