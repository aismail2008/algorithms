package com.code.test.problemset.leetcode;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * https://leetcode.com/problems/merge-intervals/
 */
public class Q11_MergeIntervals {

    public static void main(String[] args) {

        mergeIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}, {20, 25}});
        mergeIntervals(new int[][]{{1, 4}, {4, 5}});
    }

    public static int[][] mergeIntervals(int[][] a) {
        if (a == null || a.length == 0)
            return a;

        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        List<int[]> sol = new ArrayList<>();
        int start = a[0][0];
        int end = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] <= end) {
                end = Math.max(end, a[i][1]);
            } else {
                sol.add(new int[]{start, end});
                start = a[i][0];
                end = a[i][1];
            }
        }

        if (sol.size() == 0 || start > sol.get(sol.size() - 1)[1]) {
            sol.add(new int[]{start, end});
        }

        int[][] solArr = new int[sol.size()][];
        solArr = sol.toArray(solArr);

        return solArr;
    }
}
