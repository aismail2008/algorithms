package com.code.test.problemset.companies.Pramp;

import com.code.test.problemset.leetcode._DeleteOperationTwoStrings;

/**
 * Deletion Distance
 * The deletion distance of two strings is the minimum number of characters you need to delete in the two strings in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:
 * <p>
 * By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 * We cannot get the same string from both strings by deleting 2 letters or fewer.
 * Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion distance between them. Explain how your function works, and analyze its time and space complexities.
 * <p>
 * Examples:
 * <p>
 * input:  str1 = "dog", str2 = "frog"
 * output: 3
 * <p>
 * input:  str1 = "some", str2 = "some"
 * output: 0
 * <p>
 * input:  str1 = "some", str2 = "thing"
 * output: 9
 * <p>
 * input:  str1 = "", str2 = ""
 * output: 0
 * Constraints:
 * <p>
 * [input] string str1
 * [input] string str2
 * [output] integer
 * <p>
 * <p>
 * <p>
 * https://www.pramp.com/challenge/61ojWAjLJbhob2nP2q1O
 *
 */
public class DeletionDistance {

    public static void main(String[] args) {
        new _DeleteOperationTwoStrings();
    }
}
