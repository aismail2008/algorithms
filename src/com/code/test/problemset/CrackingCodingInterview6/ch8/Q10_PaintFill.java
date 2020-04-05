package com.code.test.problemset.CrackingCodingInterview6.ch8;

/**
 * Paint Fill:
 * Implement the "paint fill" function that one might see on many image editing programs.
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original color.
 *
 * https://leetcode.com/problems/flood-fill/submissions/
 */
public class Q10_PaintFill {

    enum Color {Black, White, Red, Yellow, Green}

    boolean PaintFill(Color[][] screen, int r, int c, Color ncolor) {
        if (screen[r][c] == ncolor) return false;
        return PaintFill(screen, r, c, screen[r][c], ncolor);
    }

    boolean PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }
        if (screen[r][c] == ocolor) {
            screen[r][c] = ncolor;
            PaintFill(screen, r - 1, c, ocolor, ncolor);
            PaintFill(screen, r + 1, c, ocolor, ncolor);
            PaintFill(screen, r, c - 1, ocolor, ncolor);
            PaintFill(screen, r, c + 1, ocolor, ncolor);
        }
        return true;
    }
}
