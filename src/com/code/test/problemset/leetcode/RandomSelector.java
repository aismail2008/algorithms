package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSelector {

    public static void main(String[] args) {
        List<Integer> history = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 37, 44, 82, 91, 93, 98, 110, 111, 120,
                129, 125, 126, 138, 142, 144, 145, 148, 149, 152, 159, 171, 175, 187, 190, 195,
                196, 201, 203, 204, 210, 211, 219, 220, 221, 224, 241, 242, 245, 246, 247, 248, 252,
                253, 267, 276, 299, 300));
            //  - 97 - 235- 236
        int[] selected = new int[7];
        int i = 0;
        while (history.size() < 300) {
            int s = ThreadLocalRandom.current().nextInt(1, 300);
            if (Collections.binarySearch(history, s) < 0) {
                selected[i++] = s;
                history.add(s);
                Collections.sort(history);

                if (i == 7) {
                    Arrays.stream(selected).forEach(n -> System.out.print(n + " - "));
                    System.out.println("");
                    i = 0;
                }
            }
        }
    }
}
