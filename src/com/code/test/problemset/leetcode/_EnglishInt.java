package com.code.test.problemset.leetcode;

import java.util.LinkedList;

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
public class _EnglishInt {
    public static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million", "Billion"};
    public static String hundred = "Hundred";
    public static String negative = "Negative";

    public static String convert(int num) {
        if (num == 0) {
            return smalls[0];
        } else if (num < 0) {
            return negative + " " + convert(-1 * num);
        }

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000; // shift chunk
            chunkCount++;
        }

        return listToString(parts).trim();
    }

    /* Convert a linked list of strings to a string, dividing it up with spaces. */
    public static String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.pop());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }

    public static String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<>();

        /* Convert hundreds place */
        if (number >= 100) {
            parts.addLast(smalls[number / 100]);
            parts.addLast(hundred);
            number %= 100;
        }

        /* Convert tens place */
        if (number >= 10 && number <= 19) {
            parts.addLast(smalls[number]);
        } else if (number >= 20) {
            parts.addLast(tens[number / 10]);
            number %= 10;
        }

        /* Convert ones place */
        if (number >= 1 && number <= 9) {
            parts.addLast(smalls[number]);
        }

        return listToString(parts);
    }

    public static void main(String[] args) {

        System.out.println(convert(2147483647));
        
    }

}
