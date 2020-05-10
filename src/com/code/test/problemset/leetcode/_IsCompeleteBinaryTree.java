package com.code.test.problemset.leetcode;


import com.code.test.problemset.CrackingCodingInterview6.ch7.Q4_ParkingLot.Level;
import com.code.test.problemset.basics.datastructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Check Completeness of a Binary Tree
 * Given a binary tree, determine if it is a complete binary tree.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *  Example 1:
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 *
 *  Example 2:
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 * Note:
 *
 * The tree will have between 1 and 100 nodes.
 *
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree
 */
public class _IsCompeleteBinaryTree {

    public boolean bfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean firstNode = true;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();

            if (firstNode && p.left != null && p.right != null){
                queue.add(p.left);
                queue.add(p.right);
            }else if(firstNode && (p.left != null && p.right == null)){
                firstNode = false;
                queue.add(p.left);
            }else if(firstNode && (p.left == null && p.right == null)){
                firstNode = false;
            }else if(!firstNode && (p.left == null && p.right == null)){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}