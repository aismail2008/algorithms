package com.code.test.problemset.leetcode;

import com.code.test.problemset.basics.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Q165_ValidateBinarySearchTree {
    /**
     * This if there is duplicated data
     *
     * @param n
     * @return
     */
    public static boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        if ((min != null && n.key <= min) // Left Child must follow null < key <=  max
                || (max != null && n.key >= max)) { // Right Child must follow min < key <=  null
            return false;
        }

        if (!checkBST(n.left, min, n.key) || !checkBST(n.right, n.key, max)) {
            return false;
        }
        return true;
    }

    //---------------------------------------//
    int lastValue = Integer.MIN_VALUE;

    public boolean inOrderTraverse(TreeNode node) {
        if (node != null) {
            if (!inOrderTraverse(node.left))
                return false;
            if (node.key < lastValue)
                return false;
            else
                lastValue = node.key;
            if (!inOrderTraverse(node.right))
                return false;
        }
        return true;
    }
}
