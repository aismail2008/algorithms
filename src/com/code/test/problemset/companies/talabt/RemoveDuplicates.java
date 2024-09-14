package com.code.test.problemset.companies.talabt;

import java.util.HashMap;

public class RemoveDuplicates {

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Convert input to lowercase and split into words
        // "\\s+" is a regex that matches one or more whitespace characters
        // This splits the string on any sequence of spaces, tabs, or newlines
        String[] words = input.toLowerCase().split("\\s+");
        HashMap<String, Integer> wordCount = new HashMap<>();
        StringBuilder result = new StringBuilder();

        // Count occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Build the result string
        for (String word : words) {
            if (wordCount.get(word) > 1) {
                result.append(word).append(" ");
                wordCount.put(word, wordCount.get(word) - 1);
            } else if (wordCount.get(word) == 1) {
                result.append(word).append(" ");
                wordCount.remove(word);
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("Hello Talabat!");
    }
    /*
    string _myString = “my name is Ali Ismail Ali ALI and I am am conducting conducting interview”;
    conducting 2

    ..


    sb = my name name Ali Ismail Ismail and am conducting interview
     */

    public static String removeLastDuplicate(String input) {
        if(input == null || input.length() == 0){

        }
        input = input.toLowerCase();

        HashMap<String, Integer> duplicates = new HashMap<>();
        // Convert input to lowercase and split into words
        // "\\s+" is a regex that matches one or more whitespace characters
        // This splits the string on any sequence of spaces, tabs, or newlines
        String[] splitWords = input.split("\\s");
        for (String word : splitWords) {
            duplicates.put(word, duplicates.getOrDefault(word, 0) + 1);
        }

        removeNonDupicate(duplicates);

        if(duplicates.size() == 0){
            return input;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : splitWords) {
            if (!duplicates.containsKey(word)) {
                sb.append(word + " ");
            }else if (duplicates.get(word) > 1) {
                sb.append(word + " ");
                duplicates.put(word, duplicates.get(word) - 1);
            }else{
                duplicates.remove(word);
            }
        }

        return sb.toString().trim();
    }

    private static void removeNonDupicate(HashMap<String, Integer> duplicates) {
    }
}
