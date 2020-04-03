package com.code.test.problemset.basics;

import java.util.Arrays;

/**
 * Created by aliismail on 07/11/2017.
 */
public class SelectionSort {

    /**
     * Getting smallest in each iteration and put it on first.
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr == null)
            return;
        if (arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
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