package com.code.test.problemset.CrackingCodingInterview6.ch3;

import java.util.Stack;

/**
 * Sort Stack:
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class Q5_SortStack {

    static Stack<Integer> stack = new Stack<>();

    public static void sort() {
        Stack<Integer> r = new Stack<>();
        while (!stack.isEmpty()) {
            /* Insert each element in s in sorted order into r. */
            int tmp = stack.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                stack.push(r.pop());
            }
            r.push(tmp);
        }

        /* Copy the elements back. */
        while (!r.isEmpty()) {
            stack.push(r.pop());
        }
    }
}
