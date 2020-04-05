package com.code.test.problemset.CrackingCodingInterview6.ch8;

import com.code.test.problemset.leetcode.Q224_GenerateParentheses;

/**
 * Parens:
 * Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n pairs of parentheses.
 * Hint: https://www.youtube.com/watch?v=sz1qaKt0KGQ
 * <p>
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Q9_Parens {
    public static void main(String[] args) {
        Q224_GenerateParentheses  q = new Q224_GenerateParentheses();
        q.generateParenthesis(0).forEach(System.out::println);
    }
}
