package com.code.test.problemset.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Verifying Alien Dictionary / validate Alien Dictionary
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class _VerifyingAlienDictionary {

    Map<Character, Integer> map = new HashMap<>(); // could be replaced with order.indexOf(char)

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!isSorted(words[i - 1], words[i])) {
                return false;
            }
        }

        return true;
    }

    public boolean isSorted(String a, String b) {
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (map.get(a.charAt(i)) < map.get(b.charAt(i))) {
                return true;
            } else if (map.get(a.charAt(i)) > map.get(b.charAt(i))) {
                return false;
            }
        }
        return a.length() < b.length();
    }

    public static void main(String[] args) {
        new _VerifyingAlienDictionary().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        new _VerifyingAlienDictionary().isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz");

    }
}
