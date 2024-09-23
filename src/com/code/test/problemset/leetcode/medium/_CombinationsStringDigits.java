package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations in a String of Digits
 * Given an input string of numbers, find all combinations of numbers
 *  that can be formed using digits in the same order.
 *
 * Examples:
 *
 * Input : 123
 * Output :1 2 3
 *         1 23
 *         12 3
 *         123
 *
 * Input : 1234
 * Output : 1 2 3 4
 *         1 2 34
 *         1 23 4
 *         1 234
 *         12 3 4
 *         12 34
 *         123 4
 *         1234
 */
@Medium
public class _CombinationsStringDigits {

    static List<String> sol = new ArrayList<>();

    /**
     * First with Start = 1
     * @param s
     * @param start
     */
    static public void solve(String s, int start) {
        if (start == s.length())
            return;

        for (int i = start; i < s.length(); i++) {
            String s2 = s.substring(0, i) + ' ' + s.substring(i);
            sol.add(s2.trim());
            solve(s2.trim(), i + 2);
        }
    }

   public static void main(String[] args) {
        solve("1234", 1);
        sol.forEach(System.out::println);
    }
}
