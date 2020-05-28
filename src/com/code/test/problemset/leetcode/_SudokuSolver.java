package com.code.test.problemset.leetcode;

/**
 * Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 *
 * A sudoku puzzle...
 *
 *
 * ...and its solution numbers marked in red.
 *
 * Note:
 *
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 * https://leetcode.com/problems/sudoku-solver
 */
public class _SudokuSolver {
    class Optimized{
        /**
         *
         * # A helper function that returns a set of all valid
         * # candidates for a given cell in the board
         *
         * function getCandidates(board, row, col):
         *     # For some empty cell board[row][col], what possible
         *     # characters can be placed into this cell
         *     # that aren't already placed in the same row,
         *     # column, and sub-board?
         *
         *     # At the beginning, we don't have any candidates
         *     candidates = []
         *
         *     # For each character add it to the candidate list
         *     # only if there's no collision, i.e. that character
         *     # doesn't already exist in the same row, column
         *     # and sub-board. Notice the top-left corner of (row, col)'s
         *     # sub-board is (row - row%3, col - col%3).
         *     for chr from '1' to '9':
         *         collision = false;
         *         for i from 0 to 8:
         *             if (board[row][i] == chr ||
         *                 board[i][col] == chr ||
         *                 board[(row - row % 3) + floor(i / 3)][(col - col % 3) + i % 3] == chr):
         *                     collision = true
         *                     break
         *
         *         if (!collision):
         *             candidates.push(chr)
         *
         *     return candidates
         *
         * function sudokuSolve(board):
         *     # For each empty cell, consider 'newCandidates', the
         *     # set of possible candidate values that can
         *     # be placed into that cell.
         *
         *     row = -1
         *     col = -1
         *     candidates = null
         *
         *     for r from 0 to 8:
         *         for c from 0 to 8:
         *             if (board[r][c] == '.'):
         *                 newCandidates = getCandidates(board, r, c)
         *                 # Then, we want to keep the smallest
         *                 # sized 'newCandidates', plus remember the
         *                 # position where it was found
         *                 if (candidates == null OR newCandidates.size() < candidates.size()):
         *                     candidates = newCandidates
         *                     row = r
         *                     col = c
         *
         *     # If we have not found any empty cell, then
         *     # the whole board is filled already
         *     if (candidates == null):
         *         return true
         *
         *     # For each possible value that can be placed
         *     # in position (row, col), let's
         *     # place that value and then recursively query
         *     # whether the board can be solved.  If it can,
         *     # we are done.
         *     for val in candidates:
         *         board[row][col] = val
         *         if (sudokuSolve(board)):
         *             return true
         *         # The tried value val didn't work so restore
         *         # the (row, col) cell back to '.'
         *         board[row][col] = '.'
         *
         *     # Otherwise, there is no value that can be placed
         *     # into position (row, col) to make the
         *     # board solved
         *     return false
         */
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        //try 1 to 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';//recover it to be '.'
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;//check row
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;//check column
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false; //check 3*3 block
            }
        }
        return true;
    }
}
