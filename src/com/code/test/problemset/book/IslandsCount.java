package com.code.test.problemset.book;

import java.util.HashSet;
import java.util.Set;

public class IslandsCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ?? 105 - 106, 128, 134
		// 114, 115, 116, 120, 123, 124, 129, 130, 131, 132, 138
		int[] done = new int[] { 1, 2, 3, 4, 5, (6), 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, (18), 19, 20, 				// 20
				21, 22, (23), 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 							// 40
				41, 42, 43, 44, 45, (46), 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 							// 60
				61, 62, 63, 64, 65, 66, (67), 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 							// 80
				81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 							// 100
				101, 102, 103, 104, (105), (106), 107, 108, 109, 110, 111, 112, 113, 117, 118, (119), 121, 122, 125, 126, 	// 120
				127, (128), 133, (134), 135, 136, 137, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151};	// 140

		Set his = new HashSet<Integer>();
		
		while(his.size() < 140)
		{
			int r = (int) (Math.random() * 1000) % 140;
			if(!his.contains(r)){
				System.out.print(done[r] + " -  ");
				his.add(r);
			}
		}
		
//		int i = -1, j = 0;
//		int[] today = new int[10];
//		do {
//			i = ;
////			if (Arrays.binarySearch(done, i) <= 0)
////				today[j++] = i;
//		} while (j < 50);
//		System.out.println("Done = " + done.length);
//		System.out.println("Remaining = " + (151 - done.length));
//		Arrays.sort(today);
//		for (i = 0; i < 10; i++)
//			System.out.print(today[i] + ", ");
	}
}
