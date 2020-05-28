package com.code.test.problemset.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum:
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 * <p>
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7] 8     7
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class Q87_SlidingWindowMaximum {
    // O(N2)
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
                for (int j = i + 1; j < i + k; j++) {
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

    // O(N)
    public int[] maxSlidingWindow_O_N(int[] nums, int k) {
        // A deque which holds the max elements for window size of k
        Deque<Integer> maxWindowQueue = new LinkedList<>();
        // Max window to be returned
        int[] maxWindow = new int[nums.length + 1 - k];

        int left = 0, right = 0, mwCtr = 0;

        while (right < nums.length) {
            int dig = nums[right];

            // Remove from the end, those elements which are smaller than dig.
            while (!maxWindowQueue.isEmpty() && dig > maxWindowQueue.getLast()) {
                maxWindowQueue.removeLast();
            }

            // Add the new found element.
            maxWindowQueue.addLast(dig);

            // We have reached the window size
            if (right - left + 1 == k) {
                maxWindow[mwCtr] = maxWindowQueue.getFirst();
                mwCtr++;

                // Now we need to slice the left corner
                // Doing so, If you find the number being removed is the max element we need to pop
                // that element as well from the dequeue
                if (nums[left] == maxWindowQueue.getFirst()) {
                    maxWindowQueue.removeFirst();
                }
                // Slice the left corner
                left++;
            }

            // Increment right as usual
            right++;
        }
        return maxWindow;
    }
}
