package com.code.test.problemset.basics;

import com.code.test.problemset.basics.datastructure.GraphNode;
import com.code.test.problemset.basics.datastructure.State;

import java.util.*;

/**
 * O(V + E)
 * Idea:
 *  - use Queue.
 *  - Mark visited before add
 *  - Print on Remove from Queue to keep order as BFS
 */
public class BFS {

    public static void bfs(GraphNode root) {
        // Since queue is a interface
        Queue<GraphNode> queue = new LinkedList<GraphNode>();

        if (root == null)
            return;

        root.state = State.Visited;
        // Adds to end of queue
        queue.add(root);

        while (!queue.isEmpty()) {
            // removes from front of queue
            GraphNode r = queue.remove();
            System.out.print(r.getVertex() + "\t");

            // Visit child first before grandchild
            for (GraphNode n : r.getChild()) {
                if (n.state == State.Unvisited) { // to avoid cycles
                    queue.add(n);
                    n.state = State.Visited;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("---------------BFS---------------");
        GraphNode A = GraphNode.createNewGraph();
        bfs(A);
    }
}