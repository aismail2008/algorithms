package com.code.test.problemset.leetcode;

import com.code.test.problemset.basics.datastructure.TreeNode;

/**
 * Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of whole tree.
 * Examples:
 * <p>
 * Input:
 * 5
 * /  \
 * 2    4
 * /  \
 * 1    3
 * <p>
 * Output: 3
 * The following subtree is the maximum size BST subtree
 * 2
 * /  \
 * 1    3
 * <p>
 * <p>
 * Input:
 * 50
 * /    \
 * 30       60
 * /  \     /  \
 * 5   20   45    70
 * /  \
 * 65    80
 * Output: 5
 * The following subtree is the maximum size BST subtree
 * 60
 * /  \
 * 45    70
 * /  \
 * 65    80
 * <p>
 * https://leetcode.com/problems/largest-bst-subtree/
 */
public class Q198_LargestBSTSubTree {
    // (size, min, max) -- size of current tree, range of current tree [min, max]
    class Result {
        int size;
        int min;
        int max;

        public Result(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        Result rst = BSTSubstree(root);
        return Math.abs(rst.size);
    }

    private Result BSTSubstree(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = BSTSubstree(root.left);
        Result right = BSTSubstree(root.right);

        //The sign of size field indicates whether the returning node is root of a BST or not.
        if (left.size < 0 || right.size < 0 || root.key < left.max || root.key > right.min) {
            return new Result(Math.max(Math.abs(left.size), Math.abs(right.size)) * -1, 0, 0);
        } else {
            return new Result(left.size + right.size + 1, Math.min(root.key, left.min), Math.max(root.key, right.max));
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        /**
         *  Input:
         *        5
         *      /  \
         *     2    4
         *   /  \
         *  1    3
         *
         *  Output: 3
         */
        TreeNode tree5 = new TreeNode(5);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree3 = new TreeNode(3);
        tree5.left = tree2;
        tree5.right = tree4;

        tree2.left = tree1;
        tree2.right = tree3;

//        System.out.println(new Q198_LargestBSTSubTree().largestBSTSubtree(tree5));

        /* Let us construct the following Tree
                50
             /      \
            10        60
           /  \       /  \
          5   20    55    70
         /     /  \
        45   65    80
         */

        TreeNode tree = new TreeNode(50);
        tree.left = new TreeNode(10);
        tree.right = new TreeNode(60);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(20);
        tree.right.left = new TreeNode(55);
        tree.right.left.left = new TreeNode(45);
        tree.right.right = new TreeNode(70);
        tree.right.right.left = new TreeNode(65);
        tree.right.right.right = new TreeNode(80);

        /* The complete tree is not BST as 45 is in right subtree of 50.
         The following subtree is the largest BST
             60
            /  \
          55    70
          /     /  \
        45     65   80
        */
        System.out.println(new Q198_LargestBSTSubTree().largestBSTSubtree(tree));

    }
}
