package com.code.test.problemset.sort;

public class BubbleSort<E> {

	@SuppressWarnings("unchecked")
	public static <E> void bubbleSort(E[] unsorted) {
		for (int iter = 1; iter < unsorted.length; iter++) {
			for (int inner = 0; inner < (unsorted.length - iter); inner++) {
				if ((((Comparable) (unsorted[inner])).compareTo(unsorted[inner + 1])) > 0) {
					E tmp = unsorted[inner];
					unsorted[inner] = unsorted[inner + 1];
					unsorted[inner + 1] = tmp;
				}
			}
		}
	}

	public static <E> void display(E[] unsorted) {
		for (E i : unsorted) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] unsorted = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		display(unsorted);
		bubbleSort(unsorted);
		display(unsorted);
	}
}