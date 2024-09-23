package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

/**
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 * <p>
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 * <p>
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
@Easy
public class _CountCharacters {
    /**
     * can also be used with hasmap of character and integer
     * @param words
     * @param chars
     * @return
     */
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
