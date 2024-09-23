package com.code.test.problemset.leetcode.easy;


import com.code.test.problemset.leetcode.Easy;

/**
 * 1-bit and 2-bit Characters
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * <p>
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * Note:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 * <p>
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 */
@Easy
public class _IsOneBitCharacter {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 1, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int end = bits.length - 1;
        for (int i = 0; i < end; i++) {
            if (bits[i] == 1) {
                if (i + 1 >= end) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
