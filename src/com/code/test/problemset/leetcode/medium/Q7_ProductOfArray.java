package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

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
@Medium
public class Q7_ProductOfArray {

    public static void main(String[] args) {
        arrayOfArrayProducts(new int[]{1, 2, 3, 4});
    }


    static int[] arrayOfArrayProducts(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return new int[]{};
        }

        int[] leftArr = new int[arr.length];
        leftArr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = leftArr[i - 1] * arr[i - 1];
        }

        int right = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            leftArr[i] *= right;
            right *= arr[i];
        }

        return leftArr;
    }
}
