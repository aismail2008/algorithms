package com.code.test.problemset.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * <p>
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Q79_MergeKSortedLists {
    static class SolutionA {
        static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        // O(M * N): m is number of arrays and N is max length of all arrays
        public static ListNode mergeKSortedList(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            ListNode head = new ListNode(Integer.MIN_VALUE);
            ListNode current = head;

            while (true) {
                int minInd = -1;
                int minVal = Integer.MAX_VALUE;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] != null && lists[i].val < minVal) {
                        minVal = lists[i].val;
                        minInd = i;
                    }
                }
                if (minInd == -1) {
                    break;
                }
                current.next = lists[minInd];
                lists[minInd] = lists[minInd].next;
                current.next.next = null;
                current = current.next;
            }

            return head.next;
        }

        public static void main(String[] args) {
            ListNode n = new ListNode(1);
            n.next = new ListNode(4);
            n.next.next = new ListNode(5);

            ListNode n1 = new ListNode(1);
            n1.next = new ListNode(3);
            n1.next.next = new ListNode(4);

            ListNode n2 = new ListNode(2);
            n2.next = new ListNode(6);

            mergeKSortedList(new ListNode[]{n, n1, n2});
        }
    }

    static class SolutionB {

        static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        /**
         * Time: log(k) * n. k is number of list and n is number of total elements.
         * In addition, from Java 8 comparator definition can be simplified as the following:
         */

        public static ListNode mergeKSortedList(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (int i = 0; i < lists.length ; i++) {
                if(lists[i] != null)
                    queue.offer(lists[i]);
            }

            ListNode head = new ListNode(Integer.MIN_VALUE);
            ListNode current = head;
            //while heap is not empty
            while (!queue.isEmpty()) {
                current.next = queue.poll();
                current = current.next;
                ListNode n = current.next;
                current.next = null;

                if(n != null)
                    queue.offer(n);
            }
            return head.next;
        }

        public static void main(String[] args) {
            mergeKSortedList(new ListNode[]{});
        }

    }
}
