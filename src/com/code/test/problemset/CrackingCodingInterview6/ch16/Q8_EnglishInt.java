package com.code.test.problemset.CrackingCodingInterview6.ch16;

import com.code.test.problemset.leetcode._EnglishInt;

/**
 * English Int:
 * Given any integer, print an English phrase that describes the integer (e.g., "One
 * Thousand, Two Hundred Thirty Four").
 *
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 *
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class Q8_EnglishInt {

    public static void main(String[] args) {
        System.out.println(_EnglishInt.convert(2147483647));
    }

}
