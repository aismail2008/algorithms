package com.code.test.problemset.programcreekbook;

import java.util.HashMap;
import java.util.Map;

public class Chess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minPath(7, 3));
		System.out.println("================");
		System.out.println(solution(7, 3));

	}

	public static int solution(int A, int B) {
		Map<Integer, Integer> steps = new HashMap<Integer, Integer>();
		steps.put(0, 0);
		boolean success = checkPath(A, B, steps);
		if (success) {
			if (steps.get(0) > 100000000)
				return -2;
			else
				return steps.get(0);
		}

		return -1;
	}

	public static int minPath(int A, int B) {
		System.out.println(A + ", " + B);
		if (A == 0 && B == 0)
			return 0;
		if (A < 0 || B < 0)
			return -1;
		if (A == 0 && B != 0)
			return -1;
		if (B == 0 && A != 0)
			return -1;

		int i = minPath(A - 1, B - 2);
		int j = minPath(A - 2, B - 1);

		if (i == -1 && j == -1)
			return -1;
		else if (i == -1)
			return j + 1;
		else if (j == -1)
			return i + 1;
		else
			return 1 + ( i < j ? i : j);
	}

	public static boolean checkPath(int A, int B, Map<Integer, Integer> steps) {
		System.out.println(A + ", " + B);
		if (A == 0 && B == 0)
			return true;
		if (A < 0 || B < 0)
			return false;
		if (A == 0 && B != 0)
			return false;
		if (B == 0 && A != 0)
			return false;
		steps.put(0, steps.get(0) + 1);
		return checkPath(A - 1, B - 2, steps) || checkPath(A - 2, B - 1, steps);
	}
	// public static int solution(int A, int B, int steps) {
	// if(A == 0 && B == 0)
	// return steps;
	// if(A == 0 && B != 0)
	// return -1;
	// if(B == 0 && A != 0)
	// return -1;
	//
	// int solFirst =-1;
	// if(A-1 > 0 && B-2 >0)
	// solFirst = solution(A-1, B-2, steps+1);
	// int solSecond = -1;
	// if(A-2 > 0 && B-1 >0)
	// solSecond = solution(A-2, B-1, steps+1);
	//
	// if(solFirst ==-1 && solSecond ==-1)
	// return -1;
	// if(solFirst > -1 && solFirst < solSecond)
	// return solFirst;
	// else if(solSecond > -1 && solSecond < solFirst)
	// return solSecond;
	// else return -1;
	// }
	//
	// public static void findpath(int b[12][12], int startx, int starty,
	// int endx, int endy, int &nsteps)
	// {
	// int i;
	// int j;
	// int newb[12][12];
	//
	// b[startx][starty] = 1;
	// // increate steps
	// for (nsteps = 0; nsteps < 100; nsteps++) {
	// // if we can reach end point now, return steps
	// if (b[endx][endy] == 1)
	// return;
	// // create a temporary new board
	// for (i = 2; i <= 9; i++)
	// for (j = 2; j <= 9; j++)
	// newb[i][j] = b[i][j];
	// // for each reachable spot, we can try to jump
	// for (i = 2; i <= 9; i++)
	// for (j = 2; j <= 9; j++)
	// if (b[i][j] == 1) {
	// newb[i + 1][j + 2] = 1;
	// newb[i + 1][j - 2] = 1;
	// newb[i - 1][j + 2] = 1;
	// newb[i - 1][j - 2] = 1;
	// newb[i + 2][j + 1] = 1;
	// newb[i + 2][j - 1] = 1;
	// newb[i - 2][j + 1] = 1;
	// newb[i - 2][j - 1] = 1;
	// }
	// // copy back temporary board
	// for (i = 2; i <= 9; i++)
	// for (j = 2; j <= 9; j++)
	// b[i][j] = newb[i][j];
	// }
	// nsteps = 999; // error indication
	// }

	// void init(int b[12][12])
	// {
	// for (int i = 0; i < 12; i++) {
	// for (int j = 0; j < 12; j++) {
	// if ((i > 1) && (j > 1) && (i < 10) && (j < 11)) {
	// b[i][j] = 0; // valid spot
	// } else {
	// b[i][j] = -1; // invalid spot
	// }
	// }
	// }
	// }
}
