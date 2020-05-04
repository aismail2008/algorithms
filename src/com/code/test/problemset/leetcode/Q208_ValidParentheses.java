package com.code.test.problemset.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Valid Parentheses / brackets
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Q208_ValidParentheses {

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) { // closing
                if (stack.empty() || stack.peek() != map.get(ch)) {
                    return false;
                }

                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.empty();
    }
}
