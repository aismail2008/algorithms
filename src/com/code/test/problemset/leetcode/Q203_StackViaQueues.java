package com.code.test.problemset.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Stack via Queues :
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * <p>
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class Q203_StackViaQueues {
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;
        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (empty()) {
                q1.offer(x);
            } else {
                if (q1.size() > 0) {
                    q2.offer(x);
                    int size = q1.size();
                    while (size > 0) {
                        q2.offer(q1.poll());
                        size--;
                    }
                } else if (q2.size() > 0) {
                    q1.offer(x);
                    int size = q2.size();
                    while (size > 0) {
                        q1.offer(q2.poll());
                        size--;
                    }
                }
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (q1.size() > 0) {
               return q1.poll();
            } else if (q2.size() > 0) {
                return q2.poll();
            }
            return 0;
        }

        /** Get the top element. */
        public int top() {
            if (q1.size() > 0) {
                return q1.peek();
            } else if (q2.size() > 0) {
                return q2.peek();
            }
            return 0;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return (q1.size() + q2.size() == 0);
        }
    }
}
