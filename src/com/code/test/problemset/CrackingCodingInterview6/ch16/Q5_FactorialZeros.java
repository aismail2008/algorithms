package com.code.test.problemset.CrackingCodingInterview6.ch16;

/**
 * FactorialZeros:
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 */
public class Q5_FactorialZeros {
    public static void main(String[] args) {
        new Q5_FactorialZeros().countZeros(19);
        new Q5_FactorialZeros().countFactZeros(19);
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return -1; // Error
        }
    }

    // 19! can't fit into Integer bad solution
    public int countZeros(int n) {
        int fac = n;
        n--;
        while (n > 0) {
            fac *= n--;
        }

        String s = new String("" + fac);
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 0)
                cnt++;
            else break;
        }
        return cnt;
    }

    //----------------------------OR------------------------
    public static int countFactZeros(int num) {
        int count = 0;
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers");
            return 0;
        }
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }

    //-------------------****OR***---------------------------
    public static int factorsOf5(int i) {
        int count = 0;
        while (i % 5 == 0) {
            count++;
            i /= 5;
        }
        return count;
    }

    public static int countFactZeros_(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i);
        }
        return count;
    }

}
