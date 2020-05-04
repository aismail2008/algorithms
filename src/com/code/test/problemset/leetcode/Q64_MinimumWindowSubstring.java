package com.code.test.problemset.leetcode;

/**
 * Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * <p>
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class Q64_MinimumWindowSubstring {

    //   https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
    static final int no_of_chars = 256;

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        char[] tChars = new char[256];
        char[] sChars = new char[256];
        for (int i = 0; i < t.length(); i++) {
            tChars[t.charAt(i)]++;
        }

        int start = 0;
        int j = start;
        int count = 0;
        int minWindow = -1;
        int minWindowStartIndex = -1;
        while (j < s.length()) {
            char ch = s.charAt(j);
            sChars[ch]++;

            if (sChars[ch] <= tChars[ch]) {
                count++;
            }

            if (count == t.length()) {
                while (sChars[s.charAt(start)] > tChars[s.charAt(start)]) {
                    sChars[s.charAt(start)]--;
                    start++;
                }

                if (j - start + 1 < minWindow || minWindow == -1) {
                    minWindow =  j - start + 1;
                    minWindowStartIndex = start;
                }
            }
            j++;
        }

        return minWindowStartIndex == -1 ? "" : s.substring(minWindowStartIndex, minWindowStartIndex + minWindow);
    }

    public static void main(String[] args) {
//        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println(minWindow("zdcdbefebce", "fd"));
//        System.out.println(minWindow("bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf", "cbccfafebccdccebdd"));
    }
}
