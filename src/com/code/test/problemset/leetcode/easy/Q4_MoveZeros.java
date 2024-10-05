package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

import java.util.Arrays;

/**
 * Given an array nums,
 * write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example,
 * given nums = [0, 1, 0, 3, 12],
 * after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * https://leetcode.com/problems/move-zeroes/
 */
@Easy
public class Q4_MoveZeros {

    static public int[] moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0})));
    }
}
