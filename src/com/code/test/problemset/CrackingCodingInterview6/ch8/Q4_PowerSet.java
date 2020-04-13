package com.code.test.problemset.CrackingCodingInterview6.ch8;

import com.code.test.problemset.leetcode.Q245_Subsets;

import java.util.List;

/**
 * Power Set:
 * Write a method to return all subsets of a set.
 * <p>
 * https://leetcode.com/problems/subsets
 */
public class Q4_PowerSet {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> sol = Q245_Subsets.allSets(arr);
        sol.forEach(lst -> {
            lst.forEach(i -> System.out.print(i + "-"));
            System.out.println();
        });
    }
}
