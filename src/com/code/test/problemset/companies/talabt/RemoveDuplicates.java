package com.booking.dropwizardapp;

import java.util.HashMap;

public class RemoveDuplicates {


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
        String[] splitWords = input.split(" ");
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
