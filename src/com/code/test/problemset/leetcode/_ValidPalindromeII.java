package com.code.test.problemset.leetcode;

/**
 *
 * Valid Palindrome II
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class _ValidPalindromeII {

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, true);
    }

    public boolean validPalindrome(String s, int i, int j, boolean first) {
        while (i < j) {
            if (s.charAt(j) == s.charAt(i)) {
                i++;
                j--;
            } else if (s.charAt(j) != s.charAt(i) && first) {
                return validPalindrome(s, i, j - 1, false) ||
                        validPalindrome(s, i + 1, j, false);
            } else
                return false;
        }

        return true;
    }
}
