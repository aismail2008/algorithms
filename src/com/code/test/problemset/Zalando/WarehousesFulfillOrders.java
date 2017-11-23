package com.code.test.problemset.Zalando;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WarehousesFulfillOrders {

	static HashSet<String> allSubsets;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int W = Integer.valueOf(input[0]);
		int B = Integer.valueOf(input[1]);
		int P = Integer.valueOf(input[2]);
		int[][] stocks = new int[W][P];
		for (int i = 0; i < W; i++) {
			input = sc.nextLine().split(" ");
			for (int j = 0; j < P; j++) {
				stocks[i][j] = Integer.valueOf(input[j]);
			}
		}
		List<String> orders = new ArrayList<String>(B);
		while (B > 0) {
			orders.add(sc.nextLine());
			B--;
		}
		List<String> solutions = new ArrayList<String>();

		for (int i = 0; i < orders.size(); i++) {
			input = orders.get(0).split(" ");
			if (input[i].equals("0"))
				continue;
			else {
				allSubsets = new HashSet<>();
				find(stocks, i, Integer.parseInt(input[i]), new HashSet<Integer>(), 0);
				
				int oldSize = solutions.size();
				int h = 0;
				while(h < oldSize) {
					String sorFar = solutions.remove(0);
					for(int k = 0; k < allSubsets.size(); k++){
						Iterator<String> it =  allSubsets.iterator();
						while(it.hasNext()){
							solutions.add(sorFar + it.next());
						}
					}
					h++;
				}
			}
		}
		sc.close();
	}

	private static void find(int[][] input, int p, int target, Set<Integer> ramp, int index) {
		if (index > input.length - 1) {
			if (getSum(ramp) == target) {
				allSubsets.add(toString(ramp));
			}
			return;
		}

		find(input, p, target, updatedSet(ramp, input[index][p]), index + 1);
		find(input, p, target, ramp, index + 1);
	}

	private static Set<Integer> updatedSet(Set<Integer> ramp, int integer) {
		Set<Integer> updated = new HashSet<Integer>();
		updated.addAll(ramp);
		updated.add(integer);
		return updated;
	}

	private static String toString(Set<Integer> ramp) {
		StringBuilder builder = new StringBuilder();
		for (Integer integer : ramp) {
			if(integer == 0)
				continue;
			builder.append(integer+"-");
		}
		return builder.toString();
	}

	private static int getSum(Set<Integer> integers) {
		int sum = 0;
		for (Integer integer : integers) {
			sum += integer;
		}
		return sum;
	}

	// public static List<String> getAllSupport(int req, int[][] stocks, int col) {
	// List<String> soluction = new ArrayList<String>();
	// for (int i = 0; i < stocks.length; i++) {
	// if (stocks[i][col] == 0) {
	// continue;
	// }
	//
	// if (stocks[i][col] >= req) {
	// soluction.add(i + "-");
	// } else {
	// for (int j = i + 1; j < stocks.length; j++) {
	// if (stocks[i][col] >= req) {
	// soluction.add(i + "-");
	// }
	// }
	// }
	// }
	// return null;
	// }
}
