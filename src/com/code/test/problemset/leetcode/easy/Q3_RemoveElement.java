package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

/**
 * Given an array and a value,
 * remove all instances of that value in place and return the new length.
 * (Note: The order of elements can be changed. It doesn't matter what you leave beyond the new length.)
 * <p>
 * https://leetcode.com/problems/remove-element/
 */
@Easy
public class Q3_RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
