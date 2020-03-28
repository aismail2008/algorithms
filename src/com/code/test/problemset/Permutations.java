package com.code.test.problemset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Permutations {

    public static void main(String[] args) throws IOException {
        //		Reading input using this
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while (s != null && !s.equalsIgnoreCase("")) {
            System.out.println("This is : " + s);
            s = br.readLine();

            System.out.println("Permutations are :");
            permutationIterative(s);
        }
    }
    //----------------------1st

    public static void permutations(String s){
        permutations(s,"");
    }

    public static void permutations(String s, String prefix){
        if(s.length() == 0){
            System.out.println(prefix);
        }else{
            for (int i = 0; i < s.length(); i++) {
                String rem = s.substring(0, i) + s.substring(i+1);
                permutations(rem, prefix + s.charAt(i));
            }
        }
    }
    //----------------------2st
    public static class Node {
        String prefix;
        String remain;
    }

    public static Deque<Node> permutationIterative(String s) {
        String sol = "";
        Node n = new Node();
        n.prefix = "";
        n.remain = s;
        Deque<Node> q = new LinkedList<Node>();
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            if (n.remain.length() == 1) {
                if ((n.prefix + n.remain).compareTo(s) > 0)
                    if (sol.equals("") || (n.prefix + n.remain).compareTo(s) < 0)
                        sol = n.prefix + n.remain;
            } else {
                for (int i = n.remain.length() - 1; i >= 0; i--) {
                    Node child = new Node();
                    child.prefix = n.prefix + n.remain.substring(i, i + 1);
                    child.remain = n.remain.substring(0, i) + n.remain.substring(i + 1, n.remain.length());
                    q.addFirst(child);
                }
            }
        }
        return q;
    }
    //----------------------3nd
    private static String permutation(String prefix, String str, String solution, String orginal) {
        int n = str.length();
        if (n == 0) {
            if (prefix.compareTo(orginal) > 0) {
                if (solution.equals("") || prefix.compareTo(solution) < 0)
                    solution = prefix;
            }
        } else {
            for (int i = 0; i < n; i++)
                if (((prefix + str.charAt(i)).compareTo(orginal.substring(0, prefix.length() + 1)) > 0))
                    solution = permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), solution, orginal);
        }

        return solution;
    }

    public static int solution(int n) {
        int max = (int) Math.ceil(Math.sqrt(n));

        Set<Integer> sortedSet = new TreeSet<Integer>();
        for (int p = 0; p < n / 2; p++) {
            for (int q = 0; q < n / 2; q++) {
                sortedSet.add((int) (Math.pow(2, p) * Math.pow(3, q)));
            }
        }

        Object[] arrObject = sortedSet.toArray();
        for (int i = 0; i < arrObject.length; i++)
            System.out.println(arrObject[i]);

        return (Integer) sortedSet.toArray()[50];
    }
}
