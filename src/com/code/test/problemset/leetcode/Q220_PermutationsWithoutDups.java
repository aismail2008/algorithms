package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations without Dups:
 * Write a method to compute all permutations of a string of unique characters.
 * <p>
 * https://leetcode.com/problems/permutations/
 */
public class Q220_PermutationsWithoutDups {
    public List<String> perm = new ArrayList<>();

    public List<String> stringPermutations(String str) {
        if (str == null) {
            return new ArrayList<>();
        }
        if (str.length() <= 1) {
            List<String> res = new ArrayList<>();
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
        Q221_PermutationsWithDups nd = new Q221_PermutationsWithDups();
        nd.stringPermutations("aebc");
        System.out.println("=====Size : n! " + nd.perm.size() + "=======");
        for (String s : nd.perm) {
            System.out.println(s);
        }
        System.out.println("============");

        PermutationsNumber q = new PermutationsNumber();
        q.permute(new int[]{1, 2, 3});
        for (List<Integer> s : q.permArr) {
            s.forEach(i -> System.out.print(1 + ","));
            System.out.println();
        }
        System.out.println("============");
    }

    static class PermutationsNumber {
        public List<List<Integer>> permArr = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return permArr;
            }
            if (nums.length <= 1) {
                List<Integer> l = new ArrayList<>();
                Arrays.stream(nums).forEach(i -> l.add(i));
                permArr.add(l);
                return permArr;
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

                List<List<Integer>> list = subStringPermutations(rem);
                for (List<Integer> s : list) {
                    s.add(0, nums[i]);
                    permArr.add(s);
                }
            }

            return permArr;
        }

        public List<List<Integer>> subStringPermutations(int[] nums) {
            if (nums == null) {
                return new ArrayList<>();
            }
            if (nums.length <= 1) {
                List<Integer> l = new ArrayList<>();
                Arrays.stream(nums).forEach(i -> l.add(i));
                List<List<Integer>> res = new ArrayList<>();
                res.add(l);
                return res;
            }

            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int[] rem = new int[nums.length - 1];
                int h = 0;
                for (int j = 0; j < rem.length; j++) {
                    if (h == i) {
                        h++;
                    }
                    rem[j] = nums[h++];
                }

                List<List<Integer>> subList = subStringPermutations(rem);
                for (List<Integer> s : subList) {
                    s.add(0, nums[i]);
                    result.add(s);
                }
            }

            return result;
        }
    }
}
