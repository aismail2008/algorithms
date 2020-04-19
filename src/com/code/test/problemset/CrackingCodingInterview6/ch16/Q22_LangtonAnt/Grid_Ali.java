package com.code.test.problemset.CrackingCodingInterview6.ch16.Q22_LangtonAnt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Grid_Ali {

    private List<List<Boolean>> grid; // false is white, true is black
    private Ant ant = new Ant();

    public Grid_Ali() {
        grid = new ArrayList<>();
        grid.add(new ArrayList<>());
        grid.get(0).add(false);
    }

    /* Flip color of cells. */
    private void flip(Position position) {
		/* Ensure that the given position will fit on the array. If
		 * necessary, double the size of the matrix, copy the old values
		 * over, and adjust the ant's position so that it's in a positive
		 * ranges.
		 */
		if(position.row == -1){
			grid.add(new ArrayList<>(position.column+1));
			position.row = 0;

			//TODO adjust all after rows x
		}else if(position.row > grid.size()){
			grid.add(new ArrayList<>(position.column+1));
		}

        grid.get(position.row).set(position.column, !grid.get(position.row).get(position.column));
    }

    /* Move ant. */
    public void move() {
        ant.turn(!grid.get(ant.position.row).get(ant.position.column)); // Turn clockwise on white, counterclockwise on black
        flip(ant.position); // flip
        ant.move(); // move
    }

    /* Print board. The first loop of this is a "compression" which only prints the active parts of the board. The active
     * board is the smallest rectangle that contains all the black cells and the ant. This is fairly optional. Nice to do
     * but also not essential.
     * FULL BOARD:    ACTIVE BOARD:
     *  _____          _X
     *  ___X_          XX
     *  __XX_           X
     *  ___X_
     *  _____
     *  _____*/
    public String toString() {
        int firstActiveRow = grid.size();
        int firstActiveColumn = grid.get(0).size();
        int lastActiveRow = 0;
        int lastActiveColumn = 0;
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.get(r).size(); c++) {
                if (grid.get(r).get(c) ||
						(ant.position.row == r && ant.position.column == c)) { // If there's something there
                    firstActiveRow = Math.min(firstActiveRow, r);
                    firstActiveColumn = Math.min(firstActiveColumn, c);
                    lastActiveRow = Math.max(lastActiveRow, r);
                    lastActiveColumn = Math.max(lastActiveColumn, c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = firstActiveRow; r <= lastActiveRow; r++) {
            for (int c = firstActiveColumn; c <= lastActiveColumn; c++) {
                if (r == ant.position.row && c == ant.position.column) {
                    sb.append(ant.orientation);
                } else if (grid.get(r).get(c)) {
                    sb.append("X");
                } else {
                    sb.append("_");
                }
            }
            sb.append("\n");
        }
        sb.append("Ant: " + ant.orientation + ". \n");
        return sb.toString();
    }
}
