package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse Vowels of a String
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 *
 *  https://leetcode.com/problems/reverse-vowels-of-a-string
 */
public class Q21_ReverseVowels {

    public String reverseVowels(String s) {
        List<Character> vowList = new ArrayList<Character>();
        vowList.add('a');
        vowList.add('e');
        vowList.add('i');
        vowList.add('o');
        vowList.add('u');
        vowList.add('A');
        vowList.add('E');
        vowList.add('I');
        vowList.add('O');
        vowList.add('U');

        char[] arr = s.toCharArray();

        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(!vowList.contains(arr[i])){
                i++;
                continue;
            }

            if(!vowList.contains(arr[j])){
                j--;
                continue;
            }

            char t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;

            i++;
            j--;
        }

        return new String(arr);
    }
}
