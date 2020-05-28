package com.code.test.problemset.leetcode;

/**
 * Sqrt(x)
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 *   https://leetcode.com/problems/sqrtx/
 *
 * ----------------------------
 * Root of Number
 * Many times, we need to re-implement basic functions without using any standard library functions already implemented. For example, when designing a chip that requires very little memory space.
 *
 * In this question we’ll implement a function root that calculates the n’th root of a number. The function takes a nonnegative number x and a positive integer n, and returns the positive n’th root of x within an error of 0.001 (i.e. suppose the real root is y, then the error is: |y-root(x,n)| and must satisfy |y-root(x,n)| < 0.001).
 *
 * Don’t be intimidated by the question. While there are many algorithms to calculate roots that require prior knowledge in numerical analysis (some of them are mentioned here), there is also an elementary method which doesn’t require more than guessing-and-checking. Try to think more in terms of the latter.
 *
 * Make sure your algorithm is efficient, and analyze its time and space complexities.
 *
 * Examples:
 *
 * input:  x = 7, n = 3
 * output: 1.913
 *
 * input:  x = 9, n = 2
 * output: 3
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] float x
 *
 * 0 ≤ x
 * [input] integer n
 *
 * 0 < n
 * [output] float
 */
public class _Sqrt {

    public int mySqrt(int x) {
        return (int) mySqrt(x, 2);
    }

    static public double mySqrt(double x, int n) {
        if (x == 1)
            return 1;

        double left = 0;
        double right = x;

        while (left <= right) {
            double mid = left + (right - left) / n;
            double result = Math.pow(mid, n);
            if (Math.abs(result - x) < 0.001) {
                return mid;
            } else if (result > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
