package com.code.test.problemset.Zalando;

import java.util.Scanner;

public class MinimalWrappingArea {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		String[] input = sc.nextLine().split(" ");
		int w = Integer.valueOf(input[0]);
		int l = Integer.valueOf(input[1]);
		int h = Integer.valueOf(input[2]);
		Long minimumCubeArea = Long.MAX_VALUE;
		for (int i = 1; i <= n; i++) {// cube W side
			for (int j = 1; j <= n / i; j++) { // cube L side
				int cubeW = i * w;
				int cubeL = j * l;
				float nubmerOfBoxLevel = i * j;
				int cubeH = (int) (Math.ceil(n / nubmerOfBoxLevel) * h);

				minimumCubeArea = Math.min(minimumCubeArea, 2 * (cubeW * cubeH) + 2 * (cubeW * cubeL) + 2 * (cubeL * cubeH));
			}
		}
		
		System.out.println(minimumCubeArea);
	}
}
