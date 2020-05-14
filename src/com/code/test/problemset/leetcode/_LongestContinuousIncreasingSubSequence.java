package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 * https://leetcode.com/problems/longest-increasing-subsequence
 */
public class _LongestContinuousIncreasingSubSequence {

    public static void main(String[] args) {
    }

    // Time complexity : O(n^2)
    //Space complexity : O(n)
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int longest = 1;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                longest = Math.max(longest, i - start);
                start = i;
            } else if (i == nums.length - 1) {
                longest = Math.max(longest, i - start + 1);
            }
        }
        return longest;
    }
}
