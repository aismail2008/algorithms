package com.code.test.problemset.basics.datastructure;

public class GraphNode {
    public GraphNode[] child;
    public int childCount;
    private String vertex;
    public State state;

    public GraphNode(String vertex) {
        this.vertex = vertex;
    }

    public GraphNode(String vertex, int childlen) {
        this.vertex = vertex;
        childCount = 0;
        child = new GraphNode[childlen];
    }

    public void addChildNode(GraphNode adj) {
        adj.state = State.Unvisited;
        if (childCount < 30) {
            this.child[childCount] = adj;
            childCount++;
        }
    }

    public GraphNode[] getChild() {
        return child;
    }

    public String getVertex() {
        return vertex;
    }


    public static GraphNode createNewGraph() {
        GraphNode A = new GraphNode("A", 2);
        GraphNode B = new GraphNode("B", 2);
        GraphNode C = new GraphNode("C", 3);
        GraphNode D = new GraphNode("D", 0);
        GraphNode E = new GraphNode("E", 0);
        GraphNode F = new GraphNode("F", 0);
        GraphNode G = new GraphNode("G", 0);

        A.addChildNode(B);
        A.addChildNode(C);

        B.addChildNode(D);
        B.addChildNode(E);

        C.addChildNode(F);
        C.addChildNode(G);

        C.addChildNode(A);// will be avoided

        return A;
    }
}