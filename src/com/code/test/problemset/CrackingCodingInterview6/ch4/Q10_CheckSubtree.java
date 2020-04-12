package com.code.test.problemset.CrackingCodingInterview6.ch4;

import com.code.test.problemset.basics.datastructure.Node;

/**
 * Check Subtree:
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
 * Hints:#4, #11, #18, #31, #37
 */
public class Q10_CheckSubtree {

    static class SolutionA {
        public static boolean containsTree(Node t1, Node t2) {
            StringBuilder string1 = new StringBuilder();
            StringBuilder string2 = new StringBuilder();

            getOrderStringPreOrder(t1, string1);
            getOrderStringPreOrder(t2, string2);

            return string1.indexOf(string2.toString()) != -1;
        }

        public static void getOrderStringPreOrder(Node node, StringBuilder sb) {
            if (node == null) {
                sb.append("X");             // Add null indicator
                return;
            }
            sb.append(node.key);           // Add root
            getOrderStringPreOrder(node.left, sb);  // Add left
            getOrderStringPreOrder(node.right, sb); // Add right
        }
    }

    static class SolutionB {

        public static boolean containsTree(Node t1, Node t2) {
            if (t2 == null) {
                return true; // The empty tree is a subtree of every tree.
            }
            return subTree(t1, t2);
        }

        /* Checks if the binary tree rooted at r1 contains the binary tree
         * rooted at r2 as a subtree somewhere within it.
         */
        public static boolean subTree(Node r1, Node r2) {
            if (r1 == null) {
                return false; // big tree empty & subtree still not found.
            } else if (r1.key == r2.key && matchTree(r1, r2)) {
                return true;
            }
            return subTree(r1.left, r2) || subTree(r1.right, r2);
        }

        /* Checks if the binary tree rooted at r1 contains the
         * binary tree rooted at r2 as a subtree starting at r1.
         */
        public static boolean matchTree(Node r1, Node r2) {
            if (r1 == null && r2 == null) {
                return true; // nothing left in the subtree
            } else if (r1 == null || r2 == null) {
                return false; // exactly one tree is empty, therefore trees don't match
            } else if (r1.key != r2.key) {
                return false;  // data doesn't match
            } else {
                return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
            }
        }
    }

    public static void main(String[] args) {
    }
}
