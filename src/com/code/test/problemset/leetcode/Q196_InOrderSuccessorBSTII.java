package com.code.test.problemset.leetcode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val. You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. A node is defined as
 * the following:
 * // Definition for a Node.
 * class Node {
 *    public int val;
 *    public Node left;
 *    public Node right;
 *    public Node parent;
 * }
 *
 * https://leetcode.com/problems/inorder-successor-in-bst-ii/
 */
public class Q196_InOrderSuccessorBSTII {
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
