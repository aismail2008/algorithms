package com.code.test.problemset.companies.Zalando;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstTechInter {

	public static void main(String[] args) {
		firstProblem(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 12, 13, 14, 15 });
		Set<String> dic = new HashSet<String>();
		dic.add("a");
		dic.add("ab");
		dic.add("sdf");
		boolean found = isDictionaryConcat("afdslfdlskfd", dic);
		System.out.println(found);
	}

	// 1. Given an array of n numbers from 0 - n (missing one number) you need to find the missing number
	public static void firstProblem(int[] a) {
		int total = a.length * (a.length + 1) / 2;
		for (int i : a) {
			total -= i;
		}

		System.out.println(total);
	}

	// 2. Given a directed graph (figure), implement the structure and a deep copy function
	public static Node secondProblem(Node root) {// dfs
		Node newRoot = new Node();
		DFS(root, newRoot);
		return newRoot;
	}

	public static void DFS(Node root, Node newRoot) {// dfs
		if (root == null) {
			newRoot = null;
			return;
		}

		newRoot.data = root.data;
		root.visited = true;
		newRoot.visited = true;

		for (Node n : root.children) {
			if (!n.visited) {
				Node child = new Node();
				newRoot.children.add(child);
				DFS(n, child);
			}
		}

	}

	public static class Node {
		public String data;
		public boolean visited;
		public List<Node> children;

		public Node() {
			children = new ArrayList<Node>();
		}
	}

	// 3. Given a long string (e.g., �afdslfdlskfd��) and a dictionary (e.g., �a�, �ab�, �sdf�, etc.). Check whether the string is a concatenation of words in dictionary, if yes, please print a solution
	// Another solution is to build B-Tree and navigate on it with coming characters till you get to end of string
	public static boolean isDictionaryConcat(String s, Set<String> dic) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (dic.contains(s.substring(0, i + 1))) {
				boolean test = isDictionaryConcat(s.substring(i + 1), dic);
				if(test)
					return true;
			}
		}

		return false;
	}
}
