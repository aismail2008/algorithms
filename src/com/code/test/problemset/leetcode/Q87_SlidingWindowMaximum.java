package com.code.test.problemset.leetcode;

/**
 * Sliding Window Maximum:
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 *  Example:
 *  Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 *  Output: [3,3,5,5,6,7]
 *  Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class Q87_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[]{};
        }
        int[] max = new int[nums.length - k + 1];

        int maxIndex = 0;

        for (int i = 1; i < k; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        max[0] = nums[maxIndex];
        int i = 1;
        for (; i <= nums.length - k; i++) {
            if (nums[i + k - 1] > nums[maxIndex]) {
                maxIndex = i + k - 1;
            }
            if (maxIndex < i) {
                maxIndex = i;
                for (int j = i+1; j < i + k; j++) {
                    if (nums[maxIndex] < nums[j]) {
                        maxIndex = j;
                    }
                }
            }
            max[i] = nums[maxIndex];
        }
        return max;
    }

    public static void main(String[] args) {
        new Q87_SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        new Q87_SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }
}
