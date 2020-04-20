package com.code.test.problemset.leetcode;


import com.code.test.problemset.basics.datastructure.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 * <p>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Q179_FirstCommonAncestorBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.key > p.key && root.key < q.key) {
            return root;
        } else if (root.key > p.key && root.key > q.key) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.key < p.key && root.key < q.key) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
