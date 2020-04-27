package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _TopToal {

    /**
     * A precedence rule is given as "P>E", which means that letter "P" is followed directly by the letter "E". Write a function, given an array of precedence rules, that finds the word represented by the given rules.
     * <p>
     * Note: Each represented word contains a set of unique characters, i.e. the word does not contain duplicate letters.
     * <p>
     * Examples:
     * findWord(["P>E","E>R","R>U"]) // PERU
     * findWord(["I>N","A>I","P>A","S>P"]) // SPAIN
     */

    public static void main(String[] args) {
        findWord_2(new String[]{"P>E", "E>R", "R>U"}); // PERU
        System.out.println();
        findWord_2(new String[]{"I>N", "A>I", "P>A", "S>P"});// SPAIN
        System.out.println();
        findWord_2(new String[]{"U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"}); // HUNGARY
        System.out.println();
        findWord_2(new String[]{"I>F", "W>I", "S>W", "F>T"}); // SWIFT
        System.out.println();
        findWord_2(new String[]{"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"}); // PORTUGAL
        System.out.println();
        findWord_2(new String[]{"W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"});// SWITZERLAND

    }

    static String findWord_(String[] precedences) {
        ArrayList<String> prec = new ArrayList<>(Arrays.asList(precedences));
        String result = "";

        String p = prec.get(0);
        result = "" + p.charAt(0) + p.charAt(2);

        prec.remove(0);

        while (prec.size() > 0) {
            String nextP = null;
            for (int i = 0; i < prec.size(); i++) {
                if (prec.get(i).charAt(0) == result.charAt(result.length() - 1)) {
                    nextP = prec.get(i);
                    break;
                }
            }

            if (nextP != null) {
                result += nextP.charAt(2);
            } else {
                for (int i = 0; i < prec.size(); i++) {
                    if (prec.get(i).charAt(2) == result.charAt(0)) {
                        nextP = prec.get(i);
                        break;
                    }
                }

                if (nextP != null) {
                    result = nextP.charAt(0) + result;
                }
            }

            prec.remove(nextP);
        }

        return result;
    }

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
                int j = i + 'A';
                start = (char) j;
            } else if (chars[i] == 1 && end == ' ') {
                int j = i + 'A';
                end = (char) j;
            }
        }

        if(!map.containsKey(start)){
            char temp = start;
            start = end;
            end = temp;
        }
        String solution = "" + start;

        while (map.containsKey(start)){
            solution += map.get(start);
            start = map.get(start);
        }
        System.out.println(solution);
    }

    static void findWord(String[] stream) {
        List<String> input = Arrays.asList(stream);
        List<List<Character>> inputList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            List<Character> ss = new ArrayList<>();
            ss.add(input.get(i).charAt(0));
            ss.add(input.get(i).charAt(2));
            inputList.add(ss);
        }

        int i = 0;
        while (inputList.size() > 1) {
            Character ch = inputList.get(i).get(inputList.get(i).size() - 1);
            boolean foundBefore = false;
            //foundBefore
            for (int j = 0; j < i; j++) {
                if (inputList.get(j).get(0) == ch) {
                    inputList.get(i).remove(ch);
                    inputList.get(i).addAll(inputList.get(j));
                    inputList.remove(j);
                    foundBefore = true;
                    break;
                }
            }
            if (!foundBefore) {
                for (int j = i + 1; j < inputList.size(); j++) {
                    if (inputList.get(j).get(0) == ch) {
                        inputList.get(i).remove(ch);
                        inputList.get(i).addAll(inputList.get(j));
                        inputList.remove(j);
                        i--;
                        break;
                    }
                }
                i++;
            }
        }

        inputList.get(0).forEach(System.out::print);
    }
}
