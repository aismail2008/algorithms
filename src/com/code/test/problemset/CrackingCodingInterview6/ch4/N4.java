package com.code.test.problemset.CrackingCodingInterview6.ch4;

import com.code.test.problemset.basics.datastructure.Node;

import java.util.Hashtable;

/**
 * Check Balanced:
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the
 * two subtrees of any node never differ by more than one.
 */
public class N4 {
    static Hashtable<Node, Integer> hights = new Hashtable<>();

    public static int checkHeight(Node root) {
        if (root == null)
            return -1;

        int leftHeight = checkHeight(root.left);

        if (leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // Pass error up

        int rightHeight = checkHeight(root.right);

        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static int getHeight(Node root, Hashtable<Node, Integer> hights) {
        if (root == null) {
            return -1;
        } else if (hights.get(root) != null) {
            hights.get(root);
        }

        hights.put(root, Math.max(getHeight(root.left, hights), getHeight(root.right, hights)) + 1);

        return hights.get(root);
    }


    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int heightDiff = getHeight(root.left, hights) - getHeight(root.right, hights);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static void main(String[] args) {
    }
}
