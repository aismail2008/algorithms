package com.code.test.problemset.programcreekbook;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Permutations {
	public static class Node {
		String prefix;
		String remain;
	}
	
	public static void main(String[] args) {
		permutation("123");
		System.out.println("================");
		permutationIterative("123");
	}

	public static Set<String> permutationIterative(String s) {
		Node n = new Node();
		n.prefix = "";
		n.remain = s;
		Deque<Node> q = new LinkedList<Node>();
		Set<String> set = new HashSet<String>();
		q.add(n);
		while (!q.isEmpty()) {
			n = q.poll();
			if (n.remain.length() == 1) {
				set.add(n.prefix + n.remain);
			} else {
				for (int i = n.remain.length() - 1; i >=0 ; i--) {
					Node child = new Node();
					child.prefix = n.prefix + n.remain.substring(i, i+1);
					child.remain = n.remain.substring(0, i) + n.remain.substring(i + 1, n.remain.length());
					q.addFirst(child);
				}
			}
		}
		return set;
	}

	// O ( n2 * n ! )
	// 7 * 6 * .. *1 = !n time will be called the permutation
	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {//
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else { //O(n * !n)
			for (int i = 0; i < n; i++) // O(n)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)); //O(!n)
		}
	}
}
