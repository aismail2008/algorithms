package com.code.test.problemset.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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