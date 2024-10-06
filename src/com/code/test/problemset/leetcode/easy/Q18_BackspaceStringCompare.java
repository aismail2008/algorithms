package com.code.test.problemset.leetcode.easy;


import com.code.test.problemset.leetcode.Easy;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * <p>
 * Can you solve it in O(N) time and O(1) space?
 * <p>
 * https://leetcode.com/problems/backspace-string-compare/
 */
@Easy
public class Q18_BackspaceStringCompare {

    public static void main(String[] args) {
        boolean b = backspaceCompare("ab#c", "ad#c");
        b = backspaceCompare("", "");
        b = backspaceCompare("#", "");
        b = backspaceCompare("#", "#");
        b = backspaceCompare("ab##", "c#d#");
        b = backspaceCompare("a##c", "a#c#");
        b = backspaceCompare("a##c", "a#c#");
    }

    public static boolean backspaceCompare_(String str, String tr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);  // Add the character to the stack
            } else if (!stack.isEmpty()) {
                stack.pop();  // Remove the last character if '#' is encountered
            }
        }
        // Convert the stack back to a string
        StringBuilder finalString = new StringBuilder();
        for (char ch : stack) {
            finalString.append(ch);
        }
        str = finalString.toString();
        stack.clear();

        for (char ch : tr.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);  // Add the character to the stack
            } else if (!stack.isEmpty()) {
                stack.pop();  // Remove the last character if '#' is encountered
            }
        }
        // Convert the stack back to a string
        finalString = new StringBuilder();
        for (char ch : stack) {
            finalString.append(ch);
        }

        return str.equals(finalString.toString());
    }

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (i >= 0 || j >= 0) {
            int sp = 0;
            while (i >= 0 && (sp > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') {
                    sp++;
                } else {
                    sp--;
                }
                i--;
            }

            int sp2 = 0;
            while (j >= 0 && (sp2 > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') {
                    sp2++;
                } else {
                    sp2--;
                }
                j--;
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                } else {
                    i--;
                    j--;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
        }

        return i < 0 && j < 0;
    }

}
