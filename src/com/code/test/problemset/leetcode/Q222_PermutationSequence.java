package com.code.test.problemset.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q222_PermutationSequence {
    public static void main(String[] args) {
        getPermutation(4, 9);
    }
    static public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        String s =  permutations(sb.toString(), "", k);
        return s;

    }

    static Set<String> permutationsList = new HashSet<>();

    public static String permutations(String s, String prefix, int k) {
        if (s.length() == 0) {
            permutationsList.add(prefix);
            if (permutationsList.size() == k)
                return prefix;

            return null;
        } else {
            for (int i = 0; i < s.length(); i++) {
                String rem = s.substring(0, i) + s.substring(i + 1);
                String perm = permutations(rem, prefix + s.charAt(i), k);
                if (perm != null)
                    return perm;
            }
        }
        return null;

    }


    public static class Solution1 {
        public String getPermutation(int n, int k) {
            int[] nums = new int[n + 1];
            int permcount = 1;
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1; // put 1, 2, 3 ... n into nums[]
                permcount *= (i + 1);
            }

            k--;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                permcount = permcount / (n - i);
                int idx = k / permcount;// the index that this position should
                // choose
                sb.append(nums[idx]);
                // left shift nums[] by one bit
                for (int j = idx; j < n - i; j++) {
                    nums[j] = nums[j + 1];
                }
                k %= permcount;
            }
            return sb.toString();
        }
    }

}
