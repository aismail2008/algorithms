package com.code.test.problemset.basics.datastructure;

class BinaryTree {
    // Root of BST
    private Node root = null;
    /* Class containing left and right child of current node and key value */

    // This method mainly calls deleteRec()
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    /* A recursive function to delete Key fromBST */
    Node deleteRec(Node root, int key) {
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

    int minValue(Node root) {
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
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
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

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

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