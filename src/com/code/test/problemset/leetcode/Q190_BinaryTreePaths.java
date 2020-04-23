package com.code.test.problemset.leetcode;

import com.code.test.problemset.basics.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class Q190_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        String sb = "";
        ArrayList<String> result = new ArrayList<String>();

        helper(root, result, sb);

        return result;
    }

    public void helper(TreeNode root, ArrayList<String> result, String s) {
        if (root == null) {
            return;
        }

        s = s + "->" + root.key;

        if (root.left == null && root.right == null) {
            result.add(s.substring(2));
            return;
        }

        if (root.left != null) {
            helper(root.left, result, s);
        }
        if (root.right != null) {
            helper(root.right, result, s);
        }
    }
}
