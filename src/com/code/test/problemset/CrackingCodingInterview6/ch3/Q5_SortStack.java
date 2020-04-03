package com.code.test.problemset.CrackingCodingInterview6.ch3;

import java.util.Comparator;
import java.util.Stack;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class Q5_SortStack extends Stack<Integer> {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp;

    //2 8 4 8 9 3
    public void sortData() {
        int i = 0;
        while (i < stack.size()) {
            int min = getMin(stack, stack.size() - i);
            stack.push(min);

            boolean added = false;
            while (!temp.isEmpty()) {
                int val = temp.pop();
                if (val == min && !added){
                    stack.push(val);
                    added = true;
                }
            }
            i++;
        }

    }
    private int getMin(Stack<Integer> stack, int end) {
        temp = new Stack<>();
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() && end > 0) {
            min = Math.min(min, stack.peek());
            temp.push(stack.pop());
            end--;
        }
        return min;
    }

    public static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()) {
            /* Insert each element in s in sorted order into r. */
            int tmp = s.pop();
            while(!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        /* Copy the elements back. */
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
