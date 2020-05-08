package com.code.test.problemset.companies.Amazon;

import com.code.test.problemset.basics.datastructure.TreeNode;

import java.util.*;
import java.util.regex.Pattern;

/**
 * for each node in BST calculate the sum of all nodes less than or equal to itself including itself
 * ex:         5
 *         /     \
 *        3      10
 *      /   \    /   \
 *     1    4   8    11
 * <p>
 * return 5 => (5+8+10+11)
 * 10 => 10+11
 * 11 => 11
 * 8  => 8
 * 3 => 3+4
 * 4 => 4
 * 1 => 1
 */
public class SumOfSmallerNodes {

    static class TreeNode {
        public int key;
        public TreeNode left, right;

        public TreeNode(int item) {
            key = item;
            left = right = null;
        }
    }

    static HashMap<TreeNode, Integer> sol = new HashMap<>();

    static public HashMap<TreeNode, Integer> solve(TreeNode node) {
        getSum(node);
        return sol;
    }

    public static int getSum(TreeNode root) {
        if (root == null)
            return 0;
        if (sol.containsKey(root)) {
            return sol.get(root);
        }

        int sumRight = getSum(root.right);
        int sumLeft = getSum(root.left);
        sol.put(root, root.key + sumRight);
        return root.key + sumRight + sumLeft;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(3);
        n.left.left =  new TreeNode(1);
        n.left.right =  new TreeNode(2);

        n.right = new TreeNode(10);
        n.right.right =  new TreeNode(11);
        n.right.left =  new TreeNode(6);

        solve(n);
    }
}
