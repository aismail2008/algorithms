package com.code.test.problemset.CrackingCodingInterview6.ch4;


/**
 * First Common Ancestor:
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 */
public class Q8_FirstCommonAncestor {

    public static void main(String[] args) {
    }

    public class Node {
        public int key;
        public Node left, right, parent;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    //Node with link to parent
    static class SolutionB {
        public static Node commonAncestor(Node p, Node q) {
            int delta = depth(p) - depth(q); // get difference in depths
            Node first = delta > 0 ? q : p; // get shallower node
            Node second = delta > 0 ? p : q; // get deeper node
            second = goUpBy(second, Math.abs(delta)); // move shallower node to depth of deeper
            while (first != second && first != null && second != null) {
                first = first.parent;
                second = second.parent;
            }
            return first == null || second == null ? null : first;
        }

        public static Node goUpBy(Node node, int delta) {
            while (delta > 0 && node != null) {
                node = node.parent;
                delta--;
            }
            return node;
        }

        public static int depth(Node node) {
            int depth = 0;
            while (node != null) {
                node = node.parent;
                depth++;
            }
            return depth;
        }
    }

    // No link to parent
    static class NoParentSolution {
        public static Node commonAncestor(Node root, Node p, Node q) {
            if (!covers(root, p) || !covers(root, q)) { // Error check - one node is not in tree
                return null;
            }
            return ancestorHelper(root, p, q);
        }

        public static Node ancestorHelper(Node root, Node p, Node q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            boolean pIsOnLeft = covers(root.left, p);
            boolean qIsOnLeft = covers(root.left, q);
            if (pIsOnLeft != qIsOnLeft) { // Nodes are on different side
                return root;
            }
            Node childSide = pIsOnLeft ? root.left : root.right;
            return ancestorHelper(childSide, p, q);
        }

        public static boolean covers(Node root, Node p) {
            if (root == null) return false;
            if (root == p) return true;
            return covers(root.left, p) || covers(root.right, p);
        }
    }

    static class SolutionA {
//        public static Node commonAncestor(Node p, Node q) {
//            if (p == q) return p;
//
//            Node ancestor = p;
//            while (ancestor != null) {
//                if (isOnPath(ancestor, q)) {
//                    return ancestor;
//                }
//                ancestor = ancestor.parent;
//            }
//            return null;
//        }
//
//        public static boolean isOnPath(Node ancestor, Node node) {
//            while (node != ancestor && node != null) {
//                node = node.parent;
//            }
//            return node == ancestor;
//        }
    }
}
