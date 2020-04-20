package com.code.test.problemset.leetcode;

import com.code.test.problemset.basics.datastructure.TreeNode;

import java.util.Hashtable;

/**
 * Check Balanced:
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the
 * two subtrees of any node never differ by more than one.
 *
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class Q175_BalancedBinaryTree {
    static Hashtable<TreeNode, Integer> hightsMemory = new Hashtable<>();

    public static int getHeight(TreeNode root, Hashtable<TreeNode, Integer> memory) {
        if (root == null) {
            return -1;
        } else if (memory.get(root) != null) {
            memory.get(root);
        }

        memory.put(root, Math.max(getHeight(root.left, memory), getHeight(root.right, memory)) + 1);

        return memory.get(root);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int heightDiff = getHeight(root.left, hightsMemory) - getHeight(root.right, hightsMemory);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static void main(String[] args) {
    }
}