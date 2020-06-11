package me.siduzy.ch03;

import java.util.Stack;

public class E010302 {
    public static void main(String[] args) {
        String str = "it was - the best - of times - - - it was - the - -";
        String[] input = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (String e : input) {
            if (e.equals("-")) {
                System.out.println(stack.pop());
            } else {
                stack.push(e);
            }
        }
    }
}
