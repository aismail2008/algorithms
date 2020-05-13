package com.code.test.problemset.leetcode;

/**
 * Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Q39_MinimumRotatedSortedArray {

    public static void main(String[] args) {
        new Q39_MinimumRotatedSortedArray().findMin(new int[]{2, 1});
        new Q39_MinimumRotatedSortedArray().findMin(new int[]{3, 4, 5, 1, 2});
        new Q39_MinimumRotatedSortedArray().findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
    }

    public int findMin(int arr[]) {
        if (arr == null || arr.length == 0)
            return 0;
        int min = binarySearch(arr, 0, arr.length - 1);
        return min;
    }

    int binarySearch(int[] arr, int st, int end) {
        if (st > end)
            return Integer.MAX_VALUE;
        if(st == end || end == st +1){
            return Math.min(arr[st], arr[end]);
        }

        int mid = (st + end) / 2;

        if (arr[mid] > arr[st]) { //left is sorted

            return Math.min(arr[st], binarySearch(arr, mid + 1, end));

        } else { // right is sorted
            return Math.min(arr[mid], binarySearch(arr, st, mid - 1));
        }
    }
}
