package com.code.test.problemset.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Permutations with Duplicates: Write a method to compute all permutations of a string whose
 * characters are not necessarily unique.
 * The list of permutations should not have duplicates.
 * <p>
 * https://leetcode.com/problems/permutations-ii/
 */
public class Q221_PermutationsWithDups {
    public Set<String> perm = new HashSet<>();

    public Set<String> stringPermutations(String str) {
        if (str == null) {
            return new HashSet<>();
        }
        if (str.length() <= 1) {
            Set<String> res = new HashSet<>();
            res.add(str);
            return res;
        }

        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            List<String> list = subStringPermutations(rem);
            for (String s : list) {
                perm.add(str.charAt(i) + s);
            }
        }

        return perm;
    }

    public List<String> subStringPermutations(String str) {
        if (str == null) {
            return new ArrayList<>();
        }
        if (str.length() <= 1) {
            List<String> res = new ArrayList<>();
            res.add(str);
            return res;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            List<String> subList = subStringPermutations(rem);
            for (String s : subList) {
                result.add(str.charAt(i) + s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q221_PermutationsWithDups q = new Q221_PermutationsWithDups();
        q.stringPermutations("aebc");
        System.out.println("=====Size : n! " + q.perm.size() + "=======");
        for (String s : q.perm) {
            System.out.println(s);
        }
        System.out.println("============");

        PermutationsNumber qArr = new PermutationsNumber();
        qArr.permute(new int[]{1, 2, 2});
        for (List<Integer> s : qArr.permArr) {
            s.forEach(i -> System.out.print(1 + ","));
            System.out.println();
        }
        System.out.println("============");

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        Set<List<Integer>> set = new HashSet<>();
        set.add(a);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);

        set.add(b);
        set.size();
    }

    static class PermutationsNumber {
        public Set<List<Integer>> permArr = new HashSet<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                permArr.stream().collect(Collectors.toList());
            }
            if (nums.length <= 1) {
                List<Integer> l = new ArrayList<>();
                Arrays.stream(nums).forEach(i -> l.add(i));
                permArr.add(l);
                permArr.stream().collect(Collectors.toList());
            }

            for (int i = 0; i < nums.length; i++) {
                int[] rem = new int[nums.length - 1];
                int h = 0;
                for (int j = 0; j < rem.length; j++) {
                    if (h == i) {
                        h++;
                    }
                    rem[j] = nums[h++];
                }

                Set<List<Integer>> list = subStringPermutations(rem);
                for (List<Integer> s : list) {
                    s.add(0, nums[i]);
                    permArr.add(s);
                }
            }

            return permArr.stream().collect(Collectors.toList());
        }

        public Set<List<Integer>> subStringPermutations(int[] nums) {
            if (nums == null) {
                return new HashSet<>();
            }
            if (nums.length <= 1) {
                List<Integer> l = new ArrayList<>();
                Arrays.stream(nums).forEach(i -> l.add(i));
                Set<List<Integer>> res = new HashSet<>();
                res.add(l);
                return res;
            }

            Set<List<Integer>> result = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                int[] rem = new int[nums.length - 1];
                int h = 0;
                for (int j = 0; j < rem.length; j++) {
                    if (h == i) {
                        h++;
                    }
                    rem[j] = nums[h++];
                }

                Set<List<Integer>> subList = subStringPermutations(rem);
                for (List<Integer> s : subList) {
                    s.add(0, nums[i]);
                    result.add(s);
                }
            }

            return result;
        }
    }

}
