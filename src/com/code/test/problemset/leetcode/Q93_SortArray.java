package com.code.test.problemset.leetcode;

import com.code.test.problemset.basics.QuickSort;

import java.util.Arrays;

/**
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * https://leetcode.com/problems/sort-an-array
 */
public class Q93_SortArray {
    public static void main(String[] args) {
        Arrays.sort(args);
        new QuickSort();
    }
}
