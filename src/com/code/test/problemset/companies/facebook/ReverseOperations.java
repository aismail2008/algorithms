package com.code.test.problemset.companies.facebook;

import com.code.test.problemset.leetcode.Q148_ReverseLinkedList;

/**
 * Reverse Operations
 * You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by the end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
 * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
 * The goal of this question is: given a resulting list, determine the original order of the elements.
 * Implementation detail:
 * You must use the following definition for elements in the linked list:
 * class Node {
 * int data;
 * Node next;
 * }
 * Signature
 * Node reverse(Node head)
 * Constraints
 * 1 <= N <= 1000, where N is the size of the list
 * 1 <= Li <= 10^9, where Li is the ith element of the list
 * Example
 * Input:
 * N = 6
 * list = [1, 2, 8, 9, 12, 16]
 * Output:
 * [1, 8, 2, 9, 16, 12]
 */
public class ReverseOperations {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    static Node reverse(Node head) {
        boolean removeHead = false;
        if (head.data % 2 == 0) {
            Node h2 = new Node(1);
            h2.next = head;
            head = h2;
            removeHead = true;
        }

        Node start = head;
        while (start != null && start.next != null) {
            while (start.next != null && start.next.data % 2 != 0) {
                start = start.next;
            }

            Node tail = start;
            while (tail.next != null && tail.next.data % 2 == 0) {
                tail = tail.next;
            }

            Node connectEnd = tail.next;
            reverse(start.data % 2 != 0 ? start.next : start, tail);//if first node is even

            start.next.next = connectEnd;
            start.next = tail;

            start = connectEnd;
        }
        head =  removeHead ? head.next : head;
        return head;
    }

    static void reverse(Node parent, Node tail) {
        if (parent == tail)
            return;

        tail = tail.next;
        Node middle = parent.next;
        parent.next = null;
        while (middle != tail) {
            Node t = middle.next;
            middle.next = parent;
            parent = middle;
            middle = t;
        }
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(3);
        n1.next.next.next.next = new Node(4);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(8);
        n1.next.next.next.next.next.next.next = new Node(5);

        reverse(n1);
        // Printing the reversed linked list
        printLinkedList(n1);

        System.out.println( " ");

        Node n2 = new Node(0);
        n2.next = new Node(2);
        n2.next.next = new Node(3);
        n2.next.next.next = new Node(3);
        n2.next.next.next.next = new Node(4);
        n2.next.next.next.next.next = new Node(6);
        n2.next.next.next.next.next.next = new Node(8);

        n2 = reverse(n2);
        // Printing the reversed linked list
        printLinkedList(n2);
    }

    static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
