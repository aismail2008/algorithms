package com.code.test.problemset.leetcode;


import java.util.HashMap;
import java.util.Map;

public class _Mockup6 {
    /**
     *
     * You are given an array of strings words and a string chars.
     *
     * A string is good if it can be formed by characters from chars (each character can only be used once).
     *
     * Return the sum of lengths of all good strings in words.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["cat","bt","hat","tree"], chars = "atach"
     * Output: 6
     * Explanation:
     * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
     * Example 2:
     *
     * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * Output: 10
     * Explanation:
     * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
     *
     *
     * Note:
     *
     * 1 <= words.length <= 1000
     * 1 <= words[i].length, chars.length <= 100
     * All strings contain lowercase English letters only.
     *
     * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
     */
    static class Solution {
        public int countCharacters(String[] words, String chars) {
            int[] charCounts = new int[256];
            for (char ch : chars.toCharArray()) {
                charCounts[ch - 'a']++;
            }

            int total = 0;
            for (String s : words) {
                int[] temp = charCounts.clone();
                boolean include = true;
                for (char ch : s.toCharArray()) {
                    temp[ch - 'a']--;
                    if (temp[ch - 'a'] < 0) {
                        include = false;
                        break;
                    }
                }
                if (include)
                    total += s.length();
            }

            return total;
        }
    }

    /**
     * Number of Dice Rolls With Target Sum
     *
     * You have d dice, and each die has f faces numbered 1, 2, ..., f.
     * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
     *
     * Example 1:
     * Input: d = 1, f = 6, target = 3
     * Output: 1
     * Explanation:
     * You throw one die with 6 faces.  There is only one way to get a sum of 3.
     *
     * Example 2:
     * Input: d = 2, f = 6, target = 7
     * Output: 6
     * Explanation:
     * You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
     * 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
     *
     * Example 3:
     * Input: d = 2, f = 5, target = 10
     * Output: 1
     * Explanation:
     * You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
     *
     * Example 4:
     * Input: d = 1, f = 2, target = 3
     * Output: 0
     * Explanation:
     * You throw one die with 2 faces.  There is no way to get a sum of 3.
     *
     * Example 5:
     * Input: d = 30, f = 30, target = 500
     * Output: 222616187
     * Explanation:
     * The answer must be returned modulo 10^9 + 7.
     *
     *
     * Constraints:
     *
     * 1 <= d, f <= 30
     * 1 <= target <= 1000
     *
     * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
     */
    static class SolutionB {

        public static void main(String[] args) {
            SolutionB solutionB = new SolutionB();
            System.out.println(solutionB.numRollsToTarget(1, 6, 3));
            System.out.println(solutionB.numRollsToTarget(2, 6, 7));
            System.out.println(solutionB.numRollsToTarget(2, 5, 10));
            System.out.println(solutionB.numRollsToTarget(1, 2, 3));
            System.out.println(solutionB.numRollsToTarget(30, 30, 500));
        }

        private final int MOD = 1000000007;
        private Map<String, Integer> mem = new HashMap<>();

        public int numRollsToTarget(int d, int f, int target) {
            if (d == 0 && target == 0) {
                return 1;
            }

            if (d <= 0) {
                return 0;
            }

            String key = d + "_" + target;
            if (mem.containsKey(key)) {
                return mem.get(key);
            }

            int total = 0;
            for (int i = 1; i <= target && i <= f; i++) {
                total += numRollsToTarget(d - 1, f, target - i);
                total = total % MOD;
            }

            mem.put(key, total);
            return total;
        }
    }
}
