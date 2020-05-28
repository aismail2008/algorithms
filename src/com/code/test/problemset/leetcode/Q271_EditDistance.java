package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Edit Distance
 * <p>
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * <p>
 * https://leetcode.com/problems/edit-distance
 *
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 */
public class Q271_EditDistance {
    //    Edit Distance in Java
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] mem = new int[m][n];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        return calDistance(word1, word2, mem, m - 1, n - 1);
    }

    private int calDistance(String word1, String word2, int[][] mem, int i, int j) {
        if (i < 0) {
            return j + 1;
        } else if (j < 0) {
            return i + 1;
        }

        if (mem[i][j] != -1) {
            return mem[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            mem[i][j] = calDistance(word1, word2, mem, i - 1, j - 1);
        } else {
            int min1 = calDistance(word1, word2, mem, i, j - 1);// add at word1
            int min2 = calDistance(word1, word2, mem, i - 1, j);// remove at word1
            int min3 = calDistance(word1, word2, mem, i - 1, j - 1); // replace at word1
            min2 = Math.min(min1, min2);
            min3 = Math.min(min2, min3);

            mem[i][j] = 1 + min3;
        }

        return mem[i][j];
    }

    static class SolutionDP {
        public static void main(String[] args) {
            diffBetweenTwoStrings("horse", "ros");
        }

        static int diffBetweenTwoStrings(String src, String trg) {
            return diffBetweenTwoStrings(src, trg, new ArrayList<>());
        }

        static int diffBetweenTwoStrings(String src, String trg, List<String> result) {
            int[][] dp = new int[trg.length() + 1][src.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (src.charAt(j - 1) == trg.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = 1 + Math.min(min, dp[i - 1][j - 1]);
                    }
                }
            }

            // this if only you want the output sting with operations
            // to convert src to target
            int j = src.length();
            int i = trg.length();
            while (j > 0 || i > 0) {
                if (src.charAt(j - 1) == trg.charAt(i - 1)) {
                    result.add("" + src.charAt(j - 1));
                    i--;
                    j--;
                } else {
                    if (dp[i][j - 1] < dp[i - 1][j - 1] && dp[i][j - 1] < dp[i - 1][j]) {
                        result.add("-" + src.charAt(j - 1));
                        j--;
                    } else if (dp[i - 1][j] < dp[i - 1][j - 1] && dp[i - 1][j] < dp[i][j - 1]) {
                        result.add("+" + trg.charAt(i-1));
                        i--;
                    } else {
                        result.add("" + trg.charAt(i-1));
                        j--;
                        i--;
                    }
                }
            }
//            return result;

            return dp[trg.length()][src.length()];
        }
    }
}
