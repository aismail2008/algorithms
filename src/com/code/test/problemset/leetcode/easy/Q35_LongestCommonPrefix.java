package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

/**
 * Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 * <p>
 * https://leetcode.com/problems/longest-common-prefix/
 */
@Easy
public class Q35_LongestCommonPrefix {
    public static void main(String[] args) {
        new Q35_LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        new Q35_LongestCommonPrefix().longestCommonPrefix(new String[]{"", ""});
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public String longestCommonPrefix_(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder prefix = new StringBuilder("");
        int currentIndex = 0;
        String str = strs[0];
        while (currentIndex < str.length()) {
            for (int i = 1; i < strs.length; i++) {
                if (currentIndex >= strs[i].length() || strs[i].charAt(currentIndex) != str.charAt(currentIndex)) {
                    return prefix.toString();
                }
            }
            prefix.append(str.charAt(currentIndex));
            currentIndex++;
        }
        return prefix.toString();
    }
}
