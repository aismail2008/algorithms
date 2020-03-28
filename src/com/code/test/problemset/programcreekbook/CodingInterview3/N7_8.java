package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.*;

/**
 * Created by aliismail on 09/11/2017.
 */
public class N7_8 {
//    Given a collection of intervals, merge all overlapping intervals.
//            22 | 247
//            7 Merge Intervals
//    For example,
//    Given [1,3],[2,6],[8,10],[15,18],
//            return [1,6],[8,10],[15,18].

    static class Interval {
        Integer start;
        Integer end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Interval> l = new ArrayList<>();
        l.add(new Interval(1, 2));
        l.add(new Interval(6, 7));
        l.add(new Interval(3, 5));
        l.add(new Interval(12, 15));
        l.add(new Interval(8, 10));
        mergeIntervals(l);

        l.forEach(System.out::println);
        System.out.println("=======");
        addInterval(l, new Interval(4, 9));
        l.forEach(System.out::println);
    }

    public static void mergeIntervals(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start.compareTo(o2.start);
            }
        });

        for (int i = 0; i < intervals.size() - 2; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = Math.max(intervals.get(i + 1).end, intervals.get(i).end);
                intervals.remove(i + 1);
            }
        }
    }
    //    Problem:
    //    Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).
    //    Example 1:
    //    Given intervals [1,2],[3,5],[6,7],[8,10],[12,16] insert and merge [2,5] in as [1,5],[6,9].
    //    Example 2:
    //    Given [1,2],[4,10],[12,16], insert and merge [4,9] in as
    //    [1,2],[3,10],[12,16].
    //    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

    public static void addInterval(List<Interval> intervals, Interval insertInter) {
        for (int i = 0; i < intervals.size(); i++) {
            if ((intervals.get(i).end >= insertInter.start && intervals.get(i).start <= insertInter.start) ||
                    (intervals.get(i).start >= insertInter.start && intervals.get(i).start <= insertInter.end)) {

                intervals.get(i).start = Math.min(intervals.get(i).start, insertInter.start);
                intervals.get(i).end = Math.max(intervals.get(i).end, insertInter.end);
//                keep merging with next till end then return;
                while (i < intervals.size()) {
                    if (intervals.get(i).end >= intervals.get(i + 1).start) {
                        intervals.get(i).end = Math.max(intervals.get(i + 1).end, intervals.get(i).end);
                        intervals.remove(i + 1);
                    } else
                        return;
                }
            }
        }
    }
}
