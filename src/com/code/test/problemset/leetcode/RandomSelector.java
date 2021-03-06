package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSelector {

    public static void main(String[] args) {
        List<Integer> history = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
                33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 56, 64, 76, 78, 79, 87, 91,
                93, 95, 96, 98, 110, 111, 120, 125, 126, 127, 129, 138, 142, 144, 145, 148, 149, 152, 159,
                165, 173, 175, 179, 180, 185, 186, 190, 195, 196, 198, 201, 203, 204, 208, 210, 211, 219,
                220, 221, 222, 224, 241, 242, 245, 246, 267, 268, 274, 275, 276, 299, 300));
        System.out.println(history.size());
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
