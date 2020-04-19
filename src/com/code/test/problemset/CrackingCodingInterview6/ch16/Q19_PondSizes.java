package com.code.test.problemset.CrackingCodingInterview6.ch16;

import java.util.ArrayList;

/**
 * Pond Sizes:
 * You have an integer matrix representing a plot of land, where the value at that location
 * represents the height above sea level. A value of zero indicates water. A pond is a region of water
 * connected vertically, horizontally, or diagonally. The size of the pond is the total number of
 * connected water cells. Write a method to compute the sizes of all ponds in the matrix.
 * EXAMPLE
 * Input:
 * 0 2 1 0
 * 0 1 0 1
 * 1 1 0 1
 * 0 1 0 1
 * Output: 2, 4, 1 (in any order)
 */
public class Q19_PondSizes {

    public static ArrayList<Integer> computePondSizes(int[][] land) {
        ArrayList<Integer> pondSizes = new ArrayList<>();
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[r].length; c++) {
                int size = computeSize(land, r, c);
                if (size > 0) {
                    pondSizes.add(size);
                }
            }
        }
        return pondSizes;
    }

    public static int computeSize(int[][] land, int row, int col) {
        /* If out of bounds or already visited. */
        if (row < 0 || col < 0 || row >= land.length || col >= land[row].length || land[row][col] != 0) {
            return 0;
        }
        int size = 1;
        land[row][col] = -1;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += computeSize(land, row + dr, col + dc);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        ArrayList<Integer> sizes = computePondSizes(land);
        for (int sz : sizes) {
            System.out.println(sz);
        }
    }
}
