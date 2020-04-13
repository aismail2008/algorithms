package com.code.test.problemset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) throws IOException {
        //		Reading input using this
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while (s != null && !s.equalsIgnoreCase("")) {
            System.out.println("This is : " + s);
            s = br.readLine();

            System.out.println("Permutations are :");
            permutationIterative(s).stream().forEach(System.out::println);
            System.out.println("Permutations are :");
            permutations(s).stream().forEach(System.out::println);
        }
    }
    //----------------------1st

    public static List<String> permutations(String s) {
        permutations(s, "");
        return permutationsList.stream().collect(Collectors.toList());
    }

    static Set<String> permutationsList = new HashSet<>();

    public static void permutations(String s, String prefix) {
        if (s.length() == 0) {
            permutationsList.add(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String rem = s.substring(0, i) + s.substring(i + 1);
                permutations(rem, prefix + s.charAt(i));
            }
        }
    }

    //----------------------2st
    public static class Node {
        String prefix;
        String remain;
    }

    public static List<String> permutationIterative(String s) {
        Set<String> solutions = new HashSet<>();
        Node n = new Node();
        n.prefix = "";
        n.remain = s;
        Deque<Node> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();

            if (n.remain.length() == 0) {
                solutions.add(n.prefix);
            } else {
                for (int i = n.remain.length() - 1; i >= 0; i--) {
                    Node child = new Node();
                    child.prefix = n.prefix + n.remain.charAt(i);
                    child.remain = n.remain.substring(0, i) + n.remain.substring(i + 1);
                    q.addFirst(child);
                }
            }
        }
        return solutions.stream().collect(Collectors.toList());
    }

    ////////////////////////// ??///////////////////////////
    public static int solution(int n) {
        int max = (int) Math.ceil(Math.sqrt(n));

        Set<Integer> sortedSet = new TreeSet<>();
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
