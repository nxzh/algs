package me.siduzy.ch03;

import me.siduzy.collection.ArrayStack;
import me.siduzy.collection.Stack;

public class E010310 {

    public static String infixToPostfix(String infixExpr) {
        Stack<String> operandStack = new ArrayStack<>();
        Stack<String> operatorStack = new ArrayStack<>();
        String[] infixElems = infixExpr.split("\\s+");
        for (String e : infixElems) {
            switch (e) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operatorStack.push(e);
                    break;
                case ")": {
                    toPost(operandStack, operatorStack);
                }
                break;
                default:
                    operandStack.push(e);
            }
        }
        return operandStack.pop();
    }

    private static void toPost(Stack<String> operandStack, Stack<String> operatorStack) {
        String e1 = operandStack.pop();
        String op = operatorStack.pop();
        switch (op) {
            case "+":
            case "-":
            case "*":
            case "/":
                operandStack.push(String.join(" ", "(", op, e1, operandStack.pop(), ")"));
                break;
            case "sqrt":
                operandStack.push(String.join(" ", "(", op, e1, ")"));
                break;
        }
    }

    public static void main(String[] args) {
        String val = infixToPostfix("( ( 3 + 4 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )");
        System.out.println(val);
    }
}
