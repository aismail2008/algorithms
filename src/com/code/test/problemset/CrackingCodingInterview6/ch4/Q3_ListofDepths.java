package com.code.test.problemset.CrackingCodingInterview6.ch4;

import com.code.test.problemset.basics.datastructure.GraphNode;
import com.code.test.problemset.basics.datastructure.State;

import java.util.*;
import java.util.stream.Collectors;

/**
 * List of Depths:
 * Given a binary tree,
 * design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class Q3_ListofDepths {

    public static void bfs(GraphNode root) {
        // Since queue is a interface
        Queue<GraphNode> queue = new LinkedList<>();

        if (root == null)
            return;

        root.state = State.Visited;
        // Adds to end of queue
        queue.add(root);
        Map<GraphNode, Integer> level = new HashMap<>();
        level.put(root, 0);
        while (!queue.isEmpty()) {
            // removes from front of queue
            GraphNode r = queue.remove();
            System.out.print(r.getVertex() + "\t");

            // Visit child first before grandchild
            for (GraphNode n : r.getChild()) {
                if (n.state == State.Unvisited) { // to avoid cycles
                    level.put(n, level.get(r) + 1);
                    queue.add(n);
                    n.state = State.Visited;
                }
            }
        }

        Map r = level.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        r.entrySet().stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("---------------BFS---------------");
        GraphNode A = GraphNode.createNewGraph();
        bfs(A);
    }
}
