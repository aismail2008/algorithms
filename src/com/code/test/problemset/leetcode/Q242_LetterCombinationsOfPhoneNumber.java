package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * (Check out your cellphone to see the mappings)
 * Input:Digit string "23",
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Time complexity : O(3^N *4^M)
 *      where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8)
 *      and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.
 *
 * Space complexity : O(3^N)
 *      since one has to keep 3^N * times 4^M solutions
 */
public class Q242_LetterCombinationsOfPhoneNumber {
    static class Solution {
        /* Mapping of digits to letters. */
        static char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        public List<String> letterCombinations(String number) {
            if (number.length() == 0)
                return new ArrayList();
            List<String> results = new ArrayList<>();
            getValidWords(number, 0, "", results);
            return results;
        }

        private void getValidWords(String number, int index, String prefix, List<String> results) {
            /* If it's a complete word, print it. */
            if (index == number.length()) {
                results.add(prefix);
                return;
            }

            /* Get characters that match this digit. */
            char[] letters = getT9Chars(number.charAt(index));

            /* Go through all remaining options. */
            if (letters != null) {
                for (char letter : letters) {
                    getValidWords(number, index + 1, prefix + letter, results);
                }
            }
        }

        /* Return array of characters that map to this digit. */
        static public char[] getT9Chars(char digit) {
            if (!Character.isDigit(digit)) {
                return null;
            }
            int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
            return t9Letters[dig];
        }
    }
}
