package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

/**
 * 􏰲􏰣􏰴􏰵􏰭􏰶 Search in Rotated Sorted Array􏰷􏰕
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 */
@Medium
public class Q44_SearchInRotatedArray {

    public static void main(String[] args) {
        search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5);
        search(new int[]{ 10, 0, 1, 5 }, 3);
        search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
    }

    public static int search(int a[], int x) {
        return index(a, 0, a.length - 1, x);
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a the array of integers, must be sorted in ascending order
     * @param x the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int index(int[] a, int low, int high, int x) {
        if (low > high)
            return -1;
        if (low == high && a[low] != x)
            return -1;

        int mid = low + (high - low) / 2;
        if (a[mid] == x) {
            return mid;
        }

        if (a[low] <= a[mid]) { //left sorted
            if (x < a[mid] && x >= a[low]) {
                return index(a, low, mid - 1, x);
            } else {
                return index(a, mid + 1, high, x);
            }
        } else { //right sorted
            if (x > a[mid] && x <= a[high]) {
                return index(a, mid + 1, high, x);
            } else {
                return index(a, low, mid - 1, x);
            }
        }
    }
}
