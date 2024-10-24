package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

/**
 * Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
@Medium
public class Q41_FirstLastPositionSortedArray {
    public static void main(String[] args) {
        int[] resp = new Q41_FirstLastPositionSortedArray().searchRange(new int[]{0,0,0,0,0,1,1,2,2,3,4,4,5,5,5,5,6,7}, 0);
        System.out.println(resp.toString());
        resp = new Q41_FirstLastPositionSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(resp.toString());
        resp = new Q41_FirstLastPositionSortedArray().searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(resp.toString());
    }

    public int[] searchRange(int[] nums, int target) {
        return binarySearach(nums, 0, nums.length - 1, target, -1, -1);
    }

    public int[] binarySearach(int[] nums, int low, int high, int target, int rLow, int rHigh) {
        if (low > high) {
            return new int[]{rLow, rHigh};
        }

        int mid = (low + high) / 2;

        if (nums[mid] == target) {
                int[] range1 = binarySearach(nums, low, mid - 1, target, rLow, mid);
                if (range1[0] == -1)
                    range1[0] = mid;
                int[] range2 = binarySearach(nums, mid + 1, high, target, mid, rHigh);
                if (range2[1] == -1)
                    range2[1] = mid;
                return new int[]{range1[0], range2[1]};
        } else if (nums[mid] < target) {
            return binarySearach(nums, mid + 1, high, target, rLow, rHigh);
        } else {
            return binarySearach(nums, low, mid - 1, target, rLow, rHigh);
        }
    }
}
