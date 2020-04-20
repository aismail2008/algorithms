package com.code.test.problemset.basics.datastructure;

import java.util.Stack;

public class BinarySearchTree {
    // Root of BST
    private TreeNode root = null;

    // This method mainly calls deleteRec()
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    /* A recursive function to delete Key fromBST */
    TreeNode deleteRec(TreeNode root, int key) {
        /* Base Case: If the tree is empty */
        if (root == null)
            return null;

        /* Otherwise, recur down the tree */
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // if key is same as root's key, then This is the node
            // to be deleted

            // node with only one child or no child
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {  // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                root.key = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteRec(root.right, root.key);
            }
        }
        return root;
    }

    int minValue(TreeNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    TreeNode insertRec(TreeNode root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key <= root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    //----------------------
    // A utility function to do inorder traversal of BST
    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void inorderIter() {
        if (root == null)
            return;

        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {

            /* Reach the left most Node of the
            curr Node */
            while (curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.key + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }

    //----------------------
    void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    void preOrderIter() {
        // Base Case
        if (root == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (!treeNodeStack.empty()) {

            // Pop the top item from stack and print it
            TreeNode mynode = treeNodeStack.pop();
            System.out.print(mynode.key + " ");

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                treeNodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                treeNodeStack.push(mynode.left);
            }
        }
    }

    //----------------------
    void postOrderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            inorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    void postOrderIterative() {
        // Create two stacks
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        if (root == null)
            return;

        // push root to first stack
        s1.push(root);

        // Run while first stack is not empty
        while (!s1.isEmpty()) {
            // Pop an item from s1 and push it to s2
            TreeNode temp = s1.pop();
            s2.push(temp);

            // Push left and right children of
            // removed item to s1
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        // Print all elements of second stack
        while (!s2.isEmpty()) {
            TreeNode temp = s2.pop();
            System.out.print(temp.key + " ");
        }
    }
    //----------------------

    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /*
         * Let us create following BST     50
         * 								/       \
         * 								30       70
         * 								/ \      / \
         * 								20 40   60 80
         *                              /    \
         * 							   10     50
         *
         */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);
        tree.insert(50);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();
        tree.inorderIter();

        System.out.println("preOrder traversal of the given tree");
        tree.preOrderRec(tree.root);
        tree.preOrderIter();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 40");
        tree.deleteKey(40);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 70");
        tree.deleteKey(70);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 80");
        tree.deleteKey(80);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}