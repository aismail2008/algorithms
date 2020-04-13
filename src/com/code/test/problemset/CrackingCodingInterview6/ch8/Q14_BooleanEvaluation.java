package com.code.test.problemset.CrackingCodingInterview6.ch8;

/**
 * Boolean Evaluation: Given a boolean expression consisting of the symbols
 * 0 (false), 1 (true), & (AND), I (OR), and /\ (XOR), and a desired boolean result value result,
 * implement a function to count the number of ways of parenthesizing the expression such that it evaluates to result.
 * The expression should be fully parenthesized (e.g.,(0)A(1)) but not extraneously
 * (e.g.,(((0))/\(1))).
 * EXAMPLE
 * countEval("l/\01011", false) -> 2 countEval("0&0&0&1All0", true)-> 10
 */
public class Q14_BooleanEvaluation {
    public static int count = 0;

    public static boolean stringToBool(String c) {
        return c.equals("1") ? true : false;
    }

    public static int countEval(String s, boolean result) {
        count++;
        if (s.length() == 0) return 0;
        if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;

        int ways = 0;

        for (int i = 1; i < s.length(); i += 2) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());

            int subWays = 0;
            if (c == '^') { // required: one true and one false
                int leftTrue = countEval(left, true);
                int leftFalse = countEval(left, false);
                int rightTrue = countEval(right, true);
                int rightFalse = countEval(right, false);
                if (result) {
                    subWays = leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    subWays = leftTrue * rightTrue + leftFalse * rightFalse;
                }
            } else if (c == '&') { // required: both true
                int leftTrue = countEval(left, true);
                int rightTrue = countEval(right, true);
                if (result) {
                    subWays = leftTrue * rightTrue;
                } else {
                    int leftFalse = countEval(left, false);
                    int rightFalse = countEval(right, false);
                    subWays = leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            } else if (c == '|') { // required: anything but both false
                int leftFalse = countEval(left, false);
                int rightFalse = countEval(right, false);
                if (result) {
                    int leftTrue = countEval(left, true);
                    int rightTrue = countEval(right, true);
                    subWays = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                } else {
                    subWays = leftFalse * rightFalse;
                }
            }

            ways += subWays;
        }

        return ways;
    }

    public static void main(String[] args) {
        String expression = "0&0&0&1^1|0";
        boolean result = true;

        System.out.println(countEval(expression, result));
        System.out.println(count);
    }

}
