package com.code.test.problemset.CrackingCodingInterview6.ch16;

/**
 * Pattern Matching:
 * You are given two strings, pattern and value. The pattern string consists of
 * just the letters a and b, describing a pattern within a string. For example, the string catcatgocatgo
 * matches the pattern aabab (where cat is a and go is b). It also matches patterns like a, ab, and b.
 * Write a method to determine if value matches pattern.
 */
public class Q18_PatternMatching {

    static class bruteForce {
        public static boolean doesMatch(String pattern, String value) {
            if (pattern.length() == 0) return value.length() == 0;
            int size = value.length();

            for (int mainSize = 0; mainSize <= size; mainSize++) {
                String main = value.substring(0, mainSize);
                for (int altStart = mainSize; altStart <= size; altStart++) {
                    for (int altEnd = altStart; altEnd <= size; altEnd++) {
                        String alt = value.substring(altStart, altEnd);
                        String cand = buildFromPattern(pattern, main, alt);
                        if (cand.equals(value)) {
                            System.out.println(main + ", " + alt);
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public static String buildFromPattern(String pattern, String main, String alt) {
            StringBuffer sb = new StringBuffer();
            char first = pattern.charAt(0);
            for (char c : pattern.toCharArray()) {
                if (c == first) {
                    sb.append(main);
                } else {
                    sb.append(alt);
                }
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            String[][] tests = {{"ababb", "backbatbackbatbat"}, {"abab", "backsbatbackbats"}, {"aba", "backsbatbacksbat"}};
            for (String[] test : tests) {
                String pattern = test[0];
                String value = test[1];
                System.out.println(pattern + ", " + value + ": " + doesMatch(pattern, value));
            }

        }
    }

    static class Optimized {
        public static boolean doesMatch(String pattern, String value) {
            if (pattern.length() == 0) return value.length() == 0;

            char mainChar = pattern.charAt(0);
            char altChar = mainChar == 'a' ? 'b' : 'a';
            int size = value.length();

            int countOfMain = countOf(pattern, mainChar);
            int countOfAlt = pattern.length() - countOfMain;
            int firstAlt = pattern.indexOf(altChar);
            int maxMainSize = size / countOfMain;

            for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
                String mainStr = value.substring(0, mainSize);

                int remainingLength = size - mainSize * countOfMain;

                if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
                    int altIndex = firstAlt * mainSize;

                    int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;

                    String altStr = countOfAlt == 0 ? "" : value.substring(altIndex, altSize + altIndex);

                    String cand = buildFromPattern(pattern, mainStr, altStr);
                    if (cand.equals(value)) {
                        System.out.println(mainStr + ", " + altStr);
                        return true;
                    }
                }
            }
            return false;
        }

        public static int countOf(String pattern, char c) {
            int count = 0;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == c) {
                    count++;
                }
            }
            return count;
        }

        public static String buildFromPattern(String pattern, String main, String alt) {
            StringBuffer sb = new StringBuffer();
            char first = pattern.charAt(0);
            for (char c : pattern.toCharArray()) {
                if (c == first) {
                    sb.append(main);
                } else {
                    sb.append(alt);
                }
            }
            return sb.toString();
        }
    }
}
