package com.code.test.problemset.CrackingCodingInterview6.ch4;

import java.util.Random;

/**
 * Random Node:
 * You are implementing a binary search tree class from scratch, which, in addition to insert, find, and delete,
 * has a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be chosen.
 * Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the method
 */
public class Q11_RandomNode {

    static class Node {
        public int data;
        public Node left;
        public Node right;
        private int size = 0;

        public Node(int d) {
            data = d;
            size = 1;
        }

        public void insertInOrder(int d) {
            if (d <= data) {
                if (left == null) {
                    left = new Node(d);
                } else {
                    left.insertInOrder(d);
                }
            } else {
                if (right == null) {
                    right = new Node(d);
                } else {
                    right.insertInOrder(d);
                }
            }
            size++;
        }

        public int size() {
            return size;
        }

        public Node find(int d) {
            if (d == data) {
                return this;
            } else if (d <= data) {
                return left != null ? left.find(d) : null;
            } else if (d > data) {
                return right != null ? right.find(d) : null;
            }
            return null;
        }

        public Node getRandomNode() {
            int leftSize = left == null ? 0 : left.size;
            Random random = new Random();
            int index = random.nextInt(size);
            if (index < leftSize) {
                return left.getRandomNode();
            } else if (index == leftSize) {
                return this;
            } else {
                return right.getRandomNode();
            }
        }

        public Node getIthNode(int i) {
            int leftSize = left == null ? 0 : left.size();
            if (i < leftSize) {
                return left.getIthNode(i);
            } else if (i == leftSize) {
                return this;
            } else {
                return right.getIthNode(i - (leftSize + 1));
            }
        }
    }

    static class Tree {
        Node root = null;

        public void insertInOrder(int value) {
            if (root == null) {
                root = new Node(value);
            } else {
                root.insertInOrder(value);
            }
        }

        public int size() {
            return root == null ? 0 : root.size();
        }

        public Node getRandomNode() {
            if (root == null) return null;

            Random random = new Random();
            int i = random.nextInt(size());
            return root.getIthNode(i);
        }
    }


    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < 1000000; i++) {
            Tree tree = new Tree();
            int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
            for (int x : array) {
                tree.insertInOrder(x);
            }
            int d = tree.getRandomNode().data;
            counts[d]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }

}
