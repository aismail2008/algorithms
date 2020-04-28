package com.code.test.problemset.leetcode;

/**
 * Shortest Unsorted Continuous Subarray:
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/submissions/
 */
public class _ShortestUnsortedContinuousSubarray {
    public static int findRightSequenceStart(int[] array) {
        int max = Integer.MIN_VALUE;
        int lastNo = 0;
        for (int i = 0; i < array.length; i++) {
            if (max > array[i]) {
                lastNo = i;
            }
            max = Math.max(array[i], max);
        }
        return lastNo;
    }

    public static int findLeftSequenceEnd(int[] array) {
        int min = Integer.MAX_VALUE;
        int lastNo = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (min < array[i]) {
                lastNo = i;
            }
            min = Math.min(array[i], min);
        }
        return lastNo;
    }

    public static int findUnsortedSubarray(int[] array) {
        int leftSequenceEnd = findRightSequenceStart(array);
        int rightSequenceEnd = findLeftSequenceEnd(array);
        if (rightSequenceEnd == leftSequenceEnd)
            return 0;
        return Math.abs(leftSequenceEnd - rightSequenceEnd) + 1;
    }
}
