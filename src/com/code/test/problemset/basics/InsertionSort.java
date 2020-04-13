package com.code.test.problemset.basics;

import java.util.Arrays;

/**
 * Created by aliismail on 07/11/2017.
 */
public class InsertionSort {

    /**
     * start with list of size 1 and then insert elements in its right position.
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr == null)
            return;
        if (arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, i, j);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = tmp;
    }

    public static void main(String a[]) {
        int[] unsorted = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(unsorted);
        Arrays.stream(unsorted).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        unsorted = new int[]{9, 80, 71, 36, 0, 55, 14, 23, -1, 1};
        sort(unsorted);
        Arrays.stream(unsorted).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        sort(null);
        sort(new int[1]);
    }
}