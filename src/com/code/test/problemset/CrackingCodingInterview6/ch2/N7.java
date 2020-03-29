package com.code.test.problemset.CrackingCodingInterview6.ch2;

/**
 * Intersection:
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */
public class N7 {

    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
     *
     * @return
     */
    public static Node findIntersection(Node list1, Node list2) {
        if (list1 == null || list2 == null) return null;

        /* Get tail and sizes. */
        Node result1 = list1;
        int size1 = 1;
        while (result1.next != null) {
            size1++;
            result1 = result1.next;
        }

        Node result2 = list2;
        int size2 = 1;
        while (result2.next != null) {
            size2++;
            result2 = result2.next;
        }

        if (result1 != result2) {
            return null;
        }

        /* Set pointers to the start of each linked list. */
        Node shorter = size1 < size2 ? list1 : list2;
        Node longer = size1 < size2 ? list2 : list1;

        /* Advance the pointer for the longer linked list by the difference in lengths. */
        longer = getKthNode(longer, Math.abs(size1 - size2));

        /* Move both pointers until you have a collision. */
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        /* Return either one. */
        return longer;
    }

    public static Node getKthNode(Node head, int k) {
        while (k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

    public static void main(String[] args) {

//        int[] first = new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,42};
//        int[] first = new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,41,42};
    }


}
