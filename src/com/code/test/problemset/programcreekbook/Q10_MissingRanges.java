package com.code.test.problemset.programcreekbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Missing Ranges (Java)
 * <p>
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
 * <p>
 * Example:
 * <p>
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 * <p>
 * https://leetcode.com/problems/missing-ranges/
 */
public class Q10_MissingRanges {

    public static void main(String[] args) {
        findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
    }

    public static List<String> findMissingRanges(int[] a, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        if (a == null || a.length == 0) {
            ranges.add(lower + "->" + upper);
            return ranges;
        }

        int start = lower;
        for (int i = 0; i < a.length; i++) {
            if (i + 1 < a.length && a[i] == a[i + 1]) {// 1,1,1,1,
                continue;
            }

            if (a[i] == start) {
                start++;
            } else {

                if (a[i] - 1 == start) {
                    ranges.add(start + "");
                } else {
                    int h = a[i] - 1;
                    ranges.add(start + "->" + h);

                    if (a[i] == Integer.MAX_VALUE) {
                        return ranges;
                    }

                    start = a[i] + 1;
                }
            }
        }

        if (start <= upper) {
            ranges.add(getRange(start, upper));
        }

        return ranges;
    }

    private static String getRange(int n1, int n2) {
        return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
