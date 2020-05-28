package com.code.test.problemset.CrackingCodingInterview6.ch16;

import java.util.Stack;

/**
 * Calculator:
 * Given an arithmetic equation consisting of positive integers,+,-,* and/ (no parentheses),
 * compute the result.
 * EXAMPLE
 * Input:2*3+5/6*3+15
 * Output:23.5
 */
public class Q26_Calculator {
    public enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK
    }

    public static double compute(String sequence) {
        Stack<Double> numberStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();

        for (int i = 0; i < sequence.length(); i++) {
            try {
                /* Get number and push. */
                int value = parseNextNumber(sequence, i);
                numberStack.push((double) value);

                /* Move to the operator. */
                i += Integer.toString(value).length();
                if (i >= sequence.length()) {
                    break;
                }

                /* Get operator, collapse top as needed, push operator. */
                Operator op = parseNextOperator(sequence, i);
                collapseTop(op, numberStack, operatorStack);
                operatorStack.push(op);
            } catch (NumberFormatException ex) {
                return Integer.MIN_VALUE;
            }
        }

        /* Do final collapse. */
        collapseTop(Operator.BLANK, numberStack, operatorStack);
        if (numberStack.size() == 1 && operatorStack.size() == 0) {
            return numberStack.pop();
        }
        return 0;
    }

    /* Collapse top until priority(futureTop) > priority(top).
     * Collapsing means to pop the top 2 numbers and apply the
     * operator popped from the top of the operator stack, and then
     * push that onto the numbers stack.*/
    public static void collapseTop(Operator futureTop, Stack<Double> numberStack, Stack<Operator> operatorStack) {
        while (operatorStack.size() >= 1 && numberStack.size() >= 2) {
            if (priorityOfOperator(futureTop) <= priorityOfOperator(operatorStack.peek())) {
                double second = numberStack.pop();
                double first = numberStack.pop();
                Operator op = operatorStack.pop();
                double collapsed = applyOp(first, op, second);
                numberStack.push(collapsed);
            } else {
                break;
            }
        }
    }

    /* Return the operator that occurs as offset. */
    public static Operator parseNextOperator(String sequence, int offset) {
        if (offset < sequence.length()) {
            char op = sequence.charAt(offset);
            switch (op) {
                case '+':
                    return Operator.ADD;
                case '-':
                    return Operator.SUBTRACT;
                case '*':
                    return Operator.MULTIPLY;
                case '/':
                    return Operator.DIVIDE;
            }
        }
        return Operator.BLANK;
    }

    /* Apply operator: left [op] right. */
    public static double applyOp(double left, Operator op, double right) {
        if (op == Operator.ADD) {
            return left + right;
        } else if (op == Operator.SUBTRACT) {
            return left - right;
        } else if (op == Operator.MULTIPLY) {
            return left * right;
        } else if (op == Operator.DIVIDE) {
            return left / right;
        } else {
            return right;
        }
    }

    /* Return priority of operator. Mapped so that:
     *     addition == subtraction < multiplication == division. */
    public static int priorityOfOperator(Operator op) {
        switch (op) {
            case ADD:
                return 1;
            case SUBTRACT:
                return 1;
            case MULTIPLY:
                return 2;
            case DIVIDE:
                return 2;
            case BLANK:
                return 0;
        }
        return 0;
    }

    public static int parseNextNumber(String sequence, int offset) {
        StringBuilder sb = new StringBuilder();
        while (offset < sequence.length() && Character.isDigit(sequence.charAt(offset))) {
            sb.append(sequence.charAt(offset));
            offset++;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
//        String expression = "6/5*3+4*5/2-12/6*3/3+3+3";
        String expression = "2*3+5/6*3+15";
        double result = compute(expression);
        System.out.println(result);
    }
}
