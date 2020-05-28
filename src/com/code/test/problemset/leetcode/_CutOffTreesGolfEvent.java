package com.code.test.problemset.leetcode;

import java.awt.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

/**
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
 * <p>
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 * In one step you can walk in any of the four directions top, bottom, left and right also when standing in a point which is a tree you can decide whether or not to cut off the tree.
 * <p>
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
 * <p>
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
 * <p>
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * [
 * [9,3,4],
 * [0,0,5],
 * [8,2,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= forest.length <= 50
 * 1 <= forest[i].length <= 50
 * 0 <= forest[i][j] <= 10^9
 * 1000_000_000
 * <p>
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 *
 * Time Complexity: O((RC)^2)O((RC)
 * 2
 *  ) where there are RR rows and CC columns in the given forest. We walk to R*CR∗C trees, and each walk could spend O(R*C)O(R∗C) time searching for the tree.
 *
 * Space Complexity: O(R*C)O(R∗C), the maximum size of the data structures used.
 */
@Hard
public class _CutOffTreesGolfEvent {

    static class SolutionA {
        public static void main(String[] args) {
            List<List<Integer>> forest = new ArrayList<>();
            forest.add(Arrays.asList(new Integer[]{1, 2, 3}));
            forest.add(Arrays.asList(new Integer[]{0, 0, 4}));
            forest.add(Arrays.asList(new Integer[]{7, 6, 5}));
            System.out.println(new SolutionA().cutOffTree(forest));

            forest = new ArrayList<>();
            forest.add(Arrays.asList(new Integer[]{1, 2, 3}));
            forest.add(Arrays.asList(new Integer[]{0, 0, 0}));
            forest.add(Arrays.asList(new Integer[]{7, 6, 5}));
            System.out.println(new SolutionA().cutOffTree(forest));
        }

        public int cutOffTree(List<List<Integer>> forest) {
            if (forest.get(0).get(0) == 0)
                return -1;

            int steps = 0;

            int n = forest.size();
            int m = forest.get(0).size();
            Queue<Point> queue = new PriorityQueue<>(Comparator.comparing(o -> forest.get(o.x).get(o.y)));

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (forest.get(i).get(j) > 1) {
                        queue.offer(new Point(i, j));
                    }
                }
            }

            Point start = new Point(0, 0);
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int currSteps = visitBfsPointToPoint(forest, start, p);
                if (currSteps == -1)
                    return -1;

                forest.get(p.x).set(p.y, 1);
                steps += currSteps;
                start = p;
            }
            return steps;
        }

        private int visitBfsPointToPoint(List<List<Integer>> forest, Point start, Point end) {
            if (start == end)
                return 0;

            boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
            int n = forest.size();
            int m = forest.get(0).size();

            Queue<Point> queue = new LinkedList<>();
            HashMap<Point, Integer> pointSteps = new HashMap<>();
            pointSteps.put(start, 0);
            queue.offer(start);
            Point current;
            while (!queue.isEmpty()) {
                current = queue.poll();
                visited[current.x][current.y] = true;
                if (current.equals(end)) {
                    break;
                }

                if ((current.y + 1) < m && forest.get(current.x).get(current.y + 1) != 0 && !visited[current.x][current.y + 1]) {
                    queue.add(new Point(current.x, current.y + 1));
                    pointSteps.put(new Point(current.x, current.y + 1), pointSteps.get(current) + 1);
                }
                if ((current.x + 1) < n && forest.get(current.x + 1).get(current.y) != 0 && !visited[current.x + 1][current.y]) {
                    queue.add(new Point(current.x + 1, current.y));
                    pointSteps.put(new Point(current.x + 1, current.y), pointSteps.get(current) + 1);
                }
                if ((current.x - 1) >= 0 && forest.get(current.x - 1).get(current.y) != 0 && !visited[current.x - 1][current.y]) {
                    queue.add(new Point(current.x - 1, current.y));
                    pointSteps.put(new Point(current.x - 1, current.y), pointSteps.get(current) + 1);
                }
                if ((current.y - 1) >= 0 && forest.get(current.x).get(current.y - 1) != 0 && !visited[current.x][current.y - 1]) {
                    queue.add(new Point(current.x, current.y - 1));
                    pointSteps.put(new Point(current.x, current.y - 1), pointSteps.get(current) + 1);
                }
            }

            return pointSteps.getOrDefault(end, -1);
        }
    }

    class SolutionB {
        public int cutOffTree(List<List<Integer>> forest) {
            if (forest == null || forest.isEmpty() || forest.size() == 0 || forest.get(0).get(0) == 0) {
                return -1;
            }
            int m = forest.size();
            int n = forest.get(0).size();
            /**cut trees in ascending order*/
            PriorityQueue<Tree> heap = new PriorityQueue<>((a, b) -> a.height - b.height);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (forest.get(i).get(j) > 1) {
                        /**This is important: we'll add trees that are only taller than 1!!!*/
                        heap.offer(new Tree(i, j, forest.get(i).get(j)));
                    }
                }
            }

            int sum = 0;
            Tree start = new Tree();
            while (!heap.isEmpty()) {
                Tree curr = heap.poll();
                int step = bfs(forest, curr, start, m, n);
                if (step == -1) {
                    return -1;
                }
                sum += step;
                start = curr;
            }
            return sum;
        }

        private int bfs(List<List<Integer>> forest, Tree target, Tree start, int m, int n) {
            int[] dirs = new int[]{0, 1, 0, -1, 0};
            boolean[][] visited = new boolean[m][n];
            Queue<Tree> queue = new LinkedList<>();
            queue.offer(start);
            visited[start.x][start.y] = true;
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    Tree tree = queue.poll();
                    if (tree.x == target.x && tree.y == target.y) {
                        return step;
                    }

                    for (int i = 0; i < 4; i++) {
                        int nextX = tree.x + dirs[i];
                        int nextY = tree.y + dirs[i + 1];
                        if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || visited[nextX][nextY] || forest.get(nextX).get(nextY) == 0) {
                            continue;
                        }
                        queue.offer(new Tree(nextX, nextY, forest.get(nextX).get(nextY)));
                        visited[nextX][nextY] = true;
                    }
                }
                step++;
            }
            return -1;
        }

        class Tree {
            int x;
            int y;
            int height;

            public Tree(int x, int y, int height) {
                this.x = x;
                this.y = y;
                this.height = height;
            }

            public Tree() {
                this.x = 0;
                this.y = 0;
                this.height = 0;
            }
        }
    }

}