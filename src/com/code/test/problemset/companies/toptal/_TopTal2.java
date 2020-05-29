package com.code.test.problemset.companies.toptal;

import java.util.Arrays;

public class _TopTal2 {

    static class Problema {
        /*
            Task Description
            Write a program that will correct an input string to use proper capitalization and spacing.
            Allowed punctuations are the period ( . ), question mark ( ? ), and exclamation ( ! ).
            Make sure that single space always follows commas ( , ), colons ( : ), semicolons ( ; ) and all other punctuation.
            The input string will be valid English sentences.
            input:
            capitalizeString("first, solve the problem.then, write the code.") // "First, solve the problem. Then, write the code."

            capitalizeString("this is a test... and another test.") // "This is a test... And another test."
        */
        public static void main(String[] args) {
            capitalizeString("hello. how are you today? great! i'm fine too.");
            capitalizeString("do.or do not.   there is no try.");
            capitalizeString("the house is on fire!?run!");
            capitalizeString("the conference has people who have come from Moscow,Idaho;Paris,Texas;London,Ohio; and other places as well.");
            capitalizeString("first, solve the problem.then, write the code.");
            capitalizeString("this is a test... and another test.");
        }

        public static String capitalizeString(String input) {
            input = input.replaceAll("\\.", " . ").
                    replaceAll("\\?", " ? ").
                    replaceAll("\\,", " , ").
                    replaceAll("\\!", " ! ").
                    replaceAll("\\;", " ; ");

            String output = new String();
            String[] s = input.split(" ");
            boolean cap = true;
            for (String t : s) {
                if (t.equals(" ") || t.length() == 0)
                    continue;
                if (cap)
                    output += t.toUpperCase().charAt(0) + "" + (t.length() > 1 ? t.substring(1) : "");
                else
                    output += t;

                cap = false;

                if (output.charAt(output.length() - 1) == '.' || output.charAt(output.length() - 1) == '!'
                        || output.charAt(output.length() - 1) == '?')
                    cap = true;

                output += " ";
            }
            output = output.replaceAll(" \\.", ".")
                    .replaceAll(" \\,", ",")
                    .replaceAll(" \\!", "!")
                    .replaceAll(" \\?", "?")
                    .replaceAll(" \\;", ";");
            System.out.println(output.trim());
            return output.trim();
        }

    }


    static class Problem2 {
/*
A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1.
Your task is to write a program that will be used in a vending machine to return change.
Assume that the vending machine will always want to return the least number of coins or notes.
Devise a function getChange(M, P) where M is how much money was inserted into the machine and P the price of the item selected,
that returns an array of integers representing the number of each denomination to return.

Example:
getChange(5, 0.99) // should return [1,0,0,0,0,4]
 */

        public static int[] getChange(double m, double p) {
            int dollars = (int) (m - p);
            Double change = m - p - dollars;

            int amont = (int) Math.round(change * 100);
            int[] result = new int[6];
            result[5] = dollars;


            int div = amont / 50;
            result[4] = div;
            amont = amont - div * 50;

            div = amont / 25;
            result[3] = div;
            amont = amont - div * 25;

            div = amont / 10;
            result[2] = div;
            amont = amont - div * 10;

            div = amont / 5;
            result[1] = div;
            amont = amont - div * 5;

            div = amont / 1;
            result[0] = div;
            amont = amont - div * 1;

            System.out.println(Arrays.toString(result));
            return result;
        }

        public static void main(String[] args) {
            getChange(3.14, 1.99); // should return [0,1,1,0,0,1]
            getChange(4, 3.14); // should return [1,0,1,1,1,0]
            getChange(0.45, 0.34); // should return [1,0,1,0,0,0]
            //getChange(5, 0.99);
        }
    }
}
