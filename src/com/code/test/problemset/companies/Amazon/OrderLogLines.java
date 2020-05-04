package com.code.test.problemset.companies.Amazon;

import java.util.*;
import java.util.regex.Pattern;

//
// Worst Time complexity : O(Nlog(w) where N is the number of total lines and for each item inserting in PriorityQueue takes log(n) of time./
// *
// * Space complexity : O(N) where n is number of log lines. [since numberLines list  will contains only numeric lines and both Priority queue + wordlines list will contain max of total word lines
public class OrderLogLines {
    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<String> numberLines = new ArrayList<>();
        List<String> wordLines = new ArrayList<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue((o1, o2) -> {
            String s1 = o1.toString();
            s1 = s1.substring(s1.indexOf(" ") + 1).toLowerCase();

            String s2 = o2.toString();
            s2 = s2.substring(s2.indexOf(" ") + 1).toLowerCase();
            if(s1.equalsIgnoreCase(s2)){
                return o1.toString().substring(0, o1.toString().indexOf(" ")).compareTo(o2.toString().substring(0, o2.toString().indexOf(" ")));
            }
            return s1.compareTo(s2);
        });
        for (String line : logLines) {
            if (isNumeric(line.split(" ")[1])) {
                numberLines.add(line);
            } else {
                priorityQueue.offer(line);
            }
        }
        while (!priorityQueue.isEmpty()){
            wordLines.add(priorityQueue.poll());
        }
        wordLines.addAll(numberLines);
        return wordLines;
    }

    private static Pattern pattern = Pattern.compile("[0-9]+");

    static public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
