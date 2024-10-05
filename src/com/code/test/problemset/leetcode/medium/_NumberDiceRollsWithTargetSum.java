package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Number of Dice Rolls With Target Sum
 * <p>
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
 * <p>
 * Example 1:
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation:
 * You throw one die with 6 faces.  There is only one way to get a sum of 3.
 * <p>
 * Example 2:
 * Input: d = 2, f = 6, target = 7
 * Output: 6
 * Explanation:
 * You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
 * 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * <p>
 * Example 3:
 * Input: d = 2, f = 5, target = 10
 * Output: 1
 * Explanation:
 * You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
 * <p>
 * Example 4:
 * Input: d = 1, f = 2, target = 3
 * Output: 0
 * Explanation:
 * You throw one die with 2 faces.  There is no way to get a sum of 3.
 * <p>
 * Example 5:
 * Input: d = 30, f = 30, target = 500
 * Output: 222616187
 * Explanation:
 * The answer must be returned modulo 10^9 + 7.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 * <p>
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
@Medium
public class _NumberDiceRollsWithTargetSum {
    public static void main(String[] args) {
        _NumberDiceRollsWithTargetSum solutionB = new _NumberDiceRollsWithTargetSum();
        System.out.println(solutionB.numRollsToTarget(1, 6, 3));
        System.out.println(solutionB.numRollsToTarget(2, 6, 7));
        System.out.println(solutionB.numRollsToTarget(2, 5, 10));
        System.out.println(solutionB.numRollsToTarget(1, 2, 3));
        System.out.println(solutionB.numRollsToTarget(30, 30, 500));
    }

    private final int MOD = 1000000007;
    private Map<String, Integer> mem = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {
        if (d == 0 && target == 0) {
            return 1;
        }

        if (d <= 0) {
            return 0;
        }

        String key = d + "_" + target;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        int total = 0;
        for (int i = 1; i <= target && i <= f; i++) {
            total += numRollsToTarget(d - 1, f, target - i);
            total = total % MOD;
        }

        mem.put(key, total);
        return total;
    }


    class DP {
        // use array instead of hashmap (is faster and reduces memory)
        private int[][] dp;

        public int numRollsToTarget(int d, int f, int target) {
            dp = new int[d + 1][target + 1];
            return ways(0, d, f, target);
        }

        private int ways(int n, int d, int f, int target) {
            // could not partition target into dices values
            // d1 + d2 + d3 + ... + dn ≠ target
            if (n > d || target < 0) {
                return 0;
            }
            // if solution is stored in dp array, then skip recursion
            // return precomputed result
            if (dp[n][target] == -1) {
                return 0;
            } else if (dp[n][target] > 0) {
                return dp[n][target];
            }
            // we partitioned target from dice values successfully. 1 possible way
            if (n == d && target == 0) {
                return 1;
            }
            // main problem can be sub-divided into smaller sub-problems:
            // let, T(d, target) = no of ways to achieve: d1 + d2 + d3 + ... + dn = target
            // then, T(d, target) = [T(1, 1) + T(d-1, target - 1)] +
            //                      [T(1, 2) + T(d-1, target - 2)] +
            //                      ... +
            //                      [T(1, f) + T(d-1, target - f)]
            int sum = 0;
            for (int k = 1; k <= f; k++) {
                sum = (sum + ways(n + 1, d, f, target - k)) % 1000000007;
            }
            // store the result in dp array for later use
            if (sum == 0) {
                dp[n][target] = -1;
            } else {
                dp[n][target] = sum;
            }
            return sum;
        }
    }
}
