package com.code.test.problemset.CrackingCodingInterview6.ch2;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list,
 * given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e- >f
 */
public class Q3_DeleteMiddleNode {

    public static void deleteMiddle(Node middle) {
        middle.next = middle.next.next;
        middle.val = (Integer) middle.next.val;
    }

    public static void main(String[] args) {

    }
}
