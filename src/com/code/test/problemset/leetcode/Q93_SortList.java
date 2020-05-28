package com.code.test.problemset.leetcode;

import java.util.List;

/**
 * Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class Q93_SortList {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(-1);
        n4.next = new ListNode(5);
        n4.next.next = new ListNode(3);
        n4.next.next.next = new ListNode(4);
        n4.next.next.next.next = new ListNode(0);

        sortList(n4);
    }

    // Definition for singly-linked list.
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) { // zero or one
            return head;
        } else if (head.next.next == null) { // two
            if (head.val > head.next.val) {
                int t = head.val;
                head.val = head.next.val;
                head.next.val = t;
            }
            return head;
        }

        ListNode middle = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        //partition the list
        ListNode p2 = middle.next;
        middle.next = null;

        //sort each list
        head = sortList(head);
        p2 = sortList(p2);

        return mergeParts(head, p2);
    }

    static private ListNode mergeParts(ListNode head1, ListNode head2) {
        ListNode originalHead = new ListNode(0);
        ListNode head = originalHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        ListNode remain = head1 == null ? head2 : head1;
        head.next = remain;

        return originalHead.next;
    }
}
