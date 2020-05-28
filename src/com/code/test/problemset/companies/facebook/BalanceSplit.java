package com.code.test.problemset.companies.facebook;

import com.code.test.problemset.leetcode.Q219_PartitionToKEqualSumSubsets;

import java.util.Arrays;

/**
 *
 * Balanced Split
 * Given a set of integers (which may include repeated integers), determine if there's a way to split the set into two subsets A and B such that the sum of the integers in both sets is the same, and all of the integers in A are strictly smaller than all of the integers in B.
 * Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
 * Signature
 * bool balancedSplitExists(int[] arr)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if such a split is possible, and false otherwise.
 * Example 1
 * arr = [1, 5, 7, 1]
 * output = true
 * We can split the set into A = {1, 1, 5} and B = {7}.
 * Example 2
 * arr = [12, 7, 6, 7, 6]
 * output = false
 * We can't split the set into A = {6, 6, 7} and B = {7, 12} since this doesn't satisfy the requirement that all integers in A are smaller than all integers in B.
 *
 */
public class BalanceSplit {

    public static void main(String[] args) {
        new Q219_PartitionToKEqualSumSubsets();
        canPartition(new int[]{2, 1, 2, 5});
        canPartition(new int[]{3, 6, 3, 4, 4});
    }

    public static boolean canPartition(int[] arr) {
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();

        if (sum % 2 != 0)
            return false;

        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currentSum == sum / 2) {
                int remain = 0;
                if(arr[i] == arr[i-1])
                    return false;
                for (int j = i; j < arr.length; j++) {
                    remain += arr[j];
                }
                if (remain == sum / 2)
                    return true;
                else
                    return false;
            }
            currentSum += arr[i];
        }
        return false;
    }
}
