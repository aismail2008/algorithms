package com.code.test.problemset.CrackingCodingInterview6.ch5;

/**
 * Conversion: Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
 * EXAMPLE
 * Input: 29 (or: 11101), 15 (or: 01111) Output: 2
 */
public class Q6_BitConversion {

    int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) { // or c = c & c-1
            count += c & 1;
            return count;
        }
        return count;
    }

    int bitSwapRequired2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & c - 1) {
            count++;
        }
        return count;
    }
}
