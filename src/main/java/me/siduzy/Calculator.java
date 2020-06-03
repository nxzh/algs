package me.siduzy;

import me.siduzy.collection.ArrayStack;
import me.siduzy.collection.Stack;

/**
 * Dijkstra Double Stack Calculator.
 */
public class Calculator {

    private Stack<Double> vals = new ArrayStack<>();
    private Stack<String> ops = new ArrayStack<>();

    /**
     * Calculate the value of expression which is in String format.
     * Operator and value in the expression need to be separated by ' '.
     * Here're some examples:
     * Expression : ( 1 + ( 2 * ( 3 + 5 ) ) ) , Value : 17.0
     * Expression : ( 1.0  + ( 2.0 * ( 3.00 + 5.00 ) ) ), Value : 17.0
     *
     * @param exprStr expression in string
     * @return value of the expression
     */
    public double calculate(String exprStr) {
        String[] expression = exprStr.split("\\s+");
        for (String e : expression) {
            switch (e) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(e);
                    break;
                case ")":
                    vals.push(calc(vals.pop(), ops.pop()));
                    break;
                default:
                    vals.push(Double.valueOf(e));
            }
        }
        return vals.pop();
    }

    private Double calc(Double val1, String op) {
        switch (op) {
            case "+":
                return vals.pop() + val1;
            case "-":
                return vals.pop() - val1;
            case "*":
                return vals.pop() * val1;
            case "/":
                return vals.pop() / val1;
            case "sqrt":
                return Math.sqrt(val1);
        }
        throw new IllegalArgumentException();
    }
}
