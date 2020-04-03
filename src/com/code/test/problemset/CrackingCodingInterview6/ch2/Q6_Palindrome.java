package com.code.test.problemset.CrackingCodingInterview6.ch2;

import java.util.Stack;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome
 */
public class Q6_Palindrome {

    public static boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Has odd number of elements, so skip the middle */
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(Q5_SumLists.toNode(9813189)));
        System.out.println(isPalindrome(Q5_SumLists.toNode(98133189)));
        System.out.println(isPalindrome(Q5_SumLists.toNode(1234432)));
        System.out.println(isPalindrome(Q5_SumLists.toNode(1)));
    }
}
