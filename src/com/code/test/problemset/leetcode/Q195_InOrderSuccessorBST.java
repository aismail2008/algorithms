package com.code.test.problemset.leetcode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * // Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class Q195_InOrderSuccessorBST {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode parent;
        public TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    // If you have parent
    TreeNode findInOrderSuccessor(TreeNode node) {
        if(node == null){
            return null;
        }

        if (node.right != null){
            return getMostLeft(node.right);
        }
        else{
            while(node.parent != null && node != node.parent.left){
                node = node.parent;
            }
            if(node.parent != null){
                return node.parent;
            }
        }
        return null;
    }

    TreeNode getMostLeft(TreeNode n){
        while(n.left != null){
            n = n.left;
        }
        return n;
    }


    public TreeNode nextSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        java.util.Stack<TreeNode> s = new java.util.Stack();
        s.push(root);

        TreeNode n = root;
        boolean isNext = false;
        while (n != null || !s.isEmpty()) {
            while (n != null) {
                s.push(n);
                n = n.left;
            }

            n = s.pop();
            if (isNext) {
                return n;
            }

            if (n == p) {
                isNext = true;
            }

            n = n.right;
        }
        return null;
    }

    // One solution is do to InOrder traversal and once found target say found = true then next printed is the Successor
    // OR This one
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        TreeNode next = null;
        TreeNode c = root;
        while (c != null && c.val != p.val) {
            if (c.val > p.val) {
                next = c;
                c = c.left;
            } else {
                c = c.right;
            }
        }

        if (c == null)
            return null;

        if (c.right == null)
            return next;

        c = c.right;
        while (c.left != null)
            c = c.left;

        return c;
    }

    public static void main(String[] args) {
    }
}
