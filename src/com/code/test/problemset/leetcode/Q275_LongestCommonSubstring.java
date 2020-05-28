package com.code.test.problemset.leetcode;

/**
 * Longest Common Substring
 * In computer science, the longest common substring problem is to find the longest string that is a substring of two or more strings.
 */
public class Q275_LongestCommonSubstring {

    // https://www.youtube.com/watch?v=BysNXJHzCEs
    public static int getLongestCommonSubstring(String a, String b) {
        int m = a.length();
        int n = b.length();

        int max = 0;

        int[][] dp = new int[m][n];
        // left col
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        // top row
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }
        return max;
    }
}
