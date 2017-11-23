package com.code.test.problemset.book;

public class SubarrayProductLessK {

	public static void main(String[] args) {
		countAli(new int[] { 2, 5, 11, 2, 1, 6 }, 30);
	}

	// 6/10
	static long count(int[] items, int check) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			// j is the number of elements which should be printed
			for (int j = i; j < items.length; j++) {
				long multi = 1;
				boolean include = true;
				// print the array from i to j
				for (int k = i; k <= j; k++) {
					multi *= items[k];
					if (multi >= check) {
						include = false;
						break;
					}
				}
				if (!include)
					break;
				if (include)
					count++;
			}
		}

		return count;

	}

	static long countAli(int[] arr, int k) {
		long count = 0;
		int end = 0;
		;
		long multi = 1;
		for (int i = 0; i < arr.length; i++) {
			count += (end - i);
			while (end < arr.length) {
				multi *= arr[end++];
				if (multi < k)
					count++;
				else {
					multi /= arr[--end];
					break;
				}
			}
			multi /= arr[i];
		}
		return count;
	}

}
