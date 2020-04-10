package com.code.test.problemset.leetcode;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Q148_ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null)
            return null;
        ListNode parent = head;
        ListNode middle = head.next;
        parent.next = null;
        while (middle != null) {
            ListNode tmp = middle.next;
            middle.next = parent;
            parent = middle;
            middle = tmp;
        }

        return parent;
    }
}
