package com.code.test.problemset.leetcode;

import java.util.ArrayList;

/**
 *
 * https://leetcode.com/problems/my-calendar-ii/
 */
public class _MyCalendarII {

    static class MyCalendarTwo {
        ArrayList<int[]> single = null;
        ArrayList<int[]> overlap = null;

        public MyCalendarTwo() {
            single = new ArrayList<>();
            overlap = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] itv : overlap) {
                if (end > itv[0] && start < itv[1]) {
                    return false;
                }
            }

            for (int[] itv : single) {
                if (end > itv[0] && start < itv[1]) {
                    // keeps only intersected area
                    overlap.add(new int[]{Math.max(itv[0], start), Math.min(itv[1], end)});
                }
            }

            single.add(new int[]{start, end});

            return true;
        }
    }
}
