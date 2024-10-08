package com.code.test.problemset.CrackingCodingInterview6.ch1;

import com.code.test.problemset.leetcode.Medium;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * https://leetcode.com/problems/string-compression/
 */
@Medium
public class N6_StringCompression {
    public static String compress(String str) {
        StringBuilder compressedString = new StringBuilder("");
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() // This is the end
                    || str.charAt(i) != str.charAt(i + 1)) {
                compressedString = compressedString.append("" + str.charAt(i) + countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedString.toString();
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(str);
        System.out.println(compress(str));

        str = "aa";
        System.out.println(str);
        System.out.println(compress(str));
    }
}
