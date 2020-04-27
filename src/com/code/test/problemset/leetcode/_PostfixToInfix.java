package com.code.test.problemset.leetcode;

import java.util.Stack;

public class _PostfixToInfix {

    public static void main(String[] args) {
        System.out.println(getInfix("abcd^e-fgh*+^*+i-"));
        //  a+b*(c^d-e)^(f+g*h)-i
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0;
        int z = a + b * (c ^ d - e) ^ (f + g * h) - i;
    }

    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }

    // Get Infix for a given postfix
    // expression
    static String getInfix(String exp) {
        Stack<String> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            // Push operands
            if (isOperand(exp.charAt(i))) {
                s.push(exp.charAt(i) + "");
            }

            // We assume that input is
            // a valid postfix and expect
            // an operator.
            else {
                String op1 = s.pop();
                String op2 = s.pop();
                s.push("(" + op2 + exp.charAt(i) +
                        op1 + ")");
            }
        }

        // There must be a single element
        // in stack now which is the required
        // infix.
        return s.peek();
    }
}
