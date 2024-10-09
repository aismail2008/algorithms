package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] < nums[1] > nums[2] < nums[3].... Example:
 * <p>
 * Input: nums = [3,5,2,1,6,4]
 * 1,3,2,5,4,6
 * Output: One possible answer is [3,5,1,6,2,4]
 * <p>
 * https://leetcode.com/problems/wiggle-sort/
 */
@Medium
public class Q33_wiggleSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        Q33_wiggleSort sorter = new Q33_wiggleSort();
        sorter.wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Expected output: A valid wiggle sequence like [3, 5, 1, 6, 2, 4]
    }

    /**
     * Reorders the array in a wiggle fashion.
     * Time Complexity:
     *      O(n): We only need to pass through the array once, making swaps as necessary.
     * @param nums the input array
     */
    public static void wiggleSort(int[] nums) {
        // Traverse the array and enforce the wiggle pattern
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                // For even index, nums[i] should be less than or equal to nums[i + 1]
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                // For odd index, nums[i] should be greater than or equal to nums[i + 1]
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    /**
     * Helper method to swap elements at index i and j in the array.
     *
     * @param nums the array
     * @param i    the first index
     * @param j    the second index
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //-----*------------//
}
