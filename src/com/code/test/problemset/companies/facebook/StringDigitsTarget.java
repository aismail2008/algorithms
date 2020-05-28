package com.code.test.problemset.companies.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * FB: Software Engineer Interview San Francisco, CA (US)
 *
 * Given a string composed of digits, find all possible
 * combinations of adding/subtracting any contiguous combination
 * of the digits that result in a pre-defined target number.
 */
public class StringDigitsTarget {

    /*
    Idea is we have two buckets of numbers. one is for adding  and other one will be minced
    so Set1 - Set2 = Target
    > for each item either put it on this set and check or on other set and check
    once you are run out of all numbers check the difference if went to that target or not
     */
    static List<String> sol = new ArrayList<>();

    static public void findTarget(List<Integer> setAdd, List<Integer> setMince, String input, int i, int target){
        if(i >= input.length()){
            if (setAdd.stream().reduce(Integer::sum).orElse(0) -
                    setMince.stream().reduce(Integer::sum).orElse(0) == target){
                StringBuilder adds = new StringBuilder("");
                setAdd.forEach(n -> adds.append(n + "+"));

                StringBuilder minus = new StringBuilder("");
                setMince.forEach(n -> minus.append("-" + n));

                sol.add(adds.toString().substring(0, adds.length() - 1) + minus.toString());
            }
            return;
        }

        int val = Integer.valueOf(input.charAt(i) - '0');

        List setAddOr = new ArrayList(setAdd);
        setAdd.add(val);
        findTarget(setAdd, setMince, input, i+1, target);

        List setMinceAdd = new ArrayList(setMince);
        setMinceAdd.add(val);
        findTarget(setAddOr, setMinceAdd, input, i+1, target);
    }

    public static void main(String[] args) {
        findTarget(new ArrayList<>(), new ArrayList<>(), "1234", 0, 0);
        sol.stream().forEach(System.out::println);
    }
}
