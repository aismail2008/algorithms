package com.code.test.problemset.CrackingCodingInterview6.ch16;

/**
 * Number Max:
 * max of two numbers
 * Write a method that finds the maximum of two numbers. You should not use if else
 * or any other comparison operator.
 */
public class Q7_NumberMax {
    public static void main(String[] args) {
        int a = 26;
        int b = -15;

        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

        a = -15;
        b = 2147483647;

        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
    }

    public static int getMax(int a, int b) {
        int c = a - b;

        int sa = sign(a); // if a >= 0, then 1 else 0
        int sb = sign(b); // if b >= 0, then 1 else 0
        int sc = sign(c); // depends on whether or not a - b overflows

        /* We want to define a value k which is 1 if a > b and 0 if a < b.
         * (if a = b, it doesn't matter what value k is) */

        int use_sign_of_a = sa ^ sb; // If a and b have different signs, then k = sign(a)
        int use_sign_of_c = flip(sa ^ sb); // If a and b have the same sign, then k = sign(a - b)

        /* We can't use a comparison operator, but we can multiply values by 1 or 0 */
        int k = use_sign_of_a * sa + use_sign_of_c * sc;
        int q = flip(k); // opposite of k

        return a * k + b * q;
    }

    private static int flip(int bit) {
        return 1 ^ bit;
    }

    // 1 if positive 0 negative
    private static int sign(int a) {
        return (a >>> 31) ^ 1;
    }
}
