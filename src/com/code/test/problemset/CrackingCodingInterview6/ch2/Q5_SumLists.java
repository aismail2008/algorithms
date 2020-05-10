package com.code.test.problemset.CrackingCodingInterview6.ch2;

import com.code.test.problemset.leetcode.Q148_ReverseLinkedList;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).
 * That is: 617 + 295. Output: 2 -> 1 -> 9. That is 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).
 * That is 617 + 295. Output: 9 -> 1 -> 2. That is 912.
 */
public class Q5_SumLists {

    public static Node sum(Node f, Node s) {
        if (s == null && f == null) {
            return null;
        } else if (s != null && f == null) {
            return s;
        }
        if (s == null && f != null) {
            return f;
        }

        Node r = new Node(0);
        Node sol = r;
        int carry = 0;
        while (f != null && s != null) {
            int result = f.val + s.val + carry;
            r.next = new Node(result % 10);
            carry = result / 10;

            r = r.next;
            s = s.next;
            f = f.next;
        }

        while (s != null) {
            r.next = new Node((s.val + carry) % 10);
            carry = (s.val + carry) / 10;
            s = s.next;
            r = r.next;
        }

        while (f != null) {
            r.next = new Node((f.val + carry) % 10);
            carry = (f.val + carry) / 10;
            f = f.next;
            r = r.next;
        }

        if (carry > 0)
            r.next = new Node(carry);

        return sol.next;
    }

    public static void main(String[] args) {
        int value = 99617 + 295;
        System.out.println("99617 + 295 = " + value);
        System.out.println("Output = " + linkedListToInt(sum(toNode(99617), toNode(295))));
    }

    public static Node toNode(int number) {
        Node node = new Node(0);
        Node root = node;
        char[] numb = String.valueOf(number).toCharArray();
        for (int i = numb.length - 1; i >= 0; i--) {
            node.next = new Node(numb[i] - '0');
            node = node.next;
        }
        return root.next;
    }

    static int linkedListToInt(Node node) {
        int value = 0;
        int i = 0;
        while (node != null) {
            value += node.val * Math.pow(10, i++);
            node = node.next;
        }
        return value;
    }

    // Follow up : Idea is to revese first
    Q148_ReverseLinkedList s = new Q148_ReverseLinkedList();
}
