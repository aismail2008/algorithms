package com.code.test.problemset.leetcode;


/**
 * Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * <p>
 * <p>
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 * <p>
 * <p>
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class _RangeSumQueryImmutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    static class NumArray {
        int[] totals;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            totals = new int[nums.length];
            if (nums.length > 0) {
                totals[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    totals[i] = nums[i] + totals[i - 1];
                }
            }
        }

        public int sumRange(int i, int j) {
            return totals[j] - totals[i] + nums[i];
        }
    }
}
