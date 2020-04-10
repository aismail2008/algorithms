package com.code.test.problemset.CrackingCodingInterview6.ch2;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Return Kth to Last:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Q2_ReturnKthToLast {

    public static int findKth(Node head, int k) {

        if (k < 0) {
            return -1;
        }

        Node current = head;
        while (current != null && k != 0) {
            current = current.next;
            k--;
        }

        if (current == null && k > 0){
            return -1;
        }

        Node kthNode = head;
        while (current != null){
            current = current.next;
            kthNode = kthNode.next;
        }

        return kthNode.val;
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

        System.out.println("Key :  " + findKth(root,50));
    }
}
