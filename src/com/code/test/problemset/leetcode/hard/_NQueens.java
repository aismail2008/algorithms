package com.code.test.problemset.leetcode.hard;

import com.code.test.problemset.leetcode.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Eight Queens:
 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of
 * them share the same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two
 * that bisect the board.
 * <p>
 * <p>
 * https://leetcode.com/problems/n-queens/
 */
@Hard
public class _NQueens {

    public static void main(String[] args) {
        List s = new _NQueens().solveNQueens(4);
        s.forEach(System.out::println);
    }

    List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = -1;
        }
        placeQueen(column, 0);
        return solutions;
    }

    void placeQueen(int[] column, int row) {
        if (row >= column.length) {
            printBoard(column);
            return;
        }

        for (int i = 0; i < column.length; i++) {
            column[row] = i;
            if (isValid(column, row)) {
                placeQueen(column, row + 1);
            }
        }
    }

    /* Check if (row1, column1) is a valid spot for a queen by checking if there
     * is a queen in the same column or diagonal. We don't need to check it for queens
     * in the same row because the calling placeQueen only attempts to place one queen at
     * a time. We know this row is empty.
     */
    private boolean isValid(int[] column, int row) {
        for (int i = row - 1; i >= 0; i--) {
            /* Check if rows have a queen in the same column */
            if (column[i] == column[row])
                return false;

            /* Check diagonals: if the distance between the columns equals the distance
             * between the rows, then they’re in the same diagonal. */
            int xDis = Math.abs(column[i] - column[row]);
            int yDis = Math.abs(i - row);
            if (yDis == xDis)
                return false;
        }
        return true;
    }

    private void printBoard(int[] columns) {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < columns.length; r++) {
            int queenColumn = columns[r];
            StringBuilder row = new StringBuilder();
            for (int col = 0; col < columns.length; col++) {
                if (col == queenColumn) {
                    row.append("Q");
                } else
                    row.append(".");
            }
            board.add(row.toString());
        }
        solutions.add(board);
    }
}
