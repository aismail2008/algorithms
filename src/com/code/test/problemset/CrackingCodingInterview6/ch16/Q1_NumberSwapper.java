package com.code.test.problemset.CrackingCodingInterview6.ch16;

/**
 * 􏰼􏰹􏱂􏱕􏱛􏰭Number Swapper:
 * Write a function to swap a number in place (that is, without temporary variables).
 */
public class Q1_NumberSwapper {
    public static void swap(int a, int b) {
        // Example for a = 9, b = 4
        a = a - b; // a = 9 - 4 = 5
        b = a + b; // b = 5 + 4 = 9
        a = b - a; // a = 9 - 5

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public static void swap_opt(int a, int b) {
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public static void main(String[] args) {
        int a = 1672;
        int b = 9332;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        swap(a, b);
        swap_opt(a, b);
    }
}
