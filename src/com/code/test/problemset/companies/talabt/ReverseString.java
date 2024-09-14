package com.code.test.problemset.companies.talabt;

/*

     */
/**
 * Given a string of words, write a function to return the reverse the words in the same string.
 * E.g. “This is my world” should return “world my is This”
 * Contraints: Can’t use the split() function,
 * and you can’t use other data structure (stack, queue or array)
 *
 *
 * Space Complexity: O(n)
 * The space complexity is O(n) where n is the length of the input string.
 * This is because we create a char array of the same length as the input string
 * in the reverseString method.
 *
 * Time Complexity: O(n)
 * The time complexity is O(n) where n is the length of the input string.
 * We traverse the string twice:
 * 1. Once to reverse the entire string
 * 2. Once to reverse each word
 * Each reversal operation takes O(n/2) = O(n) time in the worst case.
 * Therefore, the overall time complexity remains O(n).
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Hello !");
    }

    public String reverseWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Reverse the entire string
        input = reverseString(input, 0, input.length() - 1);

        // Reverse each word
        int start = 0;
        for (int end = 0; end < input.length(); end++) {
            if (input.charAt(end) == ' ') {
                input = reverseString(input, start, end - 1);
                start = end + 1;
            }
        }

        // Reverse the last word
        input = reverseString(input, start, input.length() - 1);

        return input;
    }

    private String reverseString(String str, int start, int end) {
        char[] charArray = str.toCharArray();
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }
}
