package com.code.test.problemset.CrackingCodingInterview6.ch4;

import com.code.test.problemset.basics.datastructure.Node;

/**
 * Validate BST:
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Q5_ValidateBST {

    /**
     * InOrder traversal is okay if there is no duplicated values
     *
     * @param root
     */
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    /**
     * This if there is duplicated data
     * @param n
     * @return
     */
    static boolean checkBST(Node n) {
        return checkBST(n, null, null);
    }

    static boolean checkBST(Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        if ((min != null && n.key <= min) // Left Child must follow null < key <=  max
                || (max != null && n.key >= max)){ // Right Child must follow min < key <=  null
            return false;
        }

        if (!checkBST(n.left, min, n.key) || !checkBST(n.right, n.key, max)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(1);
        checkBST(n);
    }

}
