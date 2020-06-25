package me.siduzy.ch01.sec03;

import java.util.Scanner;
import java.util.Stack;

public class E010304 {

    public static boolean parentheses(String line) {
        Stack<Character> stack = new Stack<>();
        for (char e : line.toCharArray()) {
            switch (e) {
                case '}': {
                    char ch = stack.pop();
                    if (ch != '{') {
                        return false;
                    }
                    break;
                }
                case ']': {
                    char ch = stack.pop();
                    if (ch != '[') {
                        return false;
                    }
                    break;
                }
                case ')': {
                    char ch = stack.pop();
                    if (ch != '(') {
                        return false;
                    }
                    break;
                }
                default:
                    stack.push(e);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(E010304.parentheses(line));
    }
}
