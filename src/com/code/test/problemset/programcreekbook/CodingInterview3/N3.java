package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aliismail on 08/11/2017.
 */
public class N3 {
//    Given two strings s and t, determine if they are isomorphic. Two strings are isomor- phic if the characters in s can be replaced to get t.
//    For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("egg", "ddd"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || (s.length() != t.length()))
            return false;
        if(s.length() == 0 && t.length() == 0)
            return true;

        Map<Character, Character> mStoT = new HashMap<>();
        Map<Character, Character> mTtoS = new HashMap<>();
        for(int i =0; i < s.length(); i++) {
            if (mStoT.containsKey(s.charAt(i))) {
                if (!mStoT.get(s.charAt(i)).equals(t.charAt(i)))
                    return false;
            } else {
                mStoT.put(s.charAt(i), t.charAt(i));
            }

            if (mTtoS.containsKey(t.charAt(i))) {
                if (!mTtoS.get(t.charAt(i)).equals(s.charAt(i)))
                    return false;
            } else {
                mTtoS.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
