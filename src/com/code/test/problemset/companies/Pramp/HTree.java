package com.code.test.problemset.companies.Pramp;

import java.awt.*;
import java.util.LinkedList;

/**
 * H-Tree Construction
 * An H-tree is a geometric shape that consists of a repeating pattern resembles the letter “H”.
 * <p>
 * It can be constructed by starting with a line segment of arbitrary length, drawing two segments of the same length at right angles to the first through its endpoints, and continuing in the same vein, reducing (dividing) the length of the line segments drawn at each stage by √2.
 * <p>
 * Here are some examples of H-trees at different levels of depth:
 * <p>
 * altdepth = 1
 * <p>
 * altdepth = 2
 * <p>
 * altdepth = 3
 * <p>
 * Write a function drawHTree that constructs an H-tree, given its center (x and y coordinates), a starting length, and depth. Assume that the starting line is parallel to the X-axis.
 * <p>
 * Use the function drawLine provided to implement your algorithm. In a production code, a drawLine function would render a real line between two points. However, this is not a real production environment, so to make things easier, implement drawLine such that it simply prints its arguments (the print format is left to your discretion).
 * <p>
 * Analyze the time and space complexity of your algorithm. In your analysis, assume that drawLine's time and space complexities are constant, i.e. O(1).
 * <p>
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] double x
 * <p>
 * [input] double y
 * <p>
 * [input] double length
 * <p>
 * [input] double depth
 * <p>
 * 0 ≤ depth ≤ 10
 *
 *
 * // Time and Space : O(4^D)
 */
public class HTree {
    static class SolutionAli {
        static public void main(String args[]) {
            System.out.println("Practice makes Perfect!");
        }

        public static void drawHTree(int x, int y, double len, int depth) {
            double divid = Math.sqrt(2);

            java.util.Queue<Point> qu = new LinkedList<>();
            qu.offer(new Point(x, y));

            while (qu.isEmpty() && depth > 0) {
                int size = qu.size();
                while (size > 0) {
                    Point p = qu.poll();

                    drawHTree(p.x, p.y, len);

                    qu.offer(new Point((int) (x + len / 2), (int) (y + len / 2)));
                    qu.offer(new Point((int) (x + len / 2), (int) (y - len / 2)));
                    qu.offer(new Point((int) (x + len / 2), (int) (y + len / 2)));
                    qu.offer(new Point((int) (x - len / 2), (int) (y - len / 2)));
                    size--;
                }
                // qu will have 4 elements
                depth--; // depth = 2
                len = len / divid;
            }
        }

        public static void drawHTree(int x, int y, double len) {
            drawLine((int) (x - len / 2), y, Direction.RIGHT, len);
            drawLine((int) (x - len / 2), (int) (y + len / 2), Direction.DOWN, len);
            drawLine((int) (x + len / 2), (int) (y + len / 2), Direction.DOWN, len);
        }

        static enum Direction {
            DOWN, RIGHT
        }


        static public void drawLine(int x, int y, Direction dir, double len) {
//            if (dir == DOWN) {
//                for (int i = x; i < len; i++) {
//                    board.get(i).set(0) = '|' + " ";
//                }
//            } else if (dir == RIGHT) {
//                for (int i = y; i < len; i++) {
//                    board.get(x).set(i) = '--';
//                }
//            }
        }
    }

    static class Recursive{
        // plot an H, centered on (x, y) of the given side length
        public static void drawH(double x, double y, double size) {

            // compute the coordinates of the 4 tips of the H
            double x0 = x - size/2;
            double x1 = x + size/2;
            double y0 = y - size/2;
            double y1 = y + size/2;

            // draw the 3 line segments of the H
//            StdDraw.line(x0, y0, x0, y1);    // left  vertical segment of the H
//            StdDraw.line(x1, y0, x1, y1);    // right vertical segment of the H
//            StdDraw.line(x0,  y, x1,  y);    // connect the two vertical segments of the H
        }

        // plot an order n H-tree, centered on (x, y) of the given side length
        public static void draw(int n, double x, double y, double size) {
            if (n == 0) return;
            drawH(x, y, size);

            // compute x- and y-coordinates of the 4 half-size H-trees
            double x0 = x - size/2;
            double x1 = x + size/2;
            double y0 = y - size/2;
            double y1 = y + size/2;

            // recursively draw 4 half-size H-trees of order n-1
            draw(n-1, x0, y0, size/2);    // lower left  H-tree
            draw(n-1, x0, y1, size/2);    // upper left  H-tree
            draw(n-1, x1, y0, size/2);    // lower right H-tree
            draw(n-1, x1, y1, size/2);    // upper right H-tree
        }

        // reads an integer command-line argument n and plots an order n H-tree
        public static void main(String[] args) {
            int n = Integer.parseInt(args[0]);

            double x = 0.5, y = 0.5;   // center of H-tree
            double size = 0.5;         // side length of H-tree
            draw(n, x, y, size);
        }


    }
}