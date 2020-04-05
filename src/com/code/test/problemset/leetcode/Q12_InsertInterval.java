package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem:
 * Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * https://leetcode.com/problems/insert-interval/
 */
public class Q12_InsertInterval {

    public static void main(String[] args) {

        insertIntervals(new int[][]{{3, 5}, {12, 15}}, new int[]{6, 6});
        insertIntervals(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        insertIntervals(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 9});
    }

    public static int[][] insertIntervals(int[][] a, int[] newInter) {
        if (a == null || a.length == 0)
            return new int[][]{newInter};

        if (newInter[1] < a[0][0]) {
            int[][] sol = new int[a.length + 1][];
            sol[0] = newInter;
            System.arraycopy(a, 0, sol, 1, a.length);
            return sol;
        } else if (newInter[0] > a[a.length - 1][1]) {
            int[][] sol = new int[a.length + 1][];
            System.arraycopy(a, 0, sol, 0, a.length);
            sol[sol.length - 1] = newInter;
            return sol;
        }

        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        int start = newInter[0];
        int end = newInter[1];

        List<int[]> sol = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int cStart = a[i][0];
            int cEnd = a[i][1];
            //If Intersection
            if ((end >= cStart && end <= cEnd) ||
                    (start >= cStart && start <= cEnd) ||
                    (cStart >= start && cStart <= end)) {
                start = Math.min(start, a[i][0]);
                end = Math.max(end, a[i][1]);

                while (++i < a.length) {
                    if (a[i][0] <= end) { //new include old
                        end = Math.max(end, a[i][1]);
                    } else {
                        break;
                    }
                }
                sol.add(new int[]{start, end});

                return copyRest(a, sol, i);
            } else {
                sol.add(new int[]{a[i][0], a[i][1]});
                if (end < sol.get(sol.size() - 1)[0]) {
                    sol.add(sol.size() - 1, new int[]{start, end});

                    return copyRest(a, sol, i + 1);
                }
            }
        }

        int[][] solArr =  copyRest(a, sol, a.length);
        return solArr;
    }

    public static int[][] copyRest(int[][] ar, List sol, int i) {
        while (i < ar.length) {
            sol.add(new int[]{ar[i][0], ar[i][1]});
            i++;
        }
        int[][] solArr = new int[sol.size()][];
        return (int[][]) sol.toArray(solArr);
    }
}
