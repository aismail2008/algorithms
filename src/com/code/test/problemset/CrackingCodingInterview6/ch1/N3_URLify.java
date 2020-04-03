package com.code.test.problemset.CrackingCodingInterview6.ch1;

/**
 * URLify:
 *  Write a method to replace all spaces in a string with '%20'. You may assume that the string
 *  has sufficient space at the end to hold the additional characters, and that you are given the "true"
 *  length of the string. (Note: If implementing in Java, please use a character array so that you can
 *  perform this operation in place.)
 *  EXAMPLE
 *  Input: "Mr John Smith ", 13
 *  Output: "Mr%20John%20Smith"
 */
public class N3_URLify {

    /**
     * @param str
     * @param length zero based index
     */
    public static String replaceSpace(char[] str, int length) {
        int spacesCount = 0;
        int temp = length;
        for (int ch : str) {
            if (temp < 0)
                break;
            if (ch == 32)
                spacesCount++;
            temp--;
        }
        int newEnd = 2 * spacesCount + length;

        while (newEnd > 0) {
            if (str[length] == 32) {
                str[newEnd--] = '0';
                str[newEnd--] = '2';
                str[newEnd--] = '%';
                length--;
            } else {
                str[newEnd--] = str[length--];
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("Mr John Smith       ".toCharArray(), 13));
    }
}
