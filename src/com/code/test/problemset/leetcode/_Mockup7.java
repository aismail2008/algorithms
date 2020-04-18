package com.code.test.problemset.leetcode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class _Mockup7 {


    /**
     * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
     * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
     * <p>
     * Words in the list of banned words are given in lowercase, and free of punctuation.
     * Words in the paragraph are not case sensitive.  The answer is in lowercase.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Input:
     * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
     * banned = ["hit"]
     * Output: "ball"
     * Explanation:
     * "hit" occurs 3 times, but it is a banned word.
     * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
     * Note that words in the paragraph are not case sensitive,
     * that punctuation is ignored (even if adjacent to words, such as "ball,"),
     * and that "hit" isn't the answer even though it occurs more because it is banned.
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= paragraph.length <= 1000.
     * 0 <= banned.length <= 100.
     * 1 <= banned[i].length <= 10.
     * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
     * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
     * There are no hyphens or hyphenated words.
     * Words only consist of letters, never apostrophes or other punctuation symbols.
     * <p>
     * <p>
     * []
     * ["bob", "hit"]
     * <p>
     * https://leetcode.com/problems/most-common-word/
     */
    static class Solution {
        public static void main(String[] args) {
            new Solution().mostCommonWord(new String("L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' y! Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'"),
                    new String[]{"m", "i", "s", "w", "y", "d", "q", "l", "a", "p", "n", "t", "u", "b", "o", "e", "f", "g", "c", "x"});
        }

        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> freq = new HashMap<>();

            Arrays.sort(banned);
            String[] input = paragraph.replace("!", " ").
                    replace("?", " ").
                    replace("'", " ").
                    replace(",", " ").
                    replace(";", " ").
                    replace(".", " ").split(" ");

            for (String s : input) {
                s = s.replace(" ", "").toLowerCase();
                if (s.length() > 0 && Arrays.binarySearch(banned, s) < 0) {
                    if (!freq.containsKey(s)) {
                        freq.putIfAbsent(s, 0);
                    }
                    freq.put(s, freq.get(s) + 1);
                }
            }

            String mostFreq = "";
            int cnt = 0;
            for (Map.Entry<String, Integer> entry : freq.entrySet()) {
                if (entry.getValue() > cnt) {
                    mostFreq = entry.getKey();
                    cnt = entry.getValue();
                }

            }
            return mostFreq;
        }

    }


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
     */
    @Hard
    static class SolutionB_Ali {

        public static void main(String[] args) {
            List<List<Integer>> forest = new ArrayList<>();
            forest.add(Arrays.asList(new Integer[]{1, 2, 3}));
            forest.add(Arrays.asList(new Integer[]{0, 0, 4}));
            forest.add(Arrays.asList(new Integer[]{7, 6, 5}));
            System.out.println(new SolutionB_Ali().cutOffTree(forest));

            forest = new ArrayList<>();
            forest.add(Arrays.asList(new Integer[]{1, 2, 3}));
            forest.add(Arrays.asList(new Integer[]{0, 0, 0}));
            forest.add(Arrays.asList(new Integer[]{7, 6, 5}));
            System.out.println(new SolutionB_Ali().cutOffTree(forest));
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
