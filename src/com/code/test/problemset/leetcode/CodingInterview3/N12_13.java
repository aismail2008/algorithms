package com.code.test.problemset.leetcode.CodingInterview3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aliismail on 12/11/2017.
 */
public class N12_13 {

    public static void main(String[] args) {
        threeSumSorted(new int[] { 2, 7, 11, 15 }, 0);
    }

    public static Set<String> threeSumSorted(int[] nums, int target) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < nums.length - 2; i++) {
            int k = nums.length - 1;
            int j = i + 1;
            while (j < k) {
                if (nums[k] + nums[j] + nums[i] == target) {
                    result.add(nums[i] + " + " + nums[j] + " + " + nums[k]);
                    j++;
                    k--;
                } else if (nums[k] + nums[j] + nums[i] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    // 5- 4Sum
    public static Set<String> fourSumSorted(int[] nums, int target) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        result.add(nums[i] + " + " + nums[j] + " + " + nums[k]);
                        k++;
                        l--;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
