package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Russian Doll Envelopes
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * https://leetcode.com/problems/russian-doll-envelopes
 */
@Hard
public class Q48_RussianDollEnvelopes {

    public static void main(String[] args) {
        int cnt = new Q48_RussianDollEnvelopes().maxEnvelopes(new int[][]{
                {2, 100}, {3, 200}, {4, 300}, {5, 250}, {5, 400}, {5, 500}, {6, 360}, {6, 370}, {7, 380}
                // 1        2          3         3        4         4          4         4         5
                // 5250 5400 5500
        });

        System.out.println(cnt);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        int max = 1;
        int[] arr = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            arr[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    /**
     * Optimized with Binary Search and convert it to
     * We can sort the envelopes by height in ascending order and width in descending order.
     * [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
     * Then look at the width and find the {@link com.code.test.problemset.leetcode.Q46_LongestIncreasingSubSequence}.
     * This problem is then converted to the problem of finding
     */
    public int maxEnvelopes_(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0
                || envelopes[0].length == 0 || envelopes[0].length != 2) {
            return 0;
        }
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
                    if (a[0] == b[0]) {
                        return b[1] - a[1];
                    } else {
                        return a[0] - b[0];
                    }
                }
        );
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
