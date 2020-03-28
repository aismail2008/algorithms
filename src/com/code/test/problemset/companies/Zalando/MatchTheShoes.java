package com.code.test.problemset.companies.Zalando;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MatchTheShoes {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String[] inputs = sc.nextLine().split(" ");
		int k = Integer.valueOf(inputs[0]);
		int m = Integer.valueOf(inputs[1]);
		int n = Integer.valueOf(inputs[2]);

		Map<Integer, Integer> shoesRank = new HashMap<Integer, Integer>();
		while (sc.hasNext() && n > 0) {
			int ShoesId = Integer.valueOf(sc.nextLine());
			Integer score = shoesRank.get(ShoesId);
			if (score == null)
				score = 0;
			score++;
			shoesRank.put(ShoesId, score);
			n--;
		}

		List<Entry<Integer, Integer>> sortedRank = new LinkedList<Entry<Integer, Integer>>(shoesRank.entrySet());

		Collections.sort(sortedRank, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o1.getValue().compareTo(o2.getValue()) == 0)
					return o1.getKey().compareTo(o2.getKey());
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		for(Entry<Integer, Integer> ent : sortedRank){
			System.out.println(ent.getKey());
			if(--k == 0)
				break;
		}
//		sortedRank.forEach(System.out::print);
		
	}
}
