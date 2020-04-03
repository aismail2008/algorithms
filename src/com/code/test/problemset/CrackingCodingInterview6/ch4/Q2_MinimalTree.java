package com.code.test.problemset.CrackingCodingInterview6.ch4;

/**
 * Minimal Tree:
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class Q2_MinimalTree {
    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    static Node createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}
