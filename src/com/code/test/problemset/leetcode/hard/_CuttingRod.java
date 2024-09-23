package com.code.test.problemset.leetcode.hard;

import com.code.test.problemset.leetcode.Hard;

/**
 * Given a rod of length 'n' and an array denoting the profits for each length.
 * Please find the locations at which the cuts are to be made for maximum profit.
 */
@Hard
public class _CuttingRod {

    public int dp(int[] prices) {
        int[] dp = new int[prices.length + 1];
        dp[0] = 0;

        for (int i = 1; i <= prices.length; i++) {

            int max = -1;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(max, prices[j-1] + dp[i - j]);
            }
        }

        return dp[prices.length];
    }

    public static void main(String[] args) {
        new _CuttingRod().dp(new int[]{1, 5, 8, 9, 10});
    }
}
