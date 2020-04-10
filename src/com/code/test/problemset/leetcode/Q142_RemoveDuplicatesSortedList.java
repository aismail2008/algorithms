package com.code.test.problemset.leetcode;

/**
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Q142_RemoveDuplicatesSortedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void removeDuplicatesSorted(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        ListNode current = head;
        ListNode runner = head.next;

        while (runner != null) {
            if (current.val == runner.val) {
                runner = runner.next;
                current.next = runner;
            } else {
                current = runner;
                runner = runner.next;
            }
        }
    }
}
