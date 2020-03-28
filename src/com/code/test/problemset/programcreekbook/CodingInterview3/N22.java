package com.code.test.problemset.programcreekbook.CodingInterview3;

/**
 * Created by aliismail on 27/11/2017.
 */
public class N22 {
    public static boolean isValidPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(str));
    }
}
