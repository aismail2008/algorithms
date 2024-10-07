package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

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
@Easy
public class Q21_ReverseVowels {

    public String reverseVowels(String s) {
        Set<Character> vowList = new HashSet<>();
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

            if(j <= i)
                break;

            char t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;

            i++;
            j--;
        }

        return new String(arr);
    }
}
