package me.siduzy.ch01.sec03;

import me.siduzy.collection.ArrayStack;
import me.siduzy.collection.Stack;

public class E010311 {
    public static Double evaluatePostfix(String postfix) {
        Stack<Double> operandStack = new ArrayStack<>();
        Stack<String> operatorStack = new ArrayStack<>();
        String[] postfixElems = postfix.split("\\s+");
        for (String e : postfixElems) {
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
                case ")":
                    Double i1 = operandStack.pop();
                    String op = operatorStack.pop();
                    switch (op) {
                        case "+":
                            operandStack.push(operandStack.pop() + i1);
                            break;
                        case "-":
                            operandStack.push(operandStack.pop() - i1);
                            break;
                        case "*":
                            operandStack.push(operandStack.pop() * i1);
                            break;
                        case "/":
                            operandStack.push(operandStack.pop() / i1);
                            break;
                        case "sqrt":
                            operandStack.push(Math.sqrt(i1));
                            break;
                    }
                    break;
                default:
                    operandStack.push(Double.valueOf(e));
                    break;
            }
        }
        return operandStack.pop();
    }

    public static void main(String[] args) {
        Double val = evaluatePostfix("( / ( + 4 3 ) ( * ( - 6 5 ) ( - ( sqrt 16 ) 3 ) ) )");
        System.out.println(val);
    }
}
