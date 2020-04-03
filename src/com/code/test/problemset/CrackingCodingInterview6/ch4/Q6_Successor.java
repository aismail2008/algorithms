package com.code.test.problemset.CrackingCodingInterview6.ch4;

/**
 * Successor:
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 */
public class Q6_Successor {
    public class Node {
        public int val;
        public Node left, right, parent;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    // One solution is do to InOrder traversal and once found target say found = true then next printed is the Successor
    // OR

    public static Node inorderSucc(Node n) {
        if (n == null) return null;

        // Found right children -> return left most node of right subtree
        if (n.parent == null || n.right != null) { // is current is the root?
            return leftMostChild(n.right);
        } else {
            Node q = n;
            Node parent = q.parent;
            // Go up until we're on left instead of right
            while (parent != null && parent.left != q) {
                q = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public static Node leftMostChild(Node n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args) {
    }
}
