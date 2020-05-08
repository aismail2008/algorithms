package com.code.test.problemset.leetcode;

/**
 * Implement strStr()
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
 *    and Java's indexOf().
 *
 * https://leetcode.com/problems/implement-strstr/
 */
public class _StrStr {
    // hello (5)      ll (2)
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        int max = (haystack.length() - needle.length()); //3
        for (int i = 0; i <= max; i++) {
            // Look for first character.
            if (haystack.charAt(i) != needle.charAt(0))
                continue;
            // i = 2,  j = 3, end = 2+2-1 = 3
            // Found first character, now look at the rest of value
            int j = i + 1;
            int end = i + needle.length() - 1;
            while (j - i < needle.length() && haystack.charAt(j) == needle.charAt(j - i))
                j++;
            if (j == end + 1) {
                return i;
            }
        }
        return -1;
    }
}
