package com.code.test.problemset.leetcode;

public class Q150_ReverseDoubleLinkedList {
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
    }


    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode p = head;
        DoublyLinkedListNode newHead = head;

        while (p != null) {
            DoublyLinkedListNode t = p.next;
            p.next = p.prev;
            p.prev = t;

            newHead = p;
            p = t;
        }

        return newHead;
    }
}
