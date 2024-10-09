package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.HashMap;

/**
 * Two Sum III 2 sums – Data structure design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 *
 * add(1);
 * add(3);
 * add(5);
 * find(4) -> true
 * find(7) -> false
 *
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 */
@Medium
public class Q29_TwoSumsIII {
    private HashMap<Integer, Integer> elements = new HashMap<>();

    public void add(int number) {
        elements.put(number, elements.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     * @param value
     * @return
     */
    public boolean find(int value) {
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
