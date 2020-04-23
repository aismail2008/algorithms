package com.code.test.problemset.CrackingCodingInterview6.ch16;

/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
 * <p>
 * Here are the rules of Tic-Tac-Toe:
 * <p>
 * Players take turns placing characters into empty squares (" ").
 * The first player A always places "X" characters, while the second player B always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never on filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.
 * <p>
 * Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".
 * <p>
 * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: "A" wins, he always plays first.
 * "X  "    "X  "    "X  "    "X  "    "X  "
 * "   " -> "   " -> " X " -> " X " -> " X "
 * "   "    "O  "    "O  "    "OO "    "OOX"
 * Example 2:
 * <p>
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: "B" wins.
 * "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * "   "    "   "    "   "    "   "    "   "    "O  "
 * Example 3:
 * <p>
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw"
 * Explanation: The game ends in a draw since there are no moves to make.
 * "XXO"
 * "OOX"
 * "XOX"
 * Example 4:
 * <p>
 * Input: moves = [[0,0],[1,1]]
 * Output: "Pending"
 * Explanation: The game has not finished yet.
 * "X  "
 * " O "
 * "   "
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= moves.length <= 9
 * moves[i].length == 2
 * 0 <= moves[i][j] <= 2
 * There are no repeated elements on moves.
 * moves follow the rules of tic tac toe.
 * <p>
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class Q4_TicTacToe {

    public static void main(String[] args) {
        //[[0,0],[2,0],[1,1],[2,1],[2,2]]
        System.out.println(new Q4_TicTacToe().tictactoe(new int[][]{{0, 0}, {1, 0}, {1, 1}, {2, 1}, {2, 2}}));
        System.out.println(new Q4_TicTacToe().tictactoe(new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}));
    }

    // A is 1
    // B is 2
    public String tictactoe(int[][] moves) {
        int[][] game = new int[3][3];

        int winner = 0;
        int cur = 1;
        for (int i = 0; i < moves.length; i++) {
            game[moves[i][0]][moves[i][1]] = cur;
            winner = checkWinner(game, moves[i][0], moves[i][1]);
            if (winner != 0) {
                break;
            }
            cur = switchPlayer(cur);
        }

        if (winner == 1)
            return "A";
        if (winner == 2)
            return "B";
        return moves.length < 9 ? "Pending" : "Draw";
    }

    private int checkWinner(int[][] game, int i, int j) {
        //check rows
        int winner = checkRow(game, i);
        if (winner != 0)
            return winner;

        //check col
        winner = checkCol(game, j);
        if (winner != 0)
            return winner;


        //check col
        for (int row = 1; row < 3; row++) {
            if (game[row][row] != game[row - 1][row - 1])
                break;
            else if (row == 2 && game[row][row] == game[row - 1][row - 1]) {
                return game[row][row];
            }
        }

        //check col
        int col = 1;
        int row = 1;
        while (col >= 0) {
            if (game[row][col] != game[row - 1][col + 1])
                return 0;
            else if (row == 2 && game[row][col] == game[row - 1][col + 1]) {
                return game[row][col];
            }
            row++;
            col--;
        }
        return 0;
    }

    private int checkCol(int[][] game, int col) {
        for (int row = 1; row < 3; row++) {
            if (game[row][col] != game[row - 1][col])
                return 0;
        }
        return game[0][col];
    }

    private int checkRow(int[][] game, int row) {
        for (int j = 1; j < 3; j++) {
            if (game[row][j] != game[row][j - 1])
                return 0;
        }
        return game[row][0];
    }

    private int switchPlayer(int current) {
        if (current == 1)
            return 2;
        else return 1;
    }
}
