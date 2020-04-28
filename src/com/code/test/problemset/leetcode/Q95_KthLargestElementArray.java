package com.code.test.problemset.leetcode;

import java.util.Arrays;

/**
 * Kth Largest Element in an Array
 * <p>
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * <p>
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length
 * <p>
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */
public class Q95_KthLargestElementArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }
}
