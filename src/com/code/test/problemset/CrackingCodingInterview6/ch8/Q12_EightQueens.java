package com.code.test.problemset.CrackingCodingInterview6.ch8;

import java.util.ArrayList;
import java.util.List;

/**
 * Eight Queens:Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of
 * them share the same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two
 * that bisect the board.
 * <p>
 * <p>
 * https://leetcode.com/problems/n-queens/
 */
public class Q12_EightQueens {
        public static int GRID_SIZE = 4;

        /* Check if (row1, column1) is a valid spot for a queen by checking if there
         * is a queen in the same column or diagonal. We don't need to check it for queens
         * in the same row because the calling placeQueen only attempts to place one queen at
         * a time. We know this row is empty.
         */
        public static boolean checkValid(Integer[] columns, int row1, int column1) {
            for (int row2 = 0; row2 < row1; row2++) {
                int column2 = columns[row2];
                /* Check if (row2, column2) invalidates (row1, column1) as a queen spot. */

                /* Check if rows have a queen in the same column */
                if (column1 == column2) {
                    return false;
                }

                /* Check diagonals: if the distance between the columns equals the distance
                 * between the rows, then they’re in the same diagonal. */
                int columnDistance = Math.abs(column2 - column1);
                int rowDistance = row1 - row2; // row1 > row2, so no need to use absolute value
                if (columnDistance == rowDistance) {
                    return false;
                }
            }
            return true;
        }

        public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
            if (row == GRID_SIZE) { // Found valid placement
                results.add(columns.clone());
            } else {
                for (int col = 0; col < GRID_SIZE; col++) {
                    if (checkValid(columns, row, col)) {
                        columns[row] = col;    // Place queen
                        placeQueens(row + 1, columns, results);
                    }
                }
            }
        }

        public static void clear(Integer[] columns) {
            for (int i = 0; i < GRID_SIZE; i++) {
                columns[i] = -1;
            }
        }

        public static void printBoard(Integer[] columns) {
            drawLine();
            for (int i = 0; i < GRID_SIZE; i++) {
                System.out.print("|");
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (columns[i] == j) {
                        System.out.print("Q|");
                    } else {
                        System.out.print(" |");
                    }
                }
                System.out.print("\n");
                drawLine();
            }
            System.out.println("");
        }

        private static void drawLine() {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < GRID_SIZE * 2 + 1; i++)
                line.append('-');
            System.out.println(line.toString());
        }


        public static void printBoards(ArrayList<Integer[]> boards) {
            for (int i = 0; i < boards.size(); i++) {
                Integer[] board = boards.get(i);
                printBoard(board);
            }
        }

        public static void main(String[] args) {
            ArrayList<Integer[]> results = new ArrayList<Integer[]>();
            Integer[] columns = new Integer[GRID_SIZE];
            clear(columns);
            placeQueens(0, columns, results);
            printBoards(results);
            System.out.println(results.size());
        }

    static class Ali_NotWorking {
        static List<List<String>> xx = new ArrayList<>();

        static public List<String> solveNQueens(List<String> cur, int n) {

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (canPutQueens(cur, row, col, n)) {
                        List<String> solution = solveNQueens(cur, n - 1);
                        if (isValid(solution, n)) {
                            xx.add(solution);
                        }
                    }
                }
            }
            return cur;
        }

        private static boolean isValid(List<String> solution, int n) {
            if (solution.size() == n) {
                return solution.stream().allMatch(s -> s.contains("Q"));
            }
            return false;
        }

        private static boolean canPutQueens(List<String> matrix, int row, int col, int n) {
            row += matrix.size();
            n = n + matrix.size();
            // not in same column
            for (String s : matrix) {
                if (s.indexOf("Q") == col)
                    return false;
            }

            // not in diagonal
            int r = row - 1;
            int j = col - 1;
            while (r >= 0 && j >= 0) {
                if (matrix.get(r).indexOf("Q") == j)
                    return false;
                r--;
                j--;
            }

            r = row - 1;
            j = col + 1;
            while (r >= 0 && j < n) {
                if (matrix.get(r).indexOf("Q") == j)
                    return false;
                r--;
                j++;
            }


            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append(i == col ? "Q" : ".");
            }

            matrix.add(s.toString());
            return true;
        }

    }
}
