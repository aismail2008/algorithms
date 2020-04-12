package com.code.test.problemset.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Q159_BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        // Since queue is a interface
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return new ArrayList();

        // Adds to end of queue
        queue.add(root);
        Map<TreeNode, Integer> level = new LinkedHashMap<>();
        level.put(root, 0);
        while (!queue.isEmpty()) {
            // removes from front of queue
            TreeNode r = queue.remove();
            // Visit child first before grandchild
            if (r.left != null) {
                level.put(r.left, level.get(r) + 1);
                queue.add(r.left);
            }
            if (r.right != null) {
                level.put(r.right, level.get(r) + 1);
                queue.add(r.right);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<TreeNode>> p = level.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        for (Map.Entry<Integer, List<TreeNode>> entrySet : p.entrySet()) {
            result.add(entrySet.getKey(), entrySet.getValue().stream().map(n -> n.val).collect(Collectors.toList()));
        }

        return result;
    }
}
