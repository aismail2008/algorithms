package com.code.test.problemset.leetcode;

import java.util.Arrays;

/**
 * Merge Sorted Array (Java)
 * <p>
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p>
 * Note:
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 *
 * https://leetcode.com/problems/merge-sorted-array
 */
public class Q16_MergeSortedArray {
//    Given two sorted integer arrays A and B, merge B into A as one sorted array.
//    Note: You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

    public static void main(String[] args) {
        int[] a = new int[]{0};
        int[] b = new int[]{1};
        merge(a, 0, b, 1);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void merge(int[] a, int n, int[] b, int m) {
        m = m - 1;
        n = n -1;
        int h = a.length - 1;
        while (h >= 0 && m >= 0 && n >= 0) {
            if (b[m] > a[n]) {
                a[h] = b[m];
                m--;
            } else {
                a[h] = a[n];
                n--;
            }
            h--;
        }

        while (m >= 0) {
            a[h--] = b[m--];
        }
    }
}
