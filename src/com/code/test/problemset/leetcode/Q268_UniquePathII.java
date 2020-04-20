package com.code.test.problemset.leetcode;

/**
 * Unique Paths II:
 * Follow up for "Unique Paths": {@link com.code.test.problemset.leetcode.Q267_UniquePath}
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid. For example, there is one obstacle in the middle of a 3x3 grid as illustrated below,
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * the total number of unique paths is 2.
 * <p>
 * https://leetcode.com/problems/unique-paths/
 */
public class Q268_UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        //left column
        boolean zeros = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
               zeros = true;
            }

            if (zeros) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }

        //top row
        zeros = false;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                zeros = true;
            }

            if (zeros) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }

        //fill up cells inside
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }

            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}

