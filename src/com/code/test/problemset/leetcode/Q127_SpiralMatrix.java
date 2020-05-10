package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * https://leetcode.com/problems/spiral-matrix/
 */
public class Q127_SpiralMatrix {

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,    2,   3,  4,    5},
                         {6,    7,   8,  9,   10},
                         {11,  12,  13,  14,  15},
                         {16,  17,  18,  19,  20}};
        spiralCopy(input);
        input = new int[][]{{1,2,3}};
        spiralCopy(input);
        input = new int[][]{{1,2,3}};
        spiralCopy(input);
        input = new int[][]{{1}};
        spiralCopy(input);
    }
    static List<Integer> spiralCopy(int[][] inputMatrix) {
        List<Integer> output = new ArrayList<>();
        if(inputMatrix.length == 0)
            return output;

        int m = inputMatrix[0].length;
        int n = inputMatrix.length;
        int start = 0;
        int cnt = inputMatrix.length * inputMatrix[0].length;

        int i = 0;
        int j = -1;
        while (cnt > output.size()) {
            // Top row : increment J till n
            while (j + 1 < m) {  // 1 2 3 4 5
                output.add(inputMatrix[i][++j]);
            }

            //Right Column:increment i till n
            while (i + 1 < n) {
                output.add(inputMatrix[++i][j]);
            }

            // Bottom row : decrement J till start
            while (j - 1 >= start && cnt > output.size()) {
                output.add(inputMatrix[i][--j]);
            }

            // increment i till m
            while (i - 1 > start && cnt > output.size()) {
                output.add(inputMatrix[--i][j]);
            }

            start++;
            m--;
            n--;
        }

        return output;
    }
}
