package com.code.test.problemset.leetcode;


public class _Mockup2 {

    public static void main(String[] args) {
        _Mockup1.SolutionA.main(args);
        _Mockup1.SolutionB.main(args);
    }

    /**
     * Nim game:
     * You are playing the following Nim Game with your friend:
     * There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
     * The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
     * <p>
     * Both of you are very clever and have optimal strategies for the game.
     * Write a function to determine whether you can win the game given the number of stones in the heap.
     * <p>
     * Example:
     * <p>
     * Input: 4
     * Output: false
     * Explanation: If there are 4 stones in the heap, then you will never win the game;
     * No matter 1, 2, or 3 stones you remove, the last stone will always be
     * removed by your friend.
     *
     * https://leetcode.com/problems/nim-game/
     */
    static class SolutionA {
        public boolean canWinNim(int n) {
            if (n % 4 == 0)
                return false;
            return true;
        }
    }

    /**
     *
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     *
     * Given two integers x and y, calculate the Hamming distance.
     *
     * Note:
     * 0 ≤ x, y < 231.
     *
     * Example:
     *
     * Input: x = 1, y = 4
     *
     * Output: 2
     *
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * The above arrows point to positions where the corresponding bits are different.
     *
     * https://leetcode.com/problems/hamming-distance/submissions/
     */
    static class SolutionB {
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
}
