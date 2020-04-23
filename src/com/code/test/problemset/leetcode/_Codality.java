package com.code.test.problemset.leetcode;

import java.util.*;

public class _Codality {
    static class Solution {
        public static void main(String[] args) {
            Solution test = new Solution();
            test.solution("aab", 1);

        }

        public static String compressStr(String str) {
            String compressedString = "";
            int countConsecutive = 0;
            for (int i = 0; i < str.length(); i++) {
                countConsecutive++;

                /* If next character is different than current, append this char to result.*/
                if (i + 1 >= str.length() // This is the end
                        || str.charAt(i) != str.charAt(i + 1)) {
                    if (countConsecutive > 1) {
                        compressedString += "" + countConsecutive + str.charAt(i);
                    } else {
                        compressedString += "" + str.charAt(i);
                    }
                    countConsecutive = 0;
                }
            }
            return compressedString;
        }

        public int solution(String str, int k) {
            if (str.length() == 0 || k >= str.length())
                return 0;
            if (k == 0)
                return compressStr(str).length();

            // write your code in Java SE 8
            int compressed = str.length();
            for (int i = 0; i + k < str.length(); i++) {
                int temp = compressStr(str.substring(0, i) + str.substring(i + k)).length();
                if (temp < compressed)
                    compressed = temp;
            }
            return compressed;
        }
    }

    static class SolutionA {
        public static void main(String[] args) {
        }

        static class CirclePoint {
            public Double c;
            public char ch;

            public CirclePoint(int x, int y, char ch) {
                c = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                this.ch = ch;
            }
        }

        public int solution(String S, int[] X, int[] Y) {
            if (X.length == 0)
                return 0;
            if (X.length == 1)
                return 1;
            // write your code in Java SE 8
            ArrayList<CirclePoint> points = new ArrayList<>();
            for (int i = 0; i < X.length; i++) {
                points.add(new CirclePoint(X[i], Y[i], S.charAt(i)));
            }

            Collections.sort(points, Comparator.comparing(o -> o.c));

            if (points.get(0).c == points.get(1).c && points.get(0).ch == points.get(1).ch)
                return 0;

            CirclePoint first = points.get(0);

            boolean[] charArr = new boolean[26];
            int count = 1;
            charArr[Character.toLowerCase(first.ch) - 'a'] = true;
            int i = 1;
            for (; i < points.size(); i++) {
                if (charArr[Character.toLowerCase(points.get(i).ch) - 'a'])
                    break;

                charArr[Character.toLowerCase(points.get(i).ch) - 'a'] = true;
                count++;
            }

            if (points.get(i - 1).ch == points.get(i).ch && points.get(i - 1).c - points.get(i).c == 0.0) {
                count--;
            }
            return count;
        }
    }

    static class SolutionC {
        public static void main(String[] args) {
            SolutionC test = new SolutionC();
        }

        public int solution(int[] A) {
            if (A.length < 2)
                return 0;
            int total = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            Arrays.stream(A).forEach(a -> queue.offer(a));

            while (queue.size() > 2) {
                int first = queue.poll();
                int second = queue.poll();
                total += first + second;
                queue.offer(first + second);

            }

            return total + queue.poll() + queue.poll();
        }
    }
}