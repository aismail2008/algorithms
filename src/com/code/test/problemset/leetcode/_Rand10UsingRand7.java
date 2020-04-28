package com.code.test.problemset.leetcode;

/**
 * Implement Rand10() Using Rand7()
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7,
 * write a function rand10 which generates a uniform random integer in the range 1 to 10.
 * <p>
 * Do NOT use system's Math.random().
 * <p>
 * rand7 is predefined.
 * Each testcase has one argument: n, the number of times that rand10 is called.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 * <p>
 * https://leetcode.com/problems/implement-rand10-using-rand7/
 */
public class _Rand10UsingRand7 {

    public int rand10() {
        while (true) {
            int num = 7 * (rand7() - 1) + rand7() - 1;
            if (num < 40) {
                return num % 10 + 1;
            }
        }
    }

    private static int rand7() {
        return (int) (Math.random() * 100) % 7;
    }

}
