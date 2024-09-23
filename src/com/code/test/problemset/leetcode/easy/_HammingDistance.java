package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 231.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 * <p>
 * https://leetcode.com/problems/hamming-distance
 */
@Easy
public class _HammingDistance {
    public static void main(String[] args) {
        hammingDistance(1, 4);
    }

    static public int hammingDistanceUsingBits(int x, int y) {
        int diff = 0;

        while (x > 0 || y > 0) {
            diff += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }

        return diff;
    }

    /**
     * Compute the Hamming distance between two integers.
     *
     * @param x First integer
     * @param y Second integer
     * @return The Hamming distance
     */
    public int hammingDistance_sol2(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }

    static public int hammingDistance(int x, int y) {
        StringBuilder binaryX = new StringBuilder(Integer.toBinaryString(x));
        StringBuilder binaryY = new StringBuilder(Integer.toBinaryString(y));

        while (binaryX.length() < binaryY.length()) {
            binaryX.insert(0, "0");
        }

        while (binaryY.length() < binaryX.length()) {
            binaryY.insert(0, "0");
        }

        int diff = 0;
        for (int i = 0; i < binaryX.length(); i++) {
            if (binaryX.charAt(i) != binaryY.charAt(i))
                diff++;

        }
        return diff;
    }
}