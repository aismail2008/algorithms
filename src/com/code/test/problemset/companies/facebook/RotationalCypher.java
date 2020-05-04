package com.code.test.problemset.companies.facebook;

/**
 * Rotational Cipher
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
 * Given a string and a rotation factor, return an encrypted string.
 * Signature
 * string rotationalCipher(string input, int rotationFactor)
 * Input
 * 1 <= |input| <= 1,000,000
 * 0 <= rotationFactor <= 1,000,000
 * Output
 * Return the result of rotating input a number of times equal to rotationFactor.
 * Example 1
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 * Example 1
 * input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39
 * output = nopqrstuvwxyzABCDEFGHIJKLM901234567
 */
public class RotationalCypher {

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int val = ch - '0';
                val = (val + rotationFactor) % 10;
                output.append((char) (val + '0'));
            } else if (ch >= 'A' && ch <= 'Z') {
                int val = ch - 'A';
                val = (val + rotationFactor) % 26;
                output.append((char) (val + 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                int val = ch - 'a';
                val = (val + rotationFactor) % 26;
                output.append((char) (val + 'a'));
            } else {
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        new RotationalCypher().rotationalCipher("Zebra-493?", 3);
    }

}
