package com.code.test.problemset.companies.facebook;

/**
 * 
 * Adding two string numbers using base
 */
public class AddingStringNumbers {
    public static void main(String[] args) {
        //SolutionA solutionA = new SolutionA();
        //solutionA.solve();
    }
    public String solve(String a, String b, int base) {

        String result = "";
        int s = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || s == 1) {

            s += (i >= 0) ? a.charAt(i) - '0' : 0;
            s += (j >= 0) ? b.charAt(j) - '0' : 0;

            result = (char) (s % base + '0') + result;
            s = s / base;

            i--;
            j--;
        }
        return result;
    }
}
