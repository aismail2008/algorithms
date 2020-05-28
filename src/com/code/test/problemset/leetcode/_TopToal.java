package com.code.test.problemset.leetcode;

import java.util.*;

/**
 * A precedence rule is given as "P>E", which means that letter "P" is followed directly by the letter "E". Write a function, given an array of precedence rules, that finds the word represented by the given rules.
 * <p>
 * Note: Each represented word contains a set of unique characters, i.e. the word does not contain duplicate letters.
 * <p>
 * Examples:
 * findWord(["P>E","E>R","R>U"]) // PERU
 * findWord(["I>N","A>I","P>A","S>P"]) // SPAIN
 */
public class _TopToal {

    public static void main(String[] args) {
        findWord_O_N(new String[]{"P>E", "E>R", "R>U"}); // PERU
        System.out.println();
        findWord_O_N(new String[]{"I>N", "A>I", "P>A", "S>P"});// SPAIN
        System.out.println();
        findWord_O_N(new String[]{"U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"}); // HUNGARY
        System.out.println();
        findWord_O_N(new String[]{"I>F", "W>I", "S>W", "F>T"}); // SWIFT
        System.out.println();
        findWord_O_N(new String[]{"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"}); // PORTUGAL
        System.out.println();
        findWord_O_N(new String[]{"W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"});// SWITZERLAND

    }

    static String findWord_O_N(String[] precedences) {
        ArrayList<String> prec = new ArrayList<>(Arrays.asList(precedences));
        String result = "";

        String p = prec.get(0);
        result = "" + p.charAt(0) + p.charAt(2);

        prec.remove(0);

        while (prec.size() > 0) {
            for (int i = 0; i < prec.size(); i++) {
                int j = -1;
                if (prec.get(i).charAt(0) == result.charAt(result.length() - 1)) {
                    result += prec.get(i).charAt(2);
                    j = i;
                } else if (prec.get(i).charAt(2) == result.charAt(0)) {
                    result = prec.get(i).charAt(0) + result;
                    j = i;
                }

                if (j != -1) {
                    prec.remove(j);
                    i--;
                }
            }
        }
        return result;
    }


    // Find the chcaracter that appeared once only.
    // you should find only two (start and end)
    // chech which is not in the map then it's the end
    // start cnonecting from the map
    static void findWord_2(String[] input) {
        HashMap<Character, Character> map = new HashMap<>();
        int[] chars = new int[26];
        char start = ' ';
        char end = ' ';
        for (int i = 0; i < input.length; i++) {
            chars[Character.toUpperCase(input[i].charAt(0)) - 'A']++;
            chars[Character.toUpperCase(input[i].charAt(2)) - 'A']++;
            map.put(input[i].charAt(0), input[i].charAt(2));
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] == 1 && start == ' ') {
                start = (char) (i + 'A');
            } else if (chars[i] == 1 && end == ' ') {
                end = (char) (i + 'A');
            }
        }

        if (!map.containsKey(start)) {
            char temp = start;
            start = end;
            end = temp;
        }
        String solution = "" + start;

        while (map.containsKey(start)) {
            solution += map.get(start);
            start = map.get(start);
        }
        System.out.println(solution);
    }
}
