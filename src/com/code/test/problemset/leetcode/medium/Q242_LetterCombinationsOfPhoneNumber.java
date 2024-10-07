package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * (Check out your cellphone to see the mappings)
 * Input:Digit string "23",
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Time complexity : O(K^N)
 *         k: possible choices.
 *         n: length/depth of input
 *         m: number of generated combinations. Filtering is O(m)
 *         O( (k^n) + m)
 *         worst: O(k^n)*
 * Space complexity : O(3^N)
 *      since one has to keep 3^N * times 4^M solutions
 */
@Medium
public class Q242_LetterCombinationsOfPhoneNumber {

    public static List<String> solve(String digits){
        Set<String> dictionary= new HashSet<>();
        // fill in dictionary
        fillDictionary(dictionary);
        //set in separate method for initializing mapping
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();
        getPossibleCombinations("", digits, mapping, combinations);
        return combinations.stream().filter(dictionary::contains).collect(Collectors.toList());
    }

    // we can use memory with generated prev. digits and check in begining to save time of re-processing
    // this can be converted to stack
    private static void getPossibleCombinations(String combination, String nextDigits, String[] mapping, List<String> combinations) {
        if(nextDigits.length() == 0){
            combinations.add(combination);
        }else{
            String letters = mapping[nextDigits.charAt(0) - '0'];
            for(char letter: letters.toCharArray()){
                getPossibleCombinations(combination+letter, nextDigits.substring(1), mapping, combinations);
            }
        }
    }

    private static void fillDictionary(Set dictionary){
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("hat");
        dictionary.add("good");
        dictionary.add("gone");
        dictionary.add("home");
        dictionary.add("hello");
        dictionary.add("test");
    }

    //-----------Another solution---------------//
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
