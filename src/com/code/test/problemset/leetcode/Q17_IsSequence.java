package com.code.test.problemset.leetcode;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * https://leetcode.com/problems/is-subsequence/
 */
public class Q17_IsSequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;

            if (i == s.length())
                return true;
        }

        return false;
    }

    public boolean isSubsequence_Ali(String s, String t) {
        if (s.length() == 0)
            return true;

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            j = t.indexOf(s.charAt(i), j);
            if(j == -1)
                return false;
            i++;
            j++;

            if (i == s.length())
                return true;
        }

        return false;
    }
}
