package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * https://leetcode.com/problems/combinations/
 */
public class Q241_Combinations {

    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        output = new ArrayList<>();
        combine(n, 1, k, new ArrayList<>());
        return output;
    }

    public void combine(int n, int start, int k, List<Integer> prefix) {
        if (k == 0) {
            output.add(prefix);
            return;
        }

        for (int i = start; i + k - 1 <= n; i++) {
            List<Integer> l = new ArrayList<>(prefix);
            l.add(i);
            combine(n, i + 1, k - 1, l);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> output = new Q241_Combinations().combine(5, 3);
    }
}
