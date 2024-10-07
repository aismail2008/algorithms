package com.code.test;

import com.code.test.tdd.Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 Implement a function that simulates the T9 predictive text
 input method found on classic mobile phones.
 Your function should take a string of numbers as input and
 return a list of possible words that the numeric sequence
 could represent.

 Input: A string of digits (2-9), e.g., "43556".
 Output: A list of strings, each representing a possible word,
 e.g., ["hello", "gekko"].

 Keyboard Layout:
1  2 (abc) 3 (def)
4 (ghi) 5 (jkl) 6 (mno)
7 (pqrs) 8 (tuv) 9 (wxyz)
*  #

 Examples:
 Dictionary: cat, bat, hat, good, gone, home, hello, test

 1. Input: "228"
 Output: ["bat", "cat"]

 2. Input: "4663"
 Output: ["gone", "good", "home"]

 3. Input: "43556"
 Output: ["hello”]
 */
public class Problem {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //assertEquals(1, calculator.subtract(3, 2));
//        solve("43556").stream().forEach(System.out::println);
//        solve("4663").stream().forEach(System.out::println);
//        solve("228").stream().forEach(System.out::println);
        solve("").stream().forEach(System.out::println);
    }
    // space
    // Avg: O(m + N) where m: generated combinations, N is recursive calls/stack
    // worst: (k^n): if we have all combinations are valid, m will eventually be around k^n. K = 3 then it will be O(3^n). Whwere n is length

    // time compelxity:
    /*
        k: possible choices.
        n: length/depth of input
        m: number of generated combinations. Filtering is O(m)
        O( (k^n) + m)
        worst: O(k^n)
     */

    public static List<String> solve(String digits){
        Set<String> dictionary= new HashSet<>();
        // fill in dictionary
        fillDictionary(dictionary);
        //set in separate method for initializing mapping
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();
        getPossibleCombinations("", digits, mapping, combinations);
        return combinations.stream().filter(dictionary::contains).collect(Collectors.toList());
    }

    // we can use memory with generated prev. digits and check in begining to save time of re-processing
        // this can be converted to stack
    private static void getPossibleCombinations(String combination, String nextDigits, String[] mapping, List<String> combinations) {
        if(nextDigits.length() == 0){
            combinations.add(combination);
        }else{
            String letters = mapping[nextDigits.charAt(0) - '0'];
            for(char letter: letters.toCharArray()){
                getPossibleCombinations(combination+letter, nextDigits.substring(1), mapping, combinations);
            }
        }
    }

    private static void fillDictionary(Set dictionary){
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("hat");
        dictionary.add("good");
        dictionary.add("gone");
        dictionary.add("home");
        dictionary.add("hello");
        dictionary.add("test");
    }

}