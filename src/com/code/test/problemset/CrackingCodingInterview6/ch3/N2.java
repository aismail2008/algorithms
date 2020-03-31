package com.code.test.problemset.CrackingCodingInterview6.ch3;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class N2 {

    class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int v, int min) {
            value = v;
            this.min = min;
        }
    }

    public class StackWithMin extends Stack<NodeWithMin> {
        public void push(int value) {
            int newMin = Math.min(value, min());
            super.push(new NodeWithMin(value, newMin));
        }

        public int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }
    }
}

class MinStack {
    class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int v, int min) {
            value = v;
            this.min = min;
        }
    }

    Stack<NodeWithMin> stackMin;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackMin = new Stack<>();
    }

    public void push(int x) {
        int newMin = Math.min(x, getMin());
        stackMin.push(new NodeWithMin(x, newMin));
    }

    public void pop() {
        stackMin.pop();
    }

    public int top() {
        if (stackMin.empty())
            throw new EmptyStackException();
        return stackMin.peek().value;
    }

    public int getMin() {
        if (stackMin.empty())
            throw new EmptyStackException();
        return stackMin.peek().min;
    }
}