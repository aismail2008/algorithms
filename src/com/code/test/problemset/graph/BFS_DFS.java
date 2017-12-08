package com.code.test.problemset.graph;

import java.util.*;

public class BFS_DFS {

    //--------------Deapth------------------//
    public static void dfs(Node root) {
        // Avoid infinite loops
        if (root == null)
            return;

        System.out.print(root.getVertex() + "\t");
        root.state = State.Visited;

        // for every child
        for (Node n : root.getChild()) {
            // if childs state is not visited then recurse
            if (n.state == State.Unvisited) {
                dfs(n);
            }
        }
    }
    //use DFS for cycle detection for undirected graph
    //          A------B------c
    //          |      |      |
    //          |      |      |
    //          |      |      |
    //          F      E------D
    //
    public static boolean dfs_cycle_undirected(Node root, Node comingFrom) {
        // Avoid infinite loops
        if (root == null)
            return false;
        if (root.state == State.Visited)
            return true;

        root.state = State.Visited;

        // for every child
        for (Node n : root.getChild()) {
            // if childs state is not visited then recurse
            if (n != comingFrom) {
                if(dfs_cycle_undirected(n, root))
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
    static List<Node> white = new ArrayList<>();
    static List<Node> gray = new ArrayList<>();
    static List<Node> black = new ArrayList<>();
    public static boolean dfs_cycle_directed() {
        for(Node n : white){
            white.remove(n);
            gray.add(n);
            dfs_cycle_directed(n);
        }
        return false;
    }

    public static boolean dfs_cycle_directed(Node root) {
        for(Node child : root.getChild()){
            if(black.contains(child))
                continue;
            if(gray.contains(child))
                return true;
            else{
                white.remove(child);
                gray.add(child);
                if(dfs_cycle_directed(child))
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

    // Use a stack for the iterative DFS version
    public static void dfs_iterative(ArrayList<ArrayList<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        while (!st.isEmpty()) {
            int v = st.pop();
            if (!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");
                // auxiliary stack to visit neighbors in the order they appear
                // in the adjacency list
                // alternatively: iterate through ArrayList in reverse order
                // but this is only to get the same output as the recursive dfs
                // otherwise, this would not be necessary
                Stack<Integer> auxStack = new Stack<Integer>();
                for (int w : adj.get(v)) {
                    if (!visited[w]) {
                        auxStack.push(w);
                    }
                }
                while (!auxStack.isEmpty()) {
                    st.push(auxStack.pop());
                }
            }
        }
        System.out.println();
    }
        //--------------Breadth------------------//

    public static void bfs(Node root) {
        // Since queue is a interface
        Queue<Node> queue = new LinkedList<Node>();

        if (root == null)
            return;

        root.state = State.Visited;
        // Adds to end of queue
        queue.add(root);

        while (!queue.isEmpty()) {
            // removes from front of queue
            Node r = queue.remove();
            System.out.print(r.getVertex() + "\t");

            // Visit child first before grandchild
            for (Node n : r.getChild()) {
                if (n.state == State.Unvisited) {
                    queue.add(n);
                    n.state = State.Visited;
                }
            }
        }

    }

    public static Node createNewGraph() {
//		Graph g = new Graph();
//		Node[] temp = new Node[8];

        Node A = new Node("A", 2);
        Node B = new Node("B", 2);
        Node C = new Node("C", 2);
        Node D = new Node("D", 0);
        Node E = new Node("E", 0);
        Node F = new Node("F", 0);
        Node G = new Node("G", 0);

        A.addChildNode(B);
        A.addChildNode(C);

        B.addChildNode(D);
        B.addChildNode(E);

        C.addChildNode(F);
        C.addChildNode(G);

//		for (int i = 0; i < 7; i++) {
//			g.addNode(temp[i]);
//		}
        return A;
    }

    public static void main(String[] args) {

        Node A = createNewGraph();
//		BFS_DFS s = new BFS_DFS();

        System.out.println("--------------DFS---------------");
        dfs(A);
        System.out.println();
        System.out.println();
        A = createNewGraph();
        System.out.println("---------------BFS---------------");
        A = createNewGraph();
        bfs(A);

    }
}