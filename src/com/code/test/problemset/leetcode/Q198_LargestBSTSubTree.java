package com.code.test.problemset.leetcode;

import com.code.test.problemset.basics.datastructure.TreeNode;

/**
 * Largest BST SubTree
 * <p>
 * Given a Binary Tree, write a function that returns the size of the
 * largest subtree which is also a Binary Search Tree (BST).
 * If the complete Binary Tree is BST, then return the size of whole tree.
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
    class Wrapper {
        int size;
        int lower, upper;
        boolean isBST;

        public Wrapper() {
            lower = Integer.MAX_VALUE;
            upper = Integer.MIN_VALUE;
            isBST = false;
            size = 0;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return helper(root).size;
    }

    public Wrapper helper(TreeNode node) {
        Wrapper curr = new Wrapper();

        if (node == null) {
            curr.isBST = true;
            return curr;
        }

        Wrapper l = helper(node.left);
        Wrapper r = helper(node.right);

        //check left and right subtrees are BST or not
        //check left's upper again current's value and right's lower against current's value
        if (l.isBST && r.isBST && l.upper <= node.key && r.lower > node.key) {
            curr.size = l.size + r.size + 1;
            curr.isBST = true;
        } else {
            curr.size = Math.max(l.size, r.size);
            curr.isBST = false;
        }

        //current subtree's boundaries
        curr.lower = Math.min(node.key, l.lower);
        curr.upper = Math.max(node.key, r.upper);

        return curr;
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
