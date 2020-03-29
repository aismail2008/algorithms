package com.code.test.problemset.leetcode;

import javax.swing.plaf.IconUIResource;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Return the linked list sorted as well.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicated {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;

        ListNode p = t;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int dup = p.next.val;
                while (p.next != null && p.next.val == dup) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }

        return t.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode current = root;

        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(2);
        current = current.next;

        deleteDuplicates(root);

        current = root;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }
}
