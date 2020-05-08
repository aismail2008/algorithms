package com.code.test.problemset.companies.Pramp;


/**
 * Sentence Reverse
 * You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.
 * <p>
 * Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.
 * <p>
 * Explain your solution and analyze its time and space complexities.
 * <p>
 * Example:
 * <p>
 * input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
 * 'm', 'a', 'k', 'e', 's', '  ',
 * 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]
 * <p>
 * output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
 * 'm', 'a', 'k', 'e', 's', '  ',
 * 'p', 'e', 'r', 'f', 'e', 'c', 't' ]
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.character arr
 * <p>
 * 0 ≤ arr.length ≤ 100
 * [output] array.character
 * <p>
 * O(n) in time
 * O(1) in space
 */
public class SentenceReverse {
    static char[] reverseWords(char[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ')
                continue;

            int j = i;
            while (j < arr.length && arr[j] != ' ')
                j++;

            swap(arr, i, j - 1);
            i = j;
        }
        swap(arr, 0, arr.length - 1);
        return arr;
    }

    static void swap(char[] arr, int i, int j) {
        while (i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String ip = "1..23.4";
        String[] arr = ip.split("\\.");
        System.out.println(arr.length);
    }
}
