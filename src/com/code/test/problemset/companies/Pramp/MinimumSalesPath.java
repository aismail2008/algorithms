package com.code.test.problemset.companies.Pramp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sales Path
 * The car manufacturer Honda holds their distribution system in the form of a tree (not necessarily binary). The root is the company itself, and every node in the tree represents a car distributor that receives cars from the parent node and ships them to its children nodes. The leaf nodes are car dealerships that sell cars direct to consumers. In addition, every node holds an integer that is the cost of shipping a car to it.
 *
 * Take for example the tree below:
 *
 * alt
 *
 * A path from Honda’s factory to a car dealership, which is a path from the root to a leaf in the tree, is called a Sales Path. The cost of a Sales Path is the sum of the costs for every node in the path. For example, in the tree above one Sales Path is 0→3→0→10, and its cost is 13 (0+3+0+10).
 *
 * Honda wishes to find the minimal Sales Path cost in its distribution tree. Given a node rootNode, write a function getCheapestCost that calculates the minimal Sales Path cost in the tree.
 *
 * Implement your function in the most efficient manner and analyze its time and space complexities.
 *
 * For example:
 *
 * Given the rootNode of the tree in diagram above
 *
 * Your function would return:
 *
 * 7 since it’s the minimal Sales Path cost (there are actually two Sales Paths in the tree whose cost is 7: 0→6→1 and 0→3→2→1→1)
 *
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] Node rootNode
 *
 * 0 ≤ rootNode.cost ≤ 100000
 * [output] integer
 *
 *
 * O(N) time and space
 */
public class MinimumSalesPath {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {

        int getCheapestCost(Node root) {
            Queue<Node> qu = new LinkedList<>();

            if (root == null) {
                return 0;
            }

            qu.offer(root);
            int min = Integer.MAX_VALUE;
            while (!qu.isEmpty()) {
                Node n = qu.remove();

                if (n.children == null || n.children.length == 0) {
                    if (n.cost < min) {
                        min = n.cost;
                    }
                } else {
                    for (Node child : n.children) {
                        child.cost += n.cost;
                        if (child.cost < min)
                            qu.offer(child);
                    }
                }
            }

            return min;
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node n = new Node(0);
        n.children = new Node[]{new Node(5),
                new Node(3),
                new Node(6)
        };

        n.children[0].children = new Node[]{new Node(4)};
        n.children[2].children = new Node[]{new Node(1), new Node(5)};


        n.children[1].children = new Node[]{new Node(2), new Node(0)};
        n.children[1].children[1].children = new Node[]{new Node(10)};
        n.children[1].children[0].children = new Node[]{new Node(1)};
        n.children[1].children[0].children[0].children = new Node[]{new Node(1)};

        int min = new SalesPath().getCheapestCost(n);
    }
}