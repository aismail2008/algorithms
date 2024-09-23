package com.code.test.problemset.leetcode.medium;


import com.code.test.problemset.leetcode.Medium;

import java.util.ArrayList;

/**
 * Balance a Binary Search Tree
 * Given a binary search tree, return a balanced binary search tree with the same node values.
 *
 * A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.
 *
 * If there is more than one answer, return any of them.
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 */
@Medium
public class _BalanceBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * InOrder traversal is okay if there is no duplicated values
     * this returns ordered list
     * @param root
     */
    void inorderRec(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            inorderRec(root.left, list);
            list.add(root.val);
            inorderRec(root.right, list);
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        inorderRec(root, list);
        TreeNode n = createBST(list, 0, list.size() - 1);
        return n;
    }

    private TreeNode createBST(ArrayList<Integer> list, int lo, int hi) {
        if (hi < lo) {
            return null;
        }

        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = createBST(list, lo, mid -1);
        root.right = createBST(list, mid +1, hi);
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;

        _BalanceBinarySearchTree q = new _BalanceBinarySearchTree();
        TreeNode n = q.balanceBST(n1);

        System.out.println(n1);
    }
}
