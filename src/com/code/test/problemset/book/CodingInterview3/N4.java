package com.code.test.problemset.book.CodingInterview3;

import com.code.test.problemset.graph.Node;
import com.code.test.problemset.graph.State;

import java.util.*;

/**
 * Created by aliismail on 08/11/2017.
 */
public class N4 {
    static HashSet<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        dictionary.add("hot");
        dictionary.add("dot");
        dictionary.add("dog");
        dictionary.add("lot");
        dictionary.add("log");

        wordLadder("cog", "hit", new LinkedHashSet<>()).forEach(System.out::println);
    }

    public static Set<String> wordLadder(String s, String t, Set<String> path) {
        if (s.equals(t) || diff(s, t)) {
            path.add(t);
            return path;
        }

        Iterator<String> iterator = dictionary.iterator();
        Set<String> optimalPath = new LinkedHashSet<>();
        while (iterator.hasNext()) {
            String h = iterator.next();
            if (!path.contains(h) && diff(h, s)) {
                path.add(h);
                Set<String> rs = wordLadder(h, t, path);
                if (rs != null && (optimalPath.size() == 0 || rs.size() < optimalPath.size())) {
                    optimalPath = new LinkedHashSet<>(rs);
                }
                path.remove(h);
            }
        }
        if (optimalPath.isEmpty())
            return null;

        return optimalPath;
    }

    public static boolean diff(String a, String b) {
        if (a.length() != b.length())
            return false;
        int count = 0;
        for (int i = 0; i < b.length() && count <= 1; i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return count > 1 ? false : true;
    }

//BFS and when visiting child build his children from dictionary
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0)
            return 0;
        dict.add(end);
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        wordQueue.add(start);
        distanceQueue.add(1);
        //track the shortest path
        int result = Integer.MAX_VALUE;
        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();
            if (currWord.equals(end)) {
                result = Math.min(result, currDistance);
            }
            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        if (result < Integer.MAX_VALUE)
            return result;
        else
            return 0;
    }
}
