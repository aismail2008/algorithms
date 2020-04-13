package com.code.test.problemset.leetcode;

import java.util.*;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 * <p>
 * https://leetcode.com/problems/unique-paths/
 */
public class Q267_UniquePath {

    public static void main(String[] args) {

        uniquePaths(51,9);
//        Solution_Ali2 s = new Solution_Ali2();
//        s.uniquePaths(3, 2);
//        s.uniquePaths(7, 3);
//        s.uniquePaths(51, 9); //timeout
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];

        //left column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        //top row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        //fill up the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        System.out.println( dp[m - 1][n - 1]);
        return dp[m - 1][n - 1];
    }

    //Timout for large value
    static class SolutionAli_1 {
        int cnt;

        public int uniquePaths(int m, int n) {
            cnt = 0;

            if (m == 1 && n == 1)
                return 1;
            m--;
            n--;
            uniquePaths(0, 1, m, n);
            uniquePaths(1, 0, m, n);
            System.out.println(cnt);
            return cnt;
        }

        public void uniquePaths(int stx, int sty, int m, int n) {
            if (m == stx && n == sty) {
                cnt++;
            }
            if (stx > m || sty > n) {
                return;
            }
            uniquePaths(stx, sty + 1, m, n);
            uniquePaths(stx + 1, sty, m, n);
        }
    }

    static class Solution_Ali2 {
        Set<String> paths;
        Map<String, List<String>> memory;

        public int uniquePaths(int m, int n) {
            paths = new LinkedHashSet<>();
            memory = new HashMap<>();

            if (m == 1 && n == 1)
                return 1;
            m--;
            n--;
            uniquePaths(0, 0, m, n, "");
            System.out.println(paths.size());
            paths.stream().forEach(System.out::println);
            return paths.size();
        }

        public void uniquePaths(int stx, int sty, int m, int n, String path) {
            if (m == stx && n == sty) {
                paths.add(path.substring(0, path.length() - 2));
                return;
            }
            if (stx > m || sty > n) {
                return;
            }

            String down = path + "Down ->";
            String right = path + "Right ->";

            uniquePaths(stx, sty + 1, m, n, right);
            uniquePaths(stx + 1, sty, m, n, down);
        }
    }
}

