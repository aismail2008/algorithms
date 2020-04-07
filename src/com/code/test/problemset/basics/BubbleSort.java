package com.code.test.problemset.basics;

import java.util.Arrays;

/**
 * Runtime O(n2) average and worst.
 * Space O(1)􏰁􏱍􏰷􏱹􏱖􏰤􏰈􏰋 􏰋􏰏 􏰽􏰏 􏰏 􏰎􏲊􏰈􏱮􏰎􏱕􏰈 􏰎􏰷􏰃 􏱉􏱃􏱮􏱐􏱹 􏰄􏰎􏱐􏰈􏰉 􏰆􏰈􏰤􏱃􏱮􏱏􏰍 􏰋􏰏 􏰍􏰉 􏰀
 * @param <E>
 */
public class BubbleSort<E> {

    @SuppressWarnings("unchecked")
    public void bubbleSort(E[] arr) {
        if (arr == null)
            return;
        if (arr.length == 1) {
            return;
        }

        int n = arr.length;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < (n - i); j++) {
//
//                if ((((Comparable) (arr[j])).compareTo(arr[j + 1])) > 0) {
//                    E tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//                }
//
//            }
//        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if ((((Comparable) arr[j]).compareTo(arr[j + 1])) > 0) {
                    E tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = tmp;
    }

    public static void main(String[] args) {

        BubbleSort<Integer> bubbleSort = new BubbleSort();

        Integer[] unsorted = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort.bubbleSort(unsorted);
        Arrays.stream(unsorted).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        unsorted = new Integer[]{9, 80, 71, 36, 0, 55, 14, 23, -1, 1};
        bubbleSort.bubbleSort(unsorted);
        Arrays.stream(unsorted).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        bubbleSort.bubbleSort(null);

        bubbleSort.bubbleSort(new Integer[1]);
    }
}