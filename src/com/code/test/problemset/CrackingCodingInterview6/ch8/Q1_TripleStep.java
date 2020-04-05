package com.code.test.problemset.CrackingCodingInterview6.ch8;

import java.util.Arrays;

/**
 * Triple Step:
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class Q1_TripleStep {

    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    //- Optimized with Memory
    public static int countWaysMem(int n) {
        int[] memory = new int[n + 1];
        Arrays.fill(memory, -1);
        return countWays(n, memory);
    }

    public static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
            return memo[n];
        }
    }


    public static void main(String[] args) {
        int n = 20;
        int ways = countWays(n);
        System.out.println(ways);
    }
}
