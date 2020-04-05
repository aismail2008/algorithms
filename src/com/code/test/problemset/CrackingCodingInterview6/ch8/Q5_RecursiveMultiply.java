package com.code.test.problemset.CrackingCodingInterview6.ch8;

/**
 * Recursive Multiply:
 *   Write a recursive function to multiply two positive integers without using the * operator (or / operator).
 *   You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 *
 */
public class Q5_RecursiveMultiply {

    public static int counter = 0;

    /* This is an algorithm called the peasant algorithm.
     * https://en.wikipedia.org/wiki/Multiplication_algorithm#Peasant_or_binary_multiplication
     */
    public static int minProduct(int a, int b) {
        if (a < b) return minProduct(b, a);
        int value = 0;
        while (a > 0) {
            counter++;
            if ((a % 10) % 2 == 1) {
                value += b;
            }
            a >>= 1;
            b <<= 1;
        }
        return value;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int prod1 = minProduct(i, j);
                int prod2 = i * j;
                if (prod1 != prod2) {
                    System.out.println("ERROR: " + i + " * " + j + " = " + prod2 + ", not " + prod1);
                }
            }
        }
    }
}