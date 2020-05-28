package com.code.test.problemset.leetcode;

import java.util.Random;

/**
 * Linked List Random Node
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 * <p>
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 * <p>
 * Example:
 * <p>
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 * <p>
 * https://leetcode.com/problems/linked-list-random-node/
 */
public class Q91_LinkedListRandomNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public Q91_LinkedListRandomNode(ListNode head) {
        h = head;
        r = new Random();
    }

    Random r;
    ListNode h;

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int count = 1;
        ListNode p = h;
        int result = 0;
        while (p != null) {
            if (r.nextInt(count) == 0)
                result = p.val;
            count++;
            p = p.next;
        }
        return result;
    }
}
