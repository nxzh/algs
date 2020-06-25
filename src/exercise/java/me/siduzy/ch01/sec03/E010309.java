package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.StdOut;
import me.siduzy.collection.ArrayStack;
import me.siduzy.collection.Stack;

public class E010309 {
    public static String fixedParentheses(String str) {
        Stack<String> operandStack = new ArrayStack<>();
        Stack<String> operatorStack = new ArrayStack<>();
        String[] input = str.split("\\s");
        for (String s : input) {
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operatorStack.push(s);
                    break;
                case ")":
                    operandStack.push(getFixedOperand(operandStack, operatorStack));
                    break;
                default:
                    operandStack.push(s);
            }
        }
        return operandStack.pop();
    }

    private static String getFixedOperand(Stack<String> operandStack, Stack<String> operatorStack) {
        String operator = operatorStack.pop();
        String operand1 = operandStack.pop();
        String newOperand;
        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
                String operand2 = operandStack.pop();
                newOperand = String.join(" ", "(", operand2, operator, operand1, ")");
                break;
            case "sqrt":
                newOperand = String.join(" ", "(", operator, operand1, ")");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return newOperand;
    }

    public static void main(String[] args) {
        StdOut.println(fixedParentheses("3 + 4 ) * 3 - 4 ) * 5 - 6 ) ) )"));
    }
}
