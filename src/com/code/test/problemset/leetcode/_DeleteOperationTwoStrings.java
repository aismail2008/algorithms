package com.code.test.problemset.leetcode;

/**
 * Delete Operation for Two Strings
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */
public class _DeleteOperationTwoStrings {

    static int deletionDistance(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }

        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        int i = 0;
        int index = -1;
        while (i < str1.length()) {
            index = str2.indexOf(str1.charAt(i) + "");
            if (index != -1)
                break;
            i++;
        }

        if (index == -1) {
            return i + str2.length();
        } else {
            return i + index + deletionDistance(str1.substring(i + 1), str2.substring(index + 1));
        }
    }

    // Using Dynamic Programming and Q274_LongestCommonSubsequence
    // This will find minimum number of values to be removed EX "execution", "intention"
    //Time Complexity: the time complexity stays the same, i.e. O(N⋅M), since we still run a nested loop with N⋅M iterations.
    //
    //Space Complexity: O(N,M)
    static int deletionDistance_1(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {

                if (j == 0 || i == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int longest = dp[str1.length()][str2.length()];
        return str1.length() - longest + str2.length() - longest;
    }

    // Optimize space to O(n)
    public int minDistance_2(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int[] temp = new int[s2.length() + 1];
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    temp[j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    temp[j] = dp[j - 1];
                else
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
            }
            dp = temp;
        }
        return dp[s2.length()];
    }
}
