package com.code.test.problemset.CrackingCodingInterview6.ch2;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Remove Dups! Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class N1 {

    public static void removeDuplicatesNonSorted(Node head) {
        Node current = head;
        while (current != null) {

            Node runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     * @param head
     */
    public static void removeDuplicatesSorted(Node head) {

        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node runner = head.next;

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

    public static void main(String[] args) {
        Node root = new Node(ThreadLocalRandom.current().nextInt(1, 100));
        Node current = root;
        for (int i = 0; i < 30; i++) {
            current.next = new Node(ThreadLocalRandom.current().nextInt(1, 100));
            current = current.next;
        }
        current = root;
        while(current != null) {
            System.out.print(current.val + " - ");
            current = current.next;
        }

        System.out.println("=== ");

        removeDuplicatesNonSorted(root);

        current = root;
        while(current != null) {
            System.out.print(current.val + " - ");
            current = current.next;
        }
    }
}