package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Parens:
 * Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n pairs of parentheses.
 * Hint: https://www.youtube.com/watch?v=sz1qaKt0KGQ
 * <p>
 * https://leetcode.com/problems/generate-parentheses/
 *
 */
public class Q224_GenerateParentheses {
    public void generateParenthesis(int left, int right, StringBuilder current, List<String> all) {
        if (left == 0) {
            while (right > 0) {
                current.append(")");
                right--;
            }
            all.add(current.toString());
            return;
        }

        if (left == right) {
            generateParenthesis(left - 1, right, new StringBuilder(current + "("), all);
        } else if (left < right) {
            generateParenthesis(left - 1, right, new StringBuilder(current + "("), all);
            generateParenthesis(left, right - 1, new StringBuilder(current + ")"), all);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> all = new ArrayList<>();
        generateParenthesis(n, n, new StringBuilder(""), all);
        return all;
    }

    public static void main(String[] args) {
        Q224_GenerateParentheses q = new Q224_GenerateParentheses();
        q.generateParenthesis(0).forEach(System.out::println);

    }
}
