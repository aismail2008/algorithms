package com.code.test.problemset.programcreekbook;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
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
