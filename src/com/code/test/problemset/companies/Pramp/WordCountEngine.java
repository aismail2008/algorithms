package com.code.test.problemset.companies.Pramp;

import java.util.*;

/**
 * Word Count Engine
 * Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.
 *
 * The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.
 *
 * Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.
 *
 * Examples:
 *
 * input:  document = "Practice makes perfect. you'll only
 *                     get Perfect by practice. just practice!"
 *
 * output: [ ["practice", "3"], ["perfect", "2"],
 *           ["makes", "1"], ["youll", "1"], ["only", "1"],
 *           ["get", "1"], ["by", "1"], ["just", "1"] ]
 * Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The expected output will simply be an array of string arrays.
 *
 * Constraints:
 *
 * [time limit] 5000ms
 * [input] string document
 * [output] array.array.string
 *
 * Similar to {@link com.code.test.problemset.leetcode.MostCommonWord}
 * */
public class WordCountEngine {

    /*
      document full words
      return list words with occurance in that doument with descending order of occurance
      // LinkedHasMap m
      // iterate over the doucmen
      // update the occurcne num of each word
      // get a list of HasMap values.
      // order them in descding order
    */
    static String[][] wordCountEngine(String document) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        document = document.replaceAll("[^a-zA-Z\\s]", "");
        String[] s = document.toLowerCase().split(" ");
        for (String w : s) {
            if(w == " ")
                continue;
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        List<String[]> output = new ArrayList<>();
        Iterator<String> entryIter = map.keySet().iterator();
        while (entryIter.hasNext()) {
            String word = entryIter.next();
            output.add(new String[]{word, "" + map.get(word)});
        }
        Collections.sort(output, (o1, o2) -> Integer.valueOf(o2[1]).compareTo(Integer.valueOf(o1[1])));

        String[][] res = new String[output.size()][];
        output.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(wordCountEngine("Every book is a quotation; and every house is a " +
                "quotation out of all forests, and mines, and stone quarries; " +
                "and every man is a quotation from all his ancestors. ")).forEach( s -> System.out.println(s[0] +","+  s[1]) );
        wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!");
    }
}