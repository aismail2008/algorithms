package com.code.test.problemset.leetcode.easy;


import com.code.test.problemset.leetcode.Easy;

/**
 * Long Pressed Name
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * <p>
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 * <p>
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 * <p>
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 * <p>
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * <p>
 * <p>
 * Note:
 * <p>
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 * <p>
 * https://leetcode.com/problems/long-pressed-name/
 */
@Easy
public class _LongPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName_better("alex", "aaleex"));
        System.out.println(isLongPressedName_better("alex", "aaleex"));
        System.out.println(isLongPressedName_better("saeed", "ssaaedd"));
        System.out.println(isLongPressedName_better("leelee", "lleeelee"));
        System.out.println(isLongPressedName_better("laiden", "laiden"));
        System.out.println(isLongPressedName_better("pyplrz", "ppyypllr"));
    }

    //alex, aaleex
    public static boolean isLongPressedName_better(String name, String typed) {
        if (typed.length() < name.length())
            return false;
        if (name.equalsIgnoreCase(typed))
            return true;

        name = name.toLowerCase();
        typed = typed.toLowerCase();
        int j = 0;
        int i = 0;
        while(j < typed.length()) {
            if(name.charAt(i) == typed.charAt(j)) {
                i++;
            }else if (j == 0 || typed.charAt(j) != typed.charAt(j-1)){
                return false;
            }
            j++;
        }

        return i == name.length();
    }

    public static boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length())
            return false;
        if (name.equalsIgnoreCase(typed))
            return true;
        name = name.toLowerCase();
        typed = typed.toLowerCase();
        int ni = 0;
        int ti = 0;
        while (ni < name.length() && ti < typed.length()) {
            if (name.charAt(ni) != typed.charAt(ti)) {
                return false;
            }

            int ncnt = 1;
            ni++;
            while (ni < name.length() && name.charAt(ni) == name.charAt(ni - 1)) {
                ncnt++;
                ni++;
            }

            ncnt--;
            ti++;
            while (ti < typed.length() && typed.charAt(ti) == typed.charAt(ti - 1)) {
                ncnt--;
                ti++;
            }

            if (ncnt > 0)
                return false;
        }

        if (ni < name.length() || ti < typed.length())
            return false;

        return true;
    }
}
