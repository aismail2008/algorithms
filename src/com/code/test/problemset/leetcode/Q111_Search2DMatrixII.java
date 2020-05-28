package com.code.test.problemset.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example, consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Q111_Search2DMatrixII {

    // O(m + n)
    public static boolean findElement(int[][] matrix, int elem) {
        if(matrix.length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    static class SolutionA {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix.length == 0)
                return false;

            int i1 = 0;
            int i2 = matrix.length - 1;
            int j1 = 0;
            int j2 = matrix[0].length - 1;

            return helper(matrix, i1, i2, j1, j2, target);
        }

        public boolean helper(int[][] matrix, int i0, int in, int j0, int jn, int target) {

            if (i0 > in || j0 > jn)
                return false;

            for (int j = j0; j <= jn; j++) {
                if (target < matrix[i0][j]) {
                    return helper(matrix, i0, in, j0, j - 1, target);
                } else if (target == matrix[i0][j]) {
                    return true;
                }
            }

            for (int i = i0; i <= in; i++) {
                if (target < matrix[i][j0]) {
                    return helper(matrix, i0, i - 1, j0, jn, target);
                } else if (target == matrix[i][j0]) {
                    return true;
                }
            }

            for (int j = j0; j <= jn; j++) {
                if (target > matrix[in][j]) {
                    return helper(matrix, i0, in, j + 1, jn, target);
                } else if (target == matrix[in][j]) {
                    return true;
                }
            }

            for (int i = i0; i <= in; i++) {
                if (target > matrix[i][jn]) {
                    return helper(matrix, i0, i + 1, j0, jn, target);
                } else if (target == matrix[i][jn]) {
                    return true;
                }
            }

            return false;
        }
    }
}
