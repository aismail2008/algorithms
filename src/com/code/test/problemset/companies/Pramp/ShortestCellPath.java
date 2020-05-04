package com.code.test.problemset.companies.Pramp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Shortest Cell Path
 * In a given grid of 0s and 1s, we have some starting row and column sr, sc and a target row and column tr, tc. Return the length of the shortest path from sr, sc to tr, tc that walks along 1 values only.
 *
 * Each location in the path, including the start and the end, must be a 1. Each subsequent location in the path must be 4-directionally adjacent to the previous location.
 *
 * It is guaranteed that grid[sr][sc] = grid[tr][tc] = 1, and the starting and target positions are different.
 *
 * If the task is impossible, return -1.
 *
 * Examples:
 *
 * input:
 * grid = [[1, 1, 1, 1], [0, 0, 0, 1], [1, 1, 1, 1]]
 * sr = 0, sc = 0, tr = 2, tc = 0
 * output: 8
 * (The lines below represent this grid:)
 * 1111
 * 0001
 * 1111
 *
 * grid = [[1, 1, 1, 1], [0, 0, 0, 1], [1, 0, 1, 1]]
 * sr = 0, sc = 0, tr = 2, tc = 0
 * output: -1
 * (The lines below represent this grid:)
 * 1111
 * 0001
 * 1011
 */
class ShortestCellPath {
    static class Point{
        int x;
        int y;
        int steps;

        public Point(int x, int y, int steps){
            this.x = x;
            this.y = y;
            steps = steps;
        }
    }


    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here
        int minSteps = -1;

        Point start = new Point(sr, sc, 0);
        Queue<Point> qu = new LinkedList<>();
        qu.add(start);

        while(!qu.isEmpty()){

            Point current = qu.poll();

            if(current.x == tr && current.y == tc){
                System.out.println(current.x + " " + current.y + " " + current.steps);
                return current.steps;
            }

            if(current.x + 1 < grid.length && grid[current.x+1][current.y] == 1){
                System.out.println(current.x + " " + current.y);
                qu.add(new Point(current.x+1, current.y, current.steps + 1));
            }
            if(current.y + 1 < grid[0].length && grid[current.x][current.y+1] == 1){
                System.out.println(current.x + " " + current.y);
                qu.add(new Point(current.x, current.y+1, current.steps + 1));
            }
            if(current.x - 1 >= 0 && grid[current.x-1][current.y] == 1){
                System.out.println(current.x + " " + current.y);
                qu.add(new Point(current.x-1, current.y, current.steps + 1));
            }
            if(current.y - 1 >= 0 && grid[current.x][current.y-1] == 1){
                System.out.println(current.x + " " + current.y);
                qu.add(new Point(current.x, current.y-1, current.steps + 1));
            }

            grid[current.x][current.y] = 0;

        }

        return minSteps;
    }

    public static void main(String[] args) {
        shortestCellPath(new int[][]{{1,1,1,1},{0,0,0,1},{1,1,1,1}}, 0, 0, 2, 0);
    }

}