package com.code.test.problemset.leetcode.hard;

import com.code.test.problemset.leetcode.Hard;

import java.util.Stack;

/**
 *  Basic Calculator
 * https://leetcode.com/problems/basic-calculator/description/
 */
@Hard
public class _InfixToPostfix {

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix_Ali(exp));
    }

    static String infixToPostfix_Ali(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            } else { //operand
                if (ch == '(') {
                    stack.push('(');
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result += stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek() != '(') {
                        return "Invalid Expression"; // invalid expression
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && prec(stack.peek()) >= prec(ch)) {
                        if (stack.peek() == '(') {
                            return "Invalid Expression";
                        }
                        result += stack.pop();
                    }
                    stack.push(ch);
                }
            }
        }
        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result += stack.pop();
        }
        return result;
    }

    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }


}
