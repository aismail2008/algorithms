package com.code.test.problemset.leetcode;

import java.util.List;

/**
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * <p>
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 * <p>
 * https://leetcode.com/problems/number-of-islands
 *
 *
 * Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
 *
 * Space complexity : O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N).
 */
public class Q120_NumberOfIslands {
    public static void main(String[] args) {
    }

    int numberConnectedIslands(int rows, int column, List<List<Integer>> grid) {
        if (grid == null || grid.size() == 0 || grid.get(0).size() == 0)
            return 0;

        int m = grid.size();
        int n = grid.get(0).size();

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }

    public void merge(List<List<Integer>> grid, int i, int j) {
        int m = grid.size();
        int n = grid.get(0).size();

        if (i < 0 || i >= m || j < 0 || j >= n || grid.get(i).get(j) != 1)
            return;

        grid.get(i).set(j, 2);

        merge(grid, i - 1, j);
        merge(grid, i + 1, j);
        merge(grid, i, j - 1);
        merge(grid, i, j + 1);
    }
    // METHOD SIGNATURE ENDS


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    merge(grid, i, j);
                }
            }
        }

        return count;
    }

    public void merge(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')
            return;

        grid[i][j] = '2';

        merge(grid, i - 1, j);
        merge(grid, i + 1, j);
        merge(grid, i, j - 1);
        merge(grid, i, j + 1);
    }
}
