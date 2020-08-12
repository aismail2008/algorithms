package com.code.test.problemset.companies.Flex;

public class FlexChallenge2 {
	public static int solution(int[] a) {
		int start = 0;
		int i = 0;
		for (; i < a.length; i++) {
			if (a[i] != 0)
				break;
		}
		int end = i;
		int max = end - start + 1;

		while (end + 1 < a.length) {
			if (a[end + 1] == 0) {
				a[end + 1] = a[end] < 0 ? 1 : -1;
			}

			if (a[end + 1] * a[end] < 0) { // different signs
				end++;
			} else {
				if (end - start + 1 > max)
					max = end - start + 1;
				start = end + 1;
				end++;
			}
		}
		if (end - start + 1 > max)
			max = end - start + 1;

		return max;
	}

	public static void main(String[] args) {
		solution(new int[] { 0, 0, 0, 0, 0, 0, 5, 4, -3, 2, 0, 1, -1, 0, 2, -3, 4, -5 });
	}

}
