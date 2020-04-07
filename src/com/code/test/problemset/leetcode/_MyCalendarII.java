package com.code.test.problemset.leetcode;

import java.util.ArrayList;

/**
 *
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open
 * interval [start, end), the range of real numbers x such that start <= x < end. A triple booking happens when three
 * events have some non-empty intersection (ie., there is some time that is common to all 3 events.) For each call to
 * the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking.
 * Otherwise, return false and do not add the event to the calendar. Your class will be called like this:
 * MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 * Example:
 *
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
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
