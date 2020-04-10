package com.code.test.problemset.leetcode;

/**
 * Partition:
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 *  https://leetcode.com/problems/partition-list/submissions/
 */
public class Q144_PartitionList {

    static class Node {
        int val;
        Node next;

        public Node(int value) {
            this.val = value;
        }
    }

    public static void partition(Node root, int k) {
        Node lessRoot = new Node(0);
        Node less = lessRoot;
        Node higherRoot = new Node(0);
        Node higher = higherRoot;
        Node current = root;

        while (current != null) {
            if (current.val < k) {
                less.next = current;
                less = less.next;
            } else {
                higher.next = current;
                higher = higher.next;
            }
            current = current.next;
        }
        higher.next = null;
        less.next = higherRoot.next;
        root = lessRoot.next;
    }

    public static void main(String[] args) {
    }

}
