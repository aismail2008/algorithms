package com.code.test.problemset.companies.Pramp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Pairs with Specific Difference
 * Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference
 * that returns an array of all pairs [x,y] in arr, such that x - y = k. If no such pairs exist, return an empty array.
 *
 * Note: the order of the pairs in the output array should maintain the order of the y element in the original array.
 *
 * Examples:
 *
 * input:  arr = [0, -1, -2, 2, 1], k = 1
 * output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
 *
 * input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
 * output: []
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] array.integer arr
 *
 * 0 ≤ arr.length ≤ 100
 * [input]integer k
 *
 * k ≥ 0
 * [output] array.array.integer
 */
public class PairsWithDifference {
    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        List<int[]> sol = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            // x = k + y
            int target = k + arr[i];

            if (set.contains(target)) {
                sol.add(new int[]{target, arr[i]});
            }
        }

        int[][] output = new int[sol.size()][];
        sol.toArray(output);
        return output;
    }

    public static void main(String[] args) {

    }

}
