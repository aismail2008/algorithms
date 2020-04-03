package com.code.test.problemset.CrackingCodingInterview6.ch5;

/**
 * 5.7 PairwiseSwap:
 * Write a program to swap odd and even bits in an integer with as few instructions as possible
 * (e.g., bit O and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 */
public class Q7_SwapOddEvenBits {

    public static int swapOddEvenBits(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }

    public static void main(String[] args) {
    }

}
