package com.code.test.problemset.programcreekbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges (Java)
 * Given a sorted integer array without duplicates, return the summary of its ranges for consecutive numbers.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * <p>
 * https://leetcode.com/problems/summary-ranges/
 */
public class Q9_SummaryRanges {
    public static void main(String[] args) {
        summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        summaryRanges(new int[]{});
        summaryRanges(new int[]{0});


    }

    public static List<String> summaryRanges(int[] a) {
        List<String> ranges = new ArrayList<>();
        if (a == null || a.length == 0) {
            return ranges;
        }

        int val = a[0];
        int startIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == val + 1) {
                val++;
            } else {
                if ((val != a[startIndex])) {
                    ranges.add(a[startIndex] + "->" + val);
                } else {
                    ranges.add("" + a[startIndex]);
                }
                val = a[i];
                startIndex = i;
            }
        }

        if ((val != a[startIndex])) {
            ranges.add(a[startIndex] + "->" + val);
        } else {
            ranges.add("" + a[startIndex]);
        }
        return ranges;
    }
}
