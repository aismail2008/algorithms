package com.code.test.problemset.leetcode;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] < nums[1] > nums[2] < nums[3].... Example:
 * <p>
 * Input: nums = [3,5,2,1,6,4]
 * 1,3,2,5,4,6
 * Output: One possible answer is [3,5,1,6,2,4]
 *
 * https://leetcode.com/problems/wiggle-sort/
 */
public class Q33_wiggleSort {
    public static void main(String[] args) {
        new Q33_wiggleSort().wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
        System.out.println();
        new Q33_wiggleSort().wiggleSort_(new int[]{3, 5, 2, 1, 6, 4});
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i = i + 2) {
            swap(i, i + 1, nums);
        }

        Arrays.stream(nums).forEach(i -> System.out.print(i + ", "));
    }

    private void swap(int i, int i1, int[] nums) {
        if (i1 < nums.length) {
            int t = nums[i];
            nums[i] = nums[i1];
            nums[i1] = t;
        }
    }

    public void wiggleSort_(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) {
                    swap(nums, i - 1, i);
                }
            } else {
                if (nums[i - 1] < nums[i]) {
                    swap(nums, i - 1, i);
                }
            }
        }
        Arrays.stream(nums).forEach(i -> System.out.print(i + ", "));
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
