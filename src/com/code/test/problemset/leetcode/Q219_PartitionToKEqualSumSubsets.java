package com.code.test.problemset.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Partition to K Equal Sum Subsets
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * Example 1:
 * <p>
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 * Accepted
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 *
 * ????
 * Time Complexity: O(k^{N-k} k!)
 * where NN is the length of nums, and kk is as given. As we skip additional zeroes in groups, naively we will make O(k!)O(k!) calls to search, then an additional O(k^{N-k})O(k
 * N−k
 *  ) calls after every element of groups is nonzero.
 *
 * Space Complexity: O(N), the space used by recursive calls to search in our call stack.
 */
public class Q219_PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (k <= 0 || sum % k != 0)
            return false;

        int[] visited = new int[nums.length];

        return canPartition(nums, visited, 0, k, 0, sum / k);
    }


    public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int target) {
        if (k == 1) // could also be 0 but since all sum is divided by k then definitely the last one will be sum
            return true;

        if (cur_sum == target)
            return canPartition(nums, visited, 0, k - 1, 0, target);

        for (int i = start_index; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (canPartition(nums, visited, i + 1, k, cur_sum + nums[i], target))
                    return true;
                visited[i] = 0;
            }
        }
        return false;
    }
}
