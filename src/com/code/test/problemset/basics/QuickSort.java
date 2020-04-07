package com.code.test.problemset.basics;

import java.util.Arrays;

/**
 *  Runtime O(n log n) average and O(n2) worst.
 *  Space O(1)􏰁􏱍􏰷􏱹􏱖􏰤􏰈􏰋
 */
public class QuickSort {
    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        quickSort(inputArr, 0, inputArr.length - 1);
    }

    private void quickSort(int[] array, int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array, i, higherIndex);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String a[]) {
        QuickSort sorter = new QuickSort();

        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        sorter.sort(inputArr);
        Arrays.stream(inputArr).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        inputArr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sorter.sort(inputArr);
        Arrays.stream(inputArr).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        inputArr = new int[]{9, 80, 71, 36, 0, 55, 14, 23, -1, 1};
        sorter.sort(inputArr);
        Arrays.stream(inputArr).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        inputArr = new int[]{24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        sorter.sort(inputArr);
        Arrays.stream(inputArr).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        sorter.sort(null);
        sorter.sort(new int[1]);
    }
}
