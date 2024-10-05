package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Find And Replace In String:
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.
 * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
 * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 * <p>
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
@Medium
public class Q14_FindAndReplaceInString {

    /**
     * Perform replacement operations on the string s based on the given indices, sources, and targets.
     *
     * @param s       The original string
     * @param indices The indices at which the sources should be replaced
     * @param sources The substrings that must be matched for replacement
     * @param targets The replacement strings
     * @return The string after performing all valid replacements
     */
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // Create a list of replacements to be done, each as an array {index, source, target}
        List<int[]> replacements = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            replacements.add(new int[]{indices[i], i});
        }

        // Sort replacements by index to ensure replacements are done in the correct order
        replacements.sort((a, b) -> a[0] - b[0]);

        StringBuilder result = new StringBuilder();
        int lastIndex = 0;

        for (int[] replacement : replacements) {
            int index = replacement[0];
            int i = replacement[1];
            String source = sources[i];
            String target = targets[i];

            // If the source string matches the substring at the index, replace it with the target string
            if (s.startsWith(source, index)) {
                // Append the part of the string before the current index
                result.append(s, lastIndex, index);
                // Append the target string
                result.append(target);
                // Update lastIndex to the end of the replaced part
                lastIndex = index + source.length();
            }
        }

        // Append the remaining part of the original string after the last replacement
        result.append(s.substring(lastIndex));

        return result.toString();
    }

    public static void main(String[] args) {
        findReplaceString("vmokgggqzp", new int[]{3,5,1}, new String[]{"kg","ggq","mo"}, new String[]{"s","so","bfr"});
    }
}
