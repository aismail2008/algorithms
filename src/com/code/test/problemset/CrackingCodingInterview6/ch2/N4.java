package com.code.test.problemset.CrackingCodingInterview6.ch2;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class N4 {

    /**
     * https://leetcode.com/problems/partition-list/submissions/
     * @param root
     * @param k
     */
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
//        Node root = new Node(ThreadLocalRandom.current().nextInt(1, 100));
//        Node current = root;
//        for (int i = 0; i < 30; i++) {
//            current.next = new Node(ThreadLocalRandom.current().nextInt(1, 100));
//            current = current.next;
//        }
//        current = root;
//        while(current != null) {
//            System.out.print(current.val + " - ");
//            current = current.next;
//        }
//
//        System.out.println("=== ");
//        partition(root,50);
//        System.out.println();


//        3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
        Node root = new Node(3);
        Node head = root;
        root.next = new Node(5);
        root = root.next;
        root.next = new Node(8);
        root = root.next;
        root.next = new Node(5);
        root = root.next;
        root.next = new Node(10);
        root = root.next;
        root.next = new Node(2);
        root = root.next;
        root.next = new Node(1);
        root = root.next;

        System.out.println("=== ");
        partition(head,5);
        System.out.println();
    }

}
