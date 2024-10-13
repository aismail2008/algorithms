package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

/**
 * Search Insert Index : Search Insert Position
 * Given a sorted array and a target value,
 * return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 * <p>
 * https://leetcode.com/problems/search-insert-position/
 */
@Easy
public class Q37_SearchInsertPosition {

    public int searchInsert(int[] numbers, int val) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = (hi + lo) / 2;
            if (val < numbers[mid])
                hi = mid - 1;
            else if (val > numbers[mid])
                lo = mid + 1;
            else {
                return mid;
            }
        }
        return lo;
    }
}
