package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

/**
 * Add Strings
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * https://leetcode.com/problems/add-strings/
 */
@Easy
public class _AddString {

    public static void main(String[] args) {
        addStrings_1("6", "501");
        int val = 18;
        int test = val / 10;
        System.out.println(test);
        val = 18;
        test = val % 10;
        System.out.println(test);
        new _AddString().addStrings("999", "82");
    }


    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = n1 + n2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();

    }

    public static String addStrings_1(String num1, String num2) {
        if(num1 == null || num1.isEmpty()){
            return num2;
        }
        if(num2 == null || num2.isEmpty()){
            return num1;
        }

        StringBuilder st = new StringBuilder("");
        int diff = Math.abs(num1.length() - num2.length());
        if (num1.length() > num2.length()) {
            //append zeros to num2
            for (int i = 0; i < diff; i++) {
                num2 = "0" + num2;
                System.out.println(i);
                System.out.println(num2);
            }
        }else if (num2.length() > num1.length()) {
            //append zeros to num2
            for (int i = 0; i < diff; i++) {
                num1 = "0" + num1;
            }
        }
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0 ; i--) {
            int val = num1.charAt(i) - '0' + num2.charAt(i) - '0' + carry;
            carry = val / 10;
            val = val % 10;
            st.append(val);
        }
        if (carry > 0) {
            st.append(carry);
        }
        return st.reverse().toString();
    }
}
