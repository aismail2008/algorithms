package com.code.test.problemset.leetcode;

import com.code.test.problemset.basics.datastructure.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * (Check out your cellphone to see the mappings)
 * Input:Digit string "23",
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Q242_LetterCombinationsOfPhoneNumber {
    static class Solution {
        public List<String> getValidT9Words(String number, HashSet<String> wordList) {
            if (number.length() == 0)
                return new ArrayList<>();
            List<String> results = new ArrayList<>();
            getValidWords(number, 0, "", wordList, results);
            return results;
        }

        private void getValidWords(String number, int index, String prefix, HashSet<String> wordSet, List<String> results) {
            /* If it's a complete word, print it. */
            if (index == number.length() && wordSet.contains(prefix)) {
                results.add(prefix);
                return;
            }

            /* Get characters that match this digit. */
            char[] letters = getT9Chars(number.charAt(index));

            /* Go through all remaining options. */
            if (letters != null) {
                for (char letter : letters) {
                    getValidWords(number, index + 1, prefix + letter, wordSet, results);
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

        /* Mapping of digits to letters. */
        static char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    }

    static class OptimizedSolutionTrie {
        public List<String> getValidT9Words(String number, Trie wordList) {
            List<String> results = new ArrayList<>();
            getValidWords(number, 0, "", wordList.root, results);
            return results;
        }

        private void getValidWords(String number, int index, String prefix, Trie.TrieNode trieNode, List<String> results) {
            /* If it's a complete word, print it. */
            if (index == number.length()) {
                if (trieNode.terminates(prefix)) {
                    results.add(prefix);
                    return;
                }
            }
            /* Get characters that match this digit. */
            char[] letters = Solution.getT9Chars(number.charAt(index));

            /* Go through all remaining options. */
            if (letters != null) {
                for (char letter : letters) {
                    Trie.TrieNode child = trieNode.getChild(letter);
                    if (child != null) {
                        getValidWords(number, index + 1, prefix + letter, child, results);
                    }
                }
            }
        }
    }
}
