package com.code.test.problemset.leetcode.CodingInterview3;

/**
 * Created by aliismail on 12/11/2017.
 */
public class N15 {

//    Implement atoi to convert a string to an integer.
//            Hint: Carefully consider all possible input cases. If you want a challenge, please do
//    not see below and ask yourself what are the possible input cases

    public static void main(String[] args) {
        atoi("124");
    }

    public static int atoi(String s){
        if(s == null || s.isEmpty())
            return 0;

        int value = 0;
        int i = 0;
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        while(i < s.length()){
            value = value * 10 + (s.charAt(i) - '0');
        }

        System.out.println(value);
        return value;
    }
}
