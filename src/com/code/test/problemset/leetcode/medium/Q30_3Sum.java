package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.*;

/**
 *
 * 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * https://leetcode.com/problems/3sum/
 */
@Medium
public class Q30_3Sum {
    public static void main(String[] args) {
        new Q30_3Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {// optimization to avoid double checking same number again
                continue;
            }
            int target = -1 * nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> s1 = new ArrayList<>();
                    s1.add(nums[i]);
                    s1.add(nums[j]);
                    s1.add(nums[k]);
//                    Collections.sort(s1);
                    res.add(s1);
                    k--;
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        return res;
    }
}
