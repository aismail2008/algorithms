package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given a set of non-overlapping & sorted intervals,
 * insert a new interval into the intervals (merge if necessary).
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * https://leetcode.com/problems/insert-interval/
 */
@Medium
public class Q12_InsertInterval {

    public static void main(String[] args) {

        insertIntervals(new int[][]{{3, 5}, {12, 15}}, new int[]{6, 6});
        insertIntervals(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        insertIntervals(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 9});
    }

    static class SolutionOptimized{
        static class Interval{
            int start;
            int end;

            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> result = new ArrayList<>();

            if (intervals.size() == 0) {
                result.add(newInterval);
                return result;
            }

            int p = helper(intervals, newInterval);

            result.addAll(intervals.subList(0, p));

            for (int i = p; i < intervals.size(); i++) {
                Interval inter = intervals.get(i);
                if (inter.end < newInterval.start) {
                    result.add(inter);
                } else if (inter.start > newInterval.end) {
                    result.add(newInterval);
                    newInterval = inter;
                } else if (inter.end >= newInterval.start || inter.start <= newInterval.end) {
                    newInterval = new Interval(Math.min(inter.start, newInterval.start), Math.max(newInterval.end, inter.end));
                }
            }

            result.add(newInterval);

            return result;
        }

        public int helper(List<Interval> intervals, Interval newInterval) {
            int low = 0;
            int high = intervals.size() - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (newInterval.start <= intervals.get(mid).start) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return high == 0 ? 0 : high - 1;
        }
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
