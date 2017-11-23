package com.code.test.problemset.book.CodingInterview3;

import java.util.Arrays;

/**
 * Created by aliismail on 12/11/2017.
 */
public class N14 {
//        Given an array S of n integers, find three integers in S such that the sum is
//        closest to a given number, target. Return the sum of the three integers. You may assume that each
//        input would have exactly one solution. For example, given array S = -1 2 1 -4, andtarget=1.
//        Thesumthatisclosesttothetargetis2. (-1+2+1=2).

    public static void main(String[] args) {
        closeThreeSumSorted(new int[] { -1, 2, 1, -4}, 1);
    }

    public static String closeThreeSumSorted(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        String solution = "";
        for (int i = 0; i < nums.length - 2; i++) {
            int k = nums.length - 1;
            int j = i + 1;
            while (j < k) {
                if (nums[k] + nums[j] + nums[i] == target) {
                    if (diff > Math.abs(nums[k] + nums[j] + nums[i] - target)) {
                        solution = nums[i] + " + " + nums[j] + " + " + nums[k];
                        diff = Math.abs(nums[k] + nums[j] + nums[i] - target);
                    }
                    j++;
                    k--;
                } else if (nums[k] + nums[j] + nums[i] > target) {
                    if (diff > Math.abs(nums[k] + nums[j] + nums[i] - target)) {
                        solution = nums[i] + " + " + nums[j] + " + " + nums[k];
                        diff = Math.abs(nums[k] + nums[j] + nums[i] - target);
                    }
                    k--;
                } else {
                    if (diff > Math.abs(nums[k] + nums[j] + nums[i] - target)) {
                        solution = nums[i] + " + " + nums[j] + " + " + nums[k];
                        diff = Math.abs(nums[k] + nums[j] + nums[i] - target);
                    }
                    j++;
                }
            }
        }
        System.out.print(solution);
        return solution;
    }
}
