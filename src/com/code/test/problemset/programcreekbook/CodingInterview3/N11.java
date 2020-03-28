package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.HashMap;

/**
 * Created by aliismail on 12/11/2017.
 */
public class N11 {
//    Design and implement a TwoSum class. It should support the following operations: add and find.
//            add - Add the number to an internal data structure. find - Find if there exists any pair of numbers which sum is equal to the value.
//            For example,
//    add(1);
//    add(3);
//    add(5);
//    find(4) -> true
//    find(7) -> false

    private static HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        add(1);
        add(3);
        add(5);
        find(4);
        find(7);
    }

    public static void add(int number) {
        if (elements.containsKey(number)) {
            elements.put(number, elements.get(number) + 1);
        } else {
            elements.put(number, 1);
        }
    }

    public static boolean find(int value) {
        for (Integer i : elements.keySet()) {
            int target = value - i;
            if (elements.containsKey(target)) {
                if (i == target && elements.get(target) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}