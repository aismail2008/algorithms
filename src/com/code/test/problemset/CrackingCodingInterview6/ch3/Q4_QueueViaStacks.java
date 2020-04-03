package com.code.test.problemset.CrackingCodingInterview6.ch3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class Q4_QueueViaStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public int size() {
        return s1.size() + s2.size();
    }

    public void add(int value) {
        // Push onto stack1
        s1.push(value);
    }

    public int peek() {
        // Push onto stack1
        if (s2.isEmpty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public int remove() {
        // Push onto stack1
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        Q4_QueueViaStacks q = new Q4_QueueViaStacks();

        queue.add(1);
        queue.add(2);
        q.add(1);
        q.add(2);


        System.out.println(queue.peek());
        System.out.println(q.peek());
        System.out.println("-----");

        queue.add(3);
        queue.add(4);
        q.add(3);
        q.add(4);

        System.out.println(queue.poll());
        System.out.println(q.remove());
        System.out.println("-----");
    }
}
