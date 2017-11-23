package com.code.test.problemset.Amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AmazonChallenge {
	public static class Node {
		int cost;
		int index;
	}

	public static int solution(int[] a) {
		int minCost = Integer.MAX_VALUE;
		Queue<Node> q = new LinkedList<Node>();

		Node n1 = new Node();
		n1.cost = 2;
		n1.index = 0;
		q.add(n1);

		Node n7 = new Node();
		n7.cost = 7;
		n7.index = 0;
		int lastDay = a[0] + 6;
		while (n7.index + 1 < a.length && a[n7.index + 1] <= lastDay)
			n7.index++;
		q.add(n7);

		while (!q.isEmpty()) {
			Node n = q.remove();

			if (n.index >= a.length - 1) {
				if (n.cost < minCost) {
					minCost = n.cost;
				}
			} else {
				n1 = new Node();
				n1.cost = n.cost + 2;
				n1.index = n.index + 1;
				if (n1.cost < 25)
					q.add(n1);

				n7 = new Node();
				n7.cost = n.cost + 7;
				n7.index = n.index;
				lastDay = a[n.index] + 6;
				while (n7.index + 1 < a.length && a[n7.index + 1] <= lastDay)
					n7.index++;

				if (n7.cost < 25)
					q.add(n7);
			}
		}

		return minCost > 25 ? 25 : minCost;
	}

	public static void main(String[] args) {
		// int a[] = new int[] {};
		// System.out.println(solution(a));

		//
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String s = br.readLine();
		// while (s != null && !s.equalsIgnoreCase("")) {
		// System.out.println("This is : " + s);
		// s = br.readLine();
		// }
		//
		//
		//
		//// Node n30 = new Node();
		//// n30.cost = n.cost + 25;
		//// n30.index = n.index;
		//// lastDay = a[n.index] + 30;
		//// while(a[n7.index+1] <= lastDay)
		//// n7.index++;
		////
		//// q.add(n7);
		//
		Scanner s = new Scanner(System.in);
		while (s.hasNext() && s.nextLine() != "") {
			String t = s.nextLine();
			System.out.println("This is : " + s);
		}
	}

}
