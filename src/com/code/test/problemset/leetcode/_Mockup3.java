package com.code.test.problemset.leetcode;


import java.util.*;

public class _Mockup3 {

    public static void main(String[] args) {
        SolutionA.main(args);

    }

    /**
     * Height Checker
     * <p>
     * Students are asked to stand in non-decreasing order of heights for an annual photo.
     * <p>
     * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
     * <p>
     * Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: heights = [1,1,4,2,1,3]
     * Output: 3
     * Explanation:
     * Current array : [1,1,4,2,1,3]
     * Target array  : [1,1,1,2,3,4]
     * On index 2 (0-based) we have 4 vs 1 so we have to move this student.
     * On index 4 (0-based) we have 1 vs 3 so we have to move this student.
     * On index 5 (0-based) we have 3 vs 4 so we have to move this student.
     * Example 2:
     * <p>
     * Input: heights = [5,1,2,3,4]
     * Output: 5
     * Example 3:
     * <p>
     * Input: heights = [1,2,3,4,5]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= heights.length <= 100
     * 1 <= heights[i] <= 100
     * <p>
     * https://leetcode.com/problems/height-checker
     */
    static class SolutionA {
        public static void main(String[] args) {
            System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
            System.out.println(heightChecker(new int[]{5, 1, 2, 3, 4}));
            System.out.println(heightChecker(new int[]{1, 2, 3, 4, 5}));
            System.out.println(heightChecker(new int[]{}));
            System.out.println(heightChecker(null));
        }

        public static int heightChecker(int[] heights) {
            if (heights == null || heights.length == 0)
                return 0;
            int[] sorted = heights.clone();
            Arrays.sort(sorted);

            int count = 0;
            for (int i = 0; i < sorted.length; i++) {
                if (heights[i] != sorted[i]) {
                    count++;
                }
            }
            return count;

        }
    }

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
    static class SolutionB {
        public static void main(String[] args) {
            System.out.println(isLongPressedName("plpkoh", "plppkkh"));
            System.out.println(isLongPressedName("alex", "aaleex"));
            System.out.println(isLongPressedName("saeed", "ssaaedd"));
            System.out.println(isLongPressedName("leelee", "lleeelee"));
            System.out.println(isLongPressedName("laiden", "laiden"));
            System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
        }
        public static boolean isLongPressedName(String name, String typed) {
            if (typed.length() < name.length())
                return false;
            if (name.equalsIgnoreCase(typed))
                return true;

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
}
