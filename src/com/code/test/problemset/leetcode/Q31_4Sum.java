package com.code.test.problemset.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 4Sum
 * Add to List
 * Share
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * https://leetcode.com/problems/4sum/
 */
public class Q31_4Sum {

    public List<List<Integer>> fourSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        k++;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    } else {
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        result.add(t);
                        k++;
                        l--;

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    }
                }
            }
        }
        return result;
    }

    static class SolutionTimeLimitExceeded {
        public static void main(String[] args) {
            new SolutionTimeLimitExceeded().solve(new int[]{1, 0, -1, 0, -2, 2}, 2, 0);
            new SolutionTimeLimitExceeded().solve(new int[]{-1, 0, 1, 2, -1, -4}, 3, 0);
            new SolutionTimeLimitExceeded().solve(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, 4, -11);
        }

        Set<List<Integer>> res;

        public List<List<Integer>> solve(int[] nums, int k, int target) {
            res = new HashSet<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;

                List<Integer> s = new ArrayList();
                s.add(nums[i]);
                canFind(nums, i + 1, k - 1, 0, target - nums[i], s);
            }
            res.forEach(l -> {
                l.forEach(i -> System.out.print(i + ","));
                System.out.println();
            });
            return res.stream().collect(Collectors.toList());
        }

        public boolean canFind(int[] nums, int start_index, int k, int cur_sum, int target, List<Integer> s) {
            if (k == 0 && cur_sum == target) {
                Collections.sort(s);
                res.add(s);
                return true;
            } else if (k == 0) {
                return false;
            }

            for (int i = start_index; i < nums.length; i++) {
                s.add(nums[i]);
                canFind(nums, i + 1, k - 1, cur_sum + nums[i], target, new ArrayList<>(s));
                s.remove(s.size() - 1);

            }
            return true;
        }
    }
}
