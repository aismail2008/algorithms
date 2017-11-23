package com.code.test.problemset.book;

public class A12ContainerWithMostWater {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 3, 4, 3, 6, 3 };

	}

	public static int solution(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return max;

		// int maxBarIndex = 0;
		// double maxArea = 0.0;
		// for(int i = 1; i < arr.length; i++){
		// if(arr[maxBarIndex] <arr[i])
		// maxBarIndex = i;
		// maxArea = Math.max(maxArea, getArea(arr, maxBarIndex, i));
		// }
		//
		// System.out.println(maxArea);
	}

//	private static double getArea(int[] arr, int maxBarIndex, int i) {
//		get first maximum element before me
//		return Math.min(arr[i], arr[maxBarIndex]) * (i - maxBarIndex);
//	}
}
