package com.code.test.problemset.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 * <p>
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * <p>
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Q40_MinimumRotatedSortedArrayII {

    public static void main(String[] args) {
        new Q40_MinimumRotatedSortedArrayII().findMin(new int[]{10, 1, 10, 10, 10});
        new Q40_MinimumRotatedSortedArrayII().findMin(new int[]{2, 2, 2, 0, 1});
    }

    public int findMin(int arr[]) {
        if (arr == null || arr.length == 0)
            return 0;
        int min = binarySearch(arr, 0, arr.length - 1);
        System.out.println(min);
        return min;
    }

    int binarySearch(int[] arr, int st, int end) {
        if (st > end)
            return Integer.MAX_VALUE;
        if (st == end || end == st + 1) {
            return Math.min(arr[st], arr[end]);
        }

        int mid = (st + end) / 2;

        if (arr[mid] == arr[st]) {
            while (arr[mid] == arr[st] && mid != st)
                st++;
            return binarySearch(arr, st, end);
        } else if (arr[mid] == arr[end]) {
            while (arr[mid] == arr[end] && mid != end)
                end--;
            return binarySearch(arr, st, end);
        }

        if (arr[mid] > arr[st]) { //left is sorted
            return Math.min(arr[st], binarySearch(arr, mid + 1, end));
        } else {
            return Math.min(arr[mid], binarySearch(arr, st, mid - 1));
        }
    }
}
