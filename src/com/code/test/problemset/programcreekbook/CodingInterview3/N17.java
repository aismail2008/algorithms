package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by aliismail on 12/11/2017.
 */
public class N17 {
//    Given a string containing just the characters ’(’, ’)’, ’’, ’’, ’[’ and ’]’,
//    determine if the input string is valid. The brackets must close in the correct order,
//    "()" and "()[]" are all valid but "(]" and "([)]" are not.

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
