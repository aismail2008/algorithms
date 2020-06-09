package com.code.test.problemset.companies.Pramp;

import com.code.test.problemset.leetcode._SudokuSolver;

import java.util.*;

/**
 * Sudoku Solver
 * Write the function sudokuSolve that checks whether a given sudoku board (i.e. sudoku puzzle) is solvable. If so, the function will returns true. Otherwise (i.e. there is no valid solution to the given sudoku board), returns false.
 * <p>
 * In sudoku, the objective is to fill a 9x9 board with digits so that each column, each row, and each of the nine 3x3 sub-boards that compose the board contains all of the digits from 1 to 9. The board setter provides a partially completed board, which for a well-posed board has a unique solution. As explained above, for this problem, it suffices to calculate whether a given sudoku board has a solution. No need to return the actual numbers that make up a solution.
 * <p>
 * A sudoku board is represented as a two-dimensional 9x9 array of the characters ‘1’,‘2’,…,‘9’ and the '.' character, which represents a blank space. The function should fill the blank spaces with characters such that the following rules apply:
 * <p>
 * In every row of the array, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
 * In every column of the array, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
 * In every 3x3 sub-board that is illustrated below, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
 * A solved sudoku is a board with no blank spaces, i.e. all blank spaces are filled with characters that abide to the constraints above. If the function succeeds in solving the sudoku board, it’ll return true (false, otherwise).
 * <p>
 * Example (more examples can be found here):
 * <p>
 * altA typical Sudoku board setter
 * <p>
 * altThe same board with solution numbers marked in red
 * <p>
 * Write a readable an efficient code, explain how it is built and why you chose to build it that way.
 */
public class SudokuSolver {
    public static void main(String[] args) {
        new _SudokuSolver();
    }

    static class CellValue implements Comparator<CellValue> {
        List<Character> options;
        int i;
        int j;

        public CellValue(int i, int j, List<Character> options) {
            this.i = i;
            this.j = j;
            this.options = options;
        }

        @Override
        public int compare(CellValue o1, CellValue o2) {
            return o1.options.size() - o2.options.size();
        }
    }

    static boolean sudokuSolve(char[][] board) {
        Queue<CellValue> prQ = new PriorityQueue<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                List<Character> avl = getAvailableNumber(i, j);
                prQ.offer(new CellValue(i, j, avl));
            }
        }

        sudokuSolve(board, prQ);
        return true;
    }

    private static List<Character> getAvailableNumber(int i, int j) {
        // return list of all options for this cell
        return null;
    }

    static boolean sudokuSolve(char[][] board, Queue<CellValue> prQ) {
        while (!prQ.isEmpty()) {
            CellValue c = prQ.remove();
            for (Character num : c.options) {
                board[c.i][c.j] = num;

                Iterator<CellValue> it = prQ.iterator();
                while (it.hasNext()) {
                    CellValue itcell = it.next();
                    if (itcell.i == c.i || itcell.j == c.j)
                        itcell.options.remove(num);
                    if (c.i % 3 == itcell.i % 3 && c.j % 3 == itcell.j % 3) {
                        itcell.options.remove(num);
                    }
                }


                if (sudokuSolve(board, prQ))
                    return true;

                Iterator<CellValue> iterator = prQ.iterator();
                while (iterator.hasNext()) {
                    CellValue itcell = it.next();
                    if (itcell.i == c.i || itcell.j == c.j)
                        itcell.options.add(num);
                    if (c.i % 3 == itcell.i % 3 && c.j % 3 == itcell.j % 3) {
                        itcell.options.add(num);
                    }
                }

            }
        }
        return false;
    }

    List<Character> getAvailableNumber(char[] board, int row, int col) {
        return new ArrayList<>();
    }
}
