package com.code.test.problemset.leetcode;

/**
 *
 * Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 * https://leetcode.com/problems/powx-n/submissions/
 */
public class Q300_Power {
    public double myPow(double m, long n) {
        if (n < 0) {
            m = 1 / m;
            n = -n;
        }

        if (n == 0)
            return 1;

        if (n == 1)
            return m;

        double v = myPow(m, n / 2);

        if (n % 2 == 0)
            return v * v;
        else
            return v * v * m;
    }
}
