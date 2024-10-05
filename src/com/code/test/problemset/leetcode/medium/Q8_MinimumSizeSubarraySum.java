package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.Arrays;

/**
 * Minimum Size Subarray Sum (Java)
 * <p>
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length of 2 under the problem constraint
 * <p>
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
@Medium
public class Q8_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        minSubArrayLen_2( 7, new int[]{2,3,1,2,4,3});
    }
    public static int minSubArrayLen_2(int target, int[] nums) {
        if(Arrays.stream(nums).sum() < target)
            return 0;

        int i = 0;
        int j = 0;
        int length = nums.length;
        int sum = 0;
        while(i < nums.length){
            if(sum < target){
                sum += nums[i];
                i++;
            }else { // equal or larger
                length = Math.min(length, i - j);
                if(length == 1) // no need to continue checking
                    return 1;

                sum -= nums[j];
                j++;
            }
        }
        // for last included I before checking
        while (sum >= target) {
            length = Math.min(length, i - j);
            sum -= nums[j];
            j++;
        }
        return length;
    }
}
