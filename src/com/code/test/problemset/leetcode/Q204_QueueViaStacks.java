package com.code.test.problemset.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue via Stacks:
 * Implement a MyQueue class which implements a queue using two stacks.
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class Q204_QueueViaStacks {
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
        Q204_QueueViaStacks q = new Q204_QueueViaStacks();

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
