package com.code.test.problemset.leetcode;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of
 * the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 * <p>
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class Q7_ProductOfArray {

    public static void main(String[] args) {
        productExceptSelf_Ali(new int[]{1, 2, 3, 4});
    }


    public static int[] productExceptSelf_Ali(int[] nums) {
        if (nums[0] == 0 && nums[1] == 0) {
            return new int[nums.length];
        }

        int start = 0;
        int total = nums[start] != 0 ? nums[start] : nums[++start];
        int zeroCount = (start == 1) ? 1 : 0;
        int zeroIndex = -1;
        while (++start < nums.length) {
            if (nums[start] != 0) {
                total = total * nums[start];
            } else {
                zeroCount++;
                zeroIndex = start;
                if (zeroCount > 1) {
                    return new int[nums.length];
                }
            }
        }

        if (zeroCount == 1) {//first two are zeros
            int[] result = new int[nums.length];
            result[zeroIndex] = total;
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = total / nums[i];
        }

        return nums;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0] = 1;
        t2[nums.length - 1] = 1;

        //scan from left to right
        for (int i = 0; i < nums.length - 1; i++) {
            t1[i + 1] = nums[i] * t1[i];
        }

        //scan from right to left
        for (int i = nums.length - 1; i > 0; i--) {
            t2[i - 1] = t2[i] * nums[i];
        }

        //multiply
        for (int i = 0; i < nums.length; i++) {
            result[i] = t1[i] * t2[i];
        }

        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];

        result[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] * left;
            left = left * nums[i];
        }

        return result;
    }
}
