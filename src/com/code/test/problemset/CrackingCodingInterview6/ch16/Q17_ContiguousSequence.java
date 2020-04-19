package com.code.test.problemset.CrackingCodingInterview6.ch16;

/**
 * Contiguous Sequence:
 * You are given an array of integers (both positive and negative). Find the
 * contiguous sequence with the largest sum. Return the sum.
 * EXAMPLE
 * Input: 2, -8, 3, -2, 4, -10
 * Output: 5 ( i. e • , { 3, -2, 4} )
 */
public class Q17_ContiguousSequence {
    public static int getMaxSum(int[] a) {
        int maxSum = 0;
        int runningSum = 0;

        for (int i = 0; i < a.length; i++) {
            runningSum += a[i];

            if (maxSum < runningSum) {
                maxSum = runningSum;
            } else if (runningSum < 0) {
                runningSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {2, -8, 3, -2, 4, -10};
        System.out.println(getMaxSum(a));
    }
}
