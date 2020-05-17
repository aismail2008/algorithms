package com.code.test.problemset.companies.Pramp;

import com.code.test.problemset.leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Diff Between Two Strings
 * Given two strings of uppercase letters source and target, list (in string form) a sequence of edits to convert from source to target that uses the least edits possible.
 * <p>
 * For example, with strings source = "ABCDEFG", and target = "ABDFFGH" we might return: ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"
 * <p>
 * More formally, for each character C in source, we will either write the token C, which does not count as an edit; or write the token -C, which counts as an edit.
 * <p>
 * Additionally, between any token that we write, we may write +D where D is any letter, which counts as an edit.
 * <p>
 * At the end, when reading the tokens from left to right, and not including tokens prefixed with a minus-sign, the letters should spell out target (when ignoring plus-signs.)
 * <p>
 * In the example, the answer of A B -C D -E F +F G +H has total number of edits 4 (the minimum possible), and ignoring subtraction-tokens, spells out A, B, D, F, +F, G, +H which represents the string target.
 * <p>
 * If there are multiple answers, use the answer that favors removing from the source first.
 * <p>
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * [input] string source
 * 2 ≤ source.length ≤ 12
 * [input] string target
 * 2 ≤ target.length ≤ 12
 * [output] array.string
 * <p>
 * Similar to {@link com.code.test.problemset.leetcode.Q271_EditDistance}
 */
@Hard
public class DiffBetweenTwoStrings {

    public static void main(String[] args) {
        String[] res = Solution.diffBetweenTwoStrings("ABCDEFG", "ABDFFGH");
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        static String[] diffBetweenTwoStrings(String src, String trg) {
            return diffBetweenTwoStrings(src, trg, new ArrayList<>()).toArray(new String[0]);
        }

        static List<String> diffBetweenTwoStrings(String src, String trg, List<String> result) {
            if (src.equals(trg)) {
                for (int i = 0; i < src.length(); i++)
                    result.add("" + src.charAt(i));
                return result;
            } else if (src.length() == 0) {
                for (int i = 0; i < trg.length(); i++)
                    result.add("+" + trg.charAt(i));
                return result;
            } else if (trg.length() == 0) {
                for (int i = 0; i < src.length(); i++)
                    result.add("-" + src.charAt(i));
                return result;
            }

            if (src.charAt(0) == trg.charAt(0)) {
                result.add("" + src.charAt(0));
                return diffBetweenTwoStrings(src.substring(1), trg.substring(1), result);
            } else {
                List<String> lst = new ArrayList(result);
                lst.add("-" + src.charAt(0));
                List rem = diffBetweenTwoStrings(src.substring(1), trg, lst);

                lst = new ArrayList(result);
                lst.add("+" + trg.charAt(0));
                List add = diffBetweenTwoStrings(src, trg.substring(1), lst);
                return rem.size() > add.size() ? add : rem;
            }
        }
    }

    static class SolutionDP {
        public static void main(String[] args) {
            diffBetweenTwoStrings("ABCDEFG", "ABDFFGH");
        }

        static String[] diffBetweenTwoStrings(String src, String trg) {
            return diffBetweenTwoStrings(src, trg, new ArrayList<>()).toArray(new String[0]);
        }

        static List<String> diffBetweenTwoStrings(String src, String trg, List<String> result) {
            int[][] dp = new int[trg.length() + 1][src.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i < dp.length; i++) { //trg
                for (int j = 1; j < dp[0].length; j++) { //src
                    if (src.charAt(j - 1) == trg.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // this if only you want the output sting with operations
            // to convert src to target
            int j = src.length();
            int i = trg.length();
            while (j > 0 || i > 0) {
                if (src.charAt(j - 1) == trg.charAt(i - 1)) {
                    result.add(0, "" + src.charAt(j - 1));
                    i--;
                    j--;
                } else {
                    if (dp[i][j - 1] < dp[i - 1][j]) {
                        result.add(0, "-" + src.charAt(j - 1));
                        j--;
                    } else {
                        result.add(0, "+" + trg.charAt(i - 1));
                        i--;
                    }
                }
            }
            return result;
        }
    }
}