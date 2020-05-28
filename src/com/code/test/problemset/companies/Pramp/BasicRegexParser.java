package com.code.test.problemset.companies.Pramp;

/**
 * Basic Regex Parser
 * Implement a regular expression function isMatch that supports the '.' and '*' symbols. The function receives two strings - text and pattern - and should return true if the text matches the pattern as a regular expression. For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string and are used as special symbols only in the pattern string.
 *
 * In case you aren’t familiar with regular expressions, the function determines if the text and pattern are the equal, where the '.' is treated as a single a character wildcard (see third example), and '*' is matched for a zero or more sequence of the previous letter (see fourth and fifth examples). For more information on regular expression matching, see the Regular Expression Wikipedia page.
 *
 * Explain your algorithm, and analyze its time and space complexities.
 *
 * Examples:
 *
 * input:  text = "aa", pattern = "a"
 * output: false
 *
 * input:  text = "aa", pattern = "aa"
 * output: true
 *
 * input:  text = "abc", pattern = "a.c"
 * output: true
 *
 * input:  text = "abbb", pattern = "ab*"
 * output: true
 *
 * input:  text = "acd", pattern = "ab*c."
 * output: true
 * Constraints:
 *
 * [time limit] 5000ms
 * [input] string text
 * [input] string pattern
 * [output] boolean
 */
public class BasicRegexParser {
    static boolean isMatch(String text, String pattern) {
        if (pattern.equals(text)) {
            return true;
        }
        while (pattern.startsWith("*")) {
            pattern = pattern.replace("*", "");
        }

        if(pattern.length() == 0 && text.length() > 0  ){
            return false;
        }

        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            String toMatch = pattern.substring(0, 2); // .* or a*
            boolean success = isMatch(text, pattern.substring(2)); // zero

            String st = toMatch.startsWith(".")? text.substring(0, 1): toMatch.substring(0,1);
            int index = 0;
            while (!success && index < text.length() && text.substring(index, index + 1).equals(st)) {  // 1 or more
                success = isMatch(text.substring(index + 1), pattern.substring(2));
                index++;
            }
            return success;
        } else if (pattern.charAt(0) == '.') {
            return isMatch(text.substring(1), pattern.substring(1));
        } else { // a or b or ..
            if (!pattern.substring(0,1).equals(text.substring(0, 1))) {
                return false;
            }
            return isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("abc", "a.c"));
        System.out.println(isMatch("abbb", "ab*"));
        System.out.println(isMatch("acd", "ab*c."));

    }
}
