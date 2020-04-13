package com.code.test.problemset.CrackingCodingInterview6.ch8;

import java.awt.*;
import java.util.*;

/**
 * Robot in a Grid:
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such
 * that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class Q2_RobotInGrid {

    public static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, Set<Point> failedPoints) {
        /* If out of bounds or not available, return.*/
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);

        /* If we've already visited this cell, return. */
        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        /* If there's a path from the start to my current location, add my location.*/
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }

        failedPoints.add(p); // Cache result
        return false;
    }

    public static void main(String[] args) {
    }

    static class solutionA {
        public static ArrayList<Point> getPath(boolean[][] maze) {
            Point start = new Point(0, 0);
            ArrayList<Point> path = new ArrayList<>();
            Set<Point> failedPaths = new HashSet<>();

            if (getPath(maze, start.x, start.y, path, failedPaths))
                return path;

            return null;
        }

        public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, Set<Point> failedPaths) {
            if (row == maze.length - 1 && col == maze.length - 1) {
                path.add(new Point(row, col));
                return true;
            }

            if (row >= maze.length || col >= maze.length || failedPaths.contains(new Point(row, col))) {
                return false;
            }

            if (getPath(maze, row, col + 1, path, failedPaths)) {
                path.add(new Point(row, col));
                return true;
            } else if (getPath(maze, row + 1, col, path, failedPaths)) {
                path.add(new Point(row, col));
                return true;
            }

            failedPaths.add(new Point(row, col));
            return false;
        }
    }
}
