package com.code.test.problemset.companies.Zalando;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ZalandoTestC {

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String s = br.readLine();
		// while (s != null && !s.equalsIgnoreCase("")) {
		// System.out.println("This is : " + s);
		// s = br.readLine();
		// }
		// Scanner sc = new Scanner(System.in);
		// while (true) {
		// int charAscii = (int) sc.nextLine().charAt(0);
		// System.out.println("Your ascii is : " + charAscii);
		// }

		System.out.println(solution(new int[]{1000000000,1000000000,1000000000,1000000000,1000000000}, new int[]{3,3,2,2,3}, 3, 5, 1000000000));
		
		System.out.println(solution(new int[]{}, new int[]{}, 3, 5, 1000000000));
	}

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		// initialize variables
		int totalStops = 0;
		long totalWeightPerRound = 0;
		int maxPersonsCount = 0;
		Set<Integer> floorsSet = new HashSet<Integer>();
		int currPerson = 0;
		boolean startLift = false;
		while (currPerson < A.length) {
			// Should current person be considered?
			if ((totalWeightPerRound + A[currPerson]) <= Y && (maxPersonsCount + 1) <= X) {
				totalWeightPerRound += A[currPerson];
				maxPersonsCount++;
				floorsSet.add(B[currPerson]);
				// If curr person is last person then start the lift
				if (currPerson == A.length - 1)
					startLift = true;

				currPerson++;
			} else {
				startLift = true;
			}

			if (startLift) {
				totalStops += floorsSet.size() + 1;
				// reset variable
				floorsSet.clear();;
				maxPersonsCount = 0;
				totalWeightPerRound = 0;
				startLift = false;
			}
		}

		return totalStops;
	}
}
