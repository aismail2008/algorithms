package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Power Set:
 * Write a method to return all subsets of a set.
 * <p>
 * https://leetcode.com/problems/subsets
 */
public class Q245_Subsets {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        allSets(arr);
    }

    //-------------Ali----------//
//                    ()
//        1             2             3
//    12      13      23
//  123
    static List<List<Integer>> results = new ArrayList<>();

    public static List<List<Integer>> allSets(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        results.add(Collections.emptyList());

        for (int i = 0; i < arr.length; i++) {
            results.add(Collections.singletonList(arr[i]));
            List<Integer> prefix = new ArrayList<>();
            prefix.add(arr[i]);
            allSets(arr, i + 1, prefix);
        }

        return results;
    }

    private static void allSets(int[] arr, int i, List<Integer> prefix) {

        for (; i < arr.length; i++) {
            List cur = new ArrayList<>(prefix);
            cur.add(arr[i]);
            results.add(new ArrayList<>(cur));
            allSets(arr, i + 1, cur);
        }
    }
}
