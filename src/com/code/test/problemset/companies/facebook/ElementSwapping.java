package com.code.test.problemset.companies.facebook;

/**
 * Element Swapping
 * Given a sequence of n integers arr, determine the lexicographically smallest sequence which may be obtained from it after performing at most k element swaps, each involving a pair of consecutive elements in the sequence.
 * Note: A list x is lexicographically smaller than a different equal-length list y if and only if, for the earliest index at which the two lists differ, x's element at that index is smaller than y's element at that index.
 * Signature
 * int[] findMinArray(int[] arr, int k)
 * Input
 * n is in the range [1, 1000].
 * Each element of arr is in the range [1, 1,000,000].
 * k is in the range [1, 1000].
 * Output
 * Return an array of n integers output, the lexicogaphically smallest sequence achievable after at most k swaps.
 * Example 1
 * n = 3
 * k = 2
 * arr = [5, 3, 1]
 * output = [1, 5, 3]
 * We can swap the 2nd and 3rd elements, followed by the 1st and 2nd elements, to end up with the sequence [1, 5, 3]. This is the lexicogaphically smallest sequence achievable after at most 2 swaps.
 * Example 2
 * n = 5
 * k = 3
 * arr = [8, 9, 11, 2, 1]
 * output = [2, 8, 9, 11, 1]
 * We can swap [11, 2], followed by [9, 2], then [8, 2].
 */

import java.util.Arrays;

public class ElementSwapping {
    /*
        let start = 0
        find arr[i] < arr[start] between start to start + k
        if found pop to front and decrement k
        shift start on step ahead
        repeat till k = 0 or start+k is the end

    */
    static int[] findMinArray(int[] arr, int k) {
        return findMinArray(arr, 0, k);
    }

    static int[] findMinArray(int[] arr, int start, int k) {
        if (k == 0 || start == arr.length - 1) {
            return arr;
        }

        int nextStart = start + 1;

        int end = Math.min(start + k, arr.length - 1);
        int minI = -1;
        int minVal = arr[start];
        start++;
        while (start <= end) {
            if (arr[start] < minVal) {
                minI = start;
                minVal = arr[start];
            }
            start++;
        }
        // pop to front
        if (minI != -1) {
            while (k > 0 && minI > 0 && arr[minI] < arr[minI - 1]) {
                int t = arr[minI];
                arr[minI] = arr[minI - 1];
                arr[minI - 1] = t;
                minI--;
                k--;
            }
        }
        return findMinArray(arr, nextStart, k);
    }

    public static void main(String[] args) {
        Arrays.stream(findMinArray(new int[]{8, 9, 11, 2, 1}, 100)).forEach(i -> System.out.print(i + ", "));
        System.out.println(" ");
        Arrays.stream(findMinArray(new int[]{5, 3, 1}, 10)).forEach(i -> System.out.print(i + ", "));
    }
}
