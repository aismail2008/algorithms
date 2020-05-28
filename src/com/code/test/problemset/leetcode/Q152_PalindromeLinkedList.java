package com.code.test.problemset.leetcode;

import com.code.test.problemset.CrackingCodingInterview6.ch2.Node;
import com.code.test.problemset.CrackingCodingInterview6.ch2.Q5_SumLists;

import java.util.Stack;


/**
 * Palindrome Linked List :
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * <p>
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Q152_PalindromeLinkedList {

    public static boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

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

    // O(1) space
    public boolean isPalindrome_O_1(Node head) {

        if (head == null || head.next == null)
            return true;

        //find list center
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node secondHead = slow.next;
        slow.next = null;

        //reverse second part of the list
        Node p1 = secondHead;
        Node p2 = p1.next;

        while (p1 != null && p2 != null) {
            Node temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secondHead.next = null;

        //compare two sublists now
        Node p = (p2 == null ? p1 : p2);
        Node q = head;
        while (p != null) {
            if (p.val != q.val)
                return false;

            p = p.next;
            q = q.next;

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