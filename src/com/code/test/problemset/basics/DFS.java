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
            System.out.print(root.getVertex()+ ", ");

            for (int i = root.childCount; i > 0; i--) {// add right to left
                if (root.getChild()[i -1].state == State.Unvisited) {
                    root.getChild()[i -1].state = State.Visited;
                    stack.push(root.getChild()[i -1]);
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

    // use DFS for cycle detection for undirected graph
    //          A------B------c
    //          |      |      |
    //          |      |      |
    //          |      |      |
    //          F      E------D
    //
    public static boolean dfs_cycle_undirected(GraphNode root, GraphNode comingFrom) {
        // Avoid infinite loops
        if (root == null)
            return false;
        if (root.state == State.Visited)
            return true;

        root.state = State.Visited;

        // for every child
        for (GraphNode n : root.getChild()) {
            // if childs state is not visited then recurse
            if (n != comingFrom) {
                if (dfs_cycle_undirected(n, root))
                    return true;
            }
        }

        return false;
    }

    //use DFS for cycle detection for directed graph
    /**
     * We need to move all nodes from white to black passing by gray. if found in gray twice then it has cyclic
     */
    //https://www.youtube.com/watch?v=rKQaZuoUR4M&t=8s
    static List<GraphNode> white = new ArrayList<>();
    static List<GraphNode> gray = new ArrayList<>();
    static List<GraphNode> black = new ArrayList<>();

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