package com.code.test.problemset.leetcode;

/**
 * Reverse a singly linked list II
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class Q149_ReverseLinkedListII {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reverseLinkedList(n1, 2, 4);


        ListNode n11 = new ListNode(3);
        ListNode n12 = new ListNode(5);
        n11.next = n12;
        reverseLinkedList(n11, 1, 2);
    }

    public static ListNode reverseLinkedList(ListNode head, int m, int n) {
        if (head == null || n <= m)
            return head;

        ListNode current = head;
        ListNode parent = head;
        int k = 1;
        while (k++ < m && current != null) {
            parent = current;
            current = current.next;
        }

        if (current == null)
            return head;

        ListNode node = reverse(current, n - m);
        if (m == 1) {
            head = node;
        } else {
            parent.next = node;
        }
        return head;
    }

    public static ListNode reverse(ListNode head, int c) {
        ListNode parent = head;
        ListNode newEnd = head;
        ListNode middle = head.next;
        parent.next = null;
        while (middle != null && c-- != 0) {
            ListNode tmp = middle.next;
            middle.next = parent;
            parent = middle;
            middle = tmp;
        }
        newEnd.next = middle;
        return parent;
    }
}
