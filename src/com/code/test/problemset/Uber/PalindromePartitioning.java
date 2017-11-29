package com.code.test.problemset.Uber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aliismail on 27/11/2017.
 */
public class PalindromePartitioning {

    //    Given a string s, partition s such that every substring of the partition is a palindrome.
//
//    Return all possible palindrome partitioning of s.
//
//    For example, given s = "aab",
//    Return["aa","b"], ["a","a","b"]
    static Set<List<String>> allResult = new HashSet<>();

    public static void permutation(List<String> curr, String remain) {
        if (remain.length() <= 1) {
            curr.add(remain);
            allResult.add(curr);
            return;
        }
        if(remain == null || remain.length() ==0){
            allResult.add(curr);
            return;
        }

        for (int i = 0; i < remain.length(); i++) {
            String pal = remain.substring(0, i +1);
            if(new StringBuilder(pal).reverse().toString().equals(pal)){
                List<String> send = new ArrayList<>(curr);
                send.add(pal);
                permutation(send, remain.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {
        permutation(new ArrayList<>(), "aab");
        List<List<String>> s = new ArrayList();
        allResult.forEach(l -> s.add(l));
    }
}
