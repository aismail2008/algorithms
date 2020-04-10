package com.code.test.problemset.basics;

import com.code.test.problemset.basics.datastructure.GraphNode;
import com.code.test.problemset.basics.datastructure.State;

import java.util.*;

public class DFS {

    public static void dfs(GraphNode root) {
        // Avoid infinite loops
        if (root == null)
            return;

        root.state = State.Visited;
        System.out.print(root.getVertex() + ", ");

        for (GraphNode child : root.getChild()) {
            if (child.state == State.Unvisited) {
                dfs(child);
            }
        }
    }

    public static void dfs_iter(GraphNode root) {
        // Avoid infinite loops
        if (root == null)
            return;

        Stack<GraphNode> stack = new Stack<>();
        root.state = State.Visited;
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.getVertex() + ", ");

            for (int i = root.childCount; i > 0; i--) {// add right to left
                if (root.getChild()[i - 1].state == State.Unvisited) {
                    root.getChild()[i - 1].state = State.Visited;
                    stack.push(root.getChild()[i - 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode A = GraphNode.createNewGraph();
        System.out.println("--------------DFS---------------");
        dfs(A);
        System.out.println("\n--------------DFS---------------");
        A = GraphNode.createNewGraph();
        dfs_iter(A);
    }

    static class UndirectedGraphCycle {
        int vertices;
        LinkedList<Integer>[] adjList;

        public UndirectedGraphCycle(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            //add forward edge
            adjList[source].addFirst(destination);

            //add reverse edge
            adjList[destination].addFirst(source);
        }

        public boolean isCycle() {
            boolean result = false;

            //visited array
            boolean[] visited = new boolean[vertices];
            //do DFS, from each vertex
            for (int i = 0; i < vertices; i++) {
                if (visited[i] == false) {
                    if (isCycleUtil(i, visited, -1)) {
                        return true;
                    }
                }
            }
            return result;
        }

        boolean isCycleUtil(int currVertex, boolean[] visited, int parent) {

            //add this vertex to visited vertex
            visited[currVertex] = true;

            //visit neighbors except its direct parent
            for (int i = 0; i < adjList[currVertex].size(); i++) {
                int vertex = adjList[currVertex].get(i);
                //check the adjacent vertex from current vertex
                if (vertex != parent) {
                    //if destination vertex is not its direct parent then
                    if (visited[vertex]) {
                        //if here means this destination vertex is already visited
                        //means cycle has been detected
                        return true;
                    } else {
                        //recursion from destination node
                        if (isCycleUtil(vertex, visited, currVertex)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        // use DFS for cycle detection for undirected graph
        //          0------5------2
        //          |      |      |
        //          |      |      |
        //          |      |      |
        //          1      4------3
        //

        public static void main(String[] args) {
            int vertices = 6;
            UndirectedGraphCycle graph = new UndirectedGraphCycle(vertices);
            graph.addEdge(0, 1);
            graph.addEdge(0, 5);
            graph.addEdge(5, 2);
            graph.addEdge(2, 3);
            graph.addEdge(3, 4);

            boolean result = graph.isCycle();
            System.out.println("is Cycle present: " + result);
        }
    }

    static class DirectedGraphCycle {
        //use DFS for cycle detection for directed graph
        /**
         * We need to move all nodes from white to black passing by gray. if found in gray twice then it has cyclic
         */
        //https://www.youtube.com/watch?v=rKQaZuoUR4M&t=8s
        static List<GraphNode> white = new ArrayList<>(); // list didn't visit yet
        static List<GraphNode> gray = new ArrayList<>(); // list of nodes being visited right now
        static List<GraphNode> black = new ArrayList<>();// list of nodes visited with all of its children

        public static boolean dfs_cycle_directed() {
            for (GraphNode n : white) {
                white.remove(n);
                gray.add(n);
                dfs_cycle_directed(n);
            }
            return false;
        }

        public static boolean dfs_cycle_directed(GraphNode root) {
            for (GraphNode child : root.getChild()) {
                if (black.contains(child))
                    continue;
                if (gray.contains(child))
                    return true;
                else {
                    white.remove(child);
                    gray.add(child);
                    if (dfs_cycle_directed(child))
                        return true;
                }
            }
            gray.remove(root);
            black.add(root);

            return false;
        }

        // recursive dfs
        private static void dfs_rec(ArrayList<ArrayList<Integer>> adjLists, boolean[] visited, int v) {
            visited[v] = true;
            System.out.print(v + " ");
            for (int w : adjLists.get(v)) {
                if (!visited[w]) {
                    dfs_rec(adjLists, visited, w);
                }
            }
        }
    }
}