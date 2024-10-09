package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

/**
 * Wiggle Subsequence
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate
 * between positive and negative.
 * The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3)
 * are alternately positive and negative.
 * In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences,
 * the first because its first two differences are positive and the second because its last difference is zero.
 * <p>
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence.
 * Example 2:
 * <p>
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * Example 3:
 * <p>
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * Follow up:
 * Can you do it in O(n) time?
 * <p>
 * https://leetcode.com/problems/wiggle-subsequence/
 */
@Medium
public class Q34_WiggleSubsequence {

    public static void main(String[] args) {
        new Q34_WiggleSubsequence().wiggleMaxLength(new int[]{84});
        new Q34_WiggleSubsequence().wiggleMaxLength(new int[]{1, 1, 7, 4, 9, 2, 5});
        new Q34_WiggleSubsequence().wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        new Q34_WiggleSubsequence().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5});
        new Q34_WiggleSubsequence().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
    }

    public class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length < 2)
                return nums.length;
            int down = 1, up = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1])
                    up = down + 1;
                else if (nums[i] < nums[i - 1])
                    down = up + 1;
            }
            return Math.max(down, up);
        }
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length < 2) {
            return nums.length;
        }

        int count = 1;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            // Get me the first number against my value Up Or Down
            if (nums[j] < nums[i]) {
                count++;
                while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                    i++;
                }
            } else if (nums[j] > nums[i]) {
                count++;
                while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                    i++;
                }
            }
            j = i;
        }

        return count;
    }

}
