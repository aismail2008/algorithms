package com.code.test.problemset.companies.Zalando;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoesItFit {

	// --------------1-
	// 100 100
	// 3
	// R 3 3
	// R 3 230
	// R 140 1
	// YES
	// NO
	// YES
	// --------------2-
	// 4 5
	// 3
	// R 1 2
	// R 5 5
	// C 2
	// YES
	// NO
	// YES
	//----------------3-
//1 1
//12
//R 1 1
//R 2 1
//R 1 2
//R 2 2
//R 1 3
//R 2 3
//R 3 3
//C 1
//C 2
//C 3
//R 1000 1000
//C 1000
//YES
//NO
//NO
//NO
//NO
//NO
//NO
//NO
//NO
//NO
//NO
//NO
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int a = Math.max(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
		int b = Math.min(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
		int N = Integer.valueOf(sc.nextLine());
		List<String> inputList = new ArrayList<String>(N);
		while (N > 0) {
			inputList.add(sc.nextLine());
			N--;
		}
		int i = 0;
		while (i < inputList.size()) {
			input = inputList.get(i).split(" ");

			if (input[0].equals("R")) {
				int p = Math.max(Integer.valueOf(input[1]), Integer.valueOf(input[2]));
				int q = Math.min(Integer.valueOf(input[1]), Integer.valueOf(input[2]));
				if (p <= a && q <= b)
					System.out.println("YES");
				else {
					double sumPower = Math.pow(p, 2) + Math.pow(q, 2);
					double diffPower = Math.pow(p, 2) - Math.pow(q, 2);
					if (p > a && b >= (((2 * p * q * a) + (diffPower * Math.pow(sumPower - Math.pow(a, 2), 0.5))) / sumPower))
						System.out.println("YES");
					else
						System.out.println("NO");
				}
			} else if (input[0].equals("C")) {
				if (((22 / 7) * Math.pow(Integer.valueOf(input[1]), 2)) < a * b)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			i++;
		}
		sc.close();
	}
}
