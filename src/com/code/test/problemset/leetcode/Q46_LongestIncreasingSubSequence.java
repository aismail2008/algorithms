package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 * https://leetcode.com/problems/longest-increasing-subsequence
 */
public class Q46_LongestIncreasingSubSequence {

    public static void main(String[] args) {
        new Q46_LongestIncreasingSubSequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4});
        new Q46_LongestIncreasingSubSequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    // Time complexity : O(n^2)
    //Space complexity : O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        for (int i = 1; i < nums.length; i++) {
            int cnt = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    cnt = Math.max(cnt, max[j] + 1);
                }
            }
            max[i] = cnt;
        }

        return Arrays.stream(max).max().getAsInt();
    }

    // Simplyfing the above using Binary Search
    // We can put the increasing sequence in a list.
    //
    //  for each num in nums
    //     if(list.size()==0)
    //          add num to list
    //     else if(num > last element in list)
    //          add num to list
    //     else
    //          replace the element in the list which is the smallest but bigger than num
    //  [9, 1, 3, 7, 5, 6, 20]
    //   9
    //   1
    //   1  3
    //   1  3  7
    //   1  3  5
    //   1  3  5 6
    //   1  3  5 6 20
    // O(n log n)
    // O(n)
    static public int lengthOfLIS_(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (list.size() == 0 || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (list.get(mid) < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                list.set(j, num);
            }
        }

        return list.size();
    }
}
