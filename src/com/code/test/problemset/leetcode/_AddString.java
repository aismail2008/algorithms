package com.code.test.problemset.leetcode;

/**
 *  Add Strings
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * https://leetcode.com/problems/add-strings/
 */
public class _AddString {

    public static void main(String[] args){
        int val = 18;
        int test =  val / 10;
        System.out.println(test);
        val = 18;
        test =  val % 10;
        System.out.println(test);
        new _AddString().addStrings("999", "82");
    }

    public String addStrings(String num1, String num2) {
        StringBuilder st = new StringBuilder("");
        int i =  num1.length() - 1;
        int j =  num2.length() - 1;
        int carry = 0;
        while(i >= 0 && j >= 0){
            int val = num1.charAt(i--) - '0' +
                    num2.charAt(j--) - '0' + carry;
            carry = val / 10;
            val = val % 10;
            st.append(val);
        }

        while(i >= 0){
            int val = num1.charAt(i--) - '0' + carry;
            carry = val / 10;
            val = val % 10;
            st.append(val);
        }

        while(j >= 0){
            int val = num2.charAt(j--) - '0' + carry;
            carry = val / 10;
            val = val % 10;
            st.append(val);
        }
        if(carry > 0){
            st.append(carry);
        }

        return st.reverse().toString();

    }
}
