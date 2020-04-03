package com.code.test.problemset.CrackingCodingInterview6.ch4;

import com.code.test.problemset.basics.datastructure.Graph;
import com.code.test.problemset.basics.datastructure.GraphNode;
import com.code.test.problemset.basics.datastructure.State;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Route Between Nodes:
 *      Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class Q1_RouteBetweenNodes {

    public static boolean search(Graph g, GraphNode start, GraphNode end) {
        LinkedList<GraphNode> q = new LinkedList<GraphNode>();
        for (GraphNode u : g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        GraphNode u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (GraphNode v : u.getChild()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    public static boolean bfs(GraphNode root, GraphNode target) {
        // Since queue is a interface
        Queue<GraphNode> queue = new LinkedList<GraphNode>();

        if (root == null)
            return false;

        root.state = State.Visited;
        // Adds to end of queue
        queue.add(root);

        while (!queue.isEmpty()) {
            // removes from front of queue
            GraphNode r = queue.remove();

            if (r.getVertex().compareTo(target.getVertex()) == 0)
                return true;

            // Visit child first before grandchild
            for (GraphNode n : r.getChild()) {
                if (n.state == State.Unvisited) { // to avoid cycles
                    queue.add(n);
                    n.state = State.Visited;
                }
            }
        }
        return false;
    }

    public static void main(String a[]) {
        Graph g = createNewGraph();
        GraphNode[] n = g.getNodes();
        GraphNode start = n[0];
        GraphNode end = n[5];
        System.out.println(search(g, start, end));

        g = createNewGraph();
        n = g.getNodes();
        start = n[3];
        end = n[3];
        boolean found = false;
        for (GraphNode ch : start.getChild()) {
            if (bfs(ch, end)) {
                found = true;
                break;
            }
        }
        System.out.println(found);
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        GraphNode[] temp = new GraphNode[6];

        temp[0] = new GraphNode("a", 3);
        temp[1] = new GraphNode("b", 0);
        temp[2] = new GraphNode("c", 0);
        temp[3] = new GraphNode("d", 1);
        temp[4] = new GraphNode("e", 1);
        temp[5] = new GraphNode("f", 0);

        temp[0].addChildNode(temp[1]);
        temp[0].addChildNode(temp[2]);
        temp[0].addChildNode(temp[3]);
        temp[3].addChildNode(temp[4]);
        temp[4].addChildNode(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addEdge(temp[i]);
        }
        return g;
    }
}