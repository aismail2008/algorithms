package com.code.test.problemset.companies.facebook;

import java.util.*;

/**
 * Number of Visible Nodes
 * There is a binary tree with N nodes. You are viewing the tree from its left side and can see only the leftmost nodes at each level. Return the number of visible nodes.
 * Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes. The leftmost node at a level could be a right node.
 * Signature
 * int visibleNodes(Node root) {
 * Input
 * The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0 and 1,000,000,000
 * Output
 * An int representing the number of visible nodes.
 * Example
 *             8  <------ root
 *            / \
 *          3    10
 *         / \     \
 *        1   6     14
 *           / \    /
 *          4   7  13
 * output = 4
 */
public class NumberOfVisibleNodes {

    class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    int visibleNodes(Node root) {
        Queue<Node> qu = new LinkedList();
        Map<Node, Integer> level = new HashMap<>();
        level.put(root, 1);
        qu.offer(root);
        Set<Integer> count = new HashSet<>();
        count.add(1);
        while(!qu.isEmpty()){

            Node r = qu.remove();

            if(r.left != null){
                level.put(r.left, level.get(r) + 1);
                qu.offer(r.left);
                count.add(level.get(r) + 1);
            }
            if(r.right != null){
                level.put(r.right, level.get(r) + 1);
                qu.offer(r.right);
                count.add(level.get(r) + 1);
            }
        }
        return count.size();
    }
}
