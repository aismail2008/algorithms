package com.code.test.problemset.companies.talabt;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {


    public static void main(String[] args) {
        System.out.println("Hello !");
    }

    /*
     Q3: Given a string of words, write a function to return the reverse the words in the same string. E.g. “This is my world” should return “world my is This”
    Contraints: Can’t use the split() function, and you can’t use other data structure (stack, queue or array) 

     */

    public String reverse(String input) {
        // “This is my world”    =>   "sihT si ym dlrow" ==> "world my is this"
        //  S   E
        //
        // let start = 0;
        // repeat
        //    let end = index of first space after start;
        //    call method to revers chars in the range
        //    start = End + 1
        //
        // revers from 0, end of whole string
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ')
                continue;

            int j = i;
            while (j < input.length() && input.charAt(j) != ' ')
                j++;

            input = swap(input, i, j - 1);

            i = j;
        }
        input = swap(input, 0, input.length() - 1);
        return input;
    }

    private String swap(String input, int i, int j) {
        // ..
        return input;
    }

    /*
    Q2: There is a queue for the self-checkout tills at the supermarket.
    Your task is write a function to calculate the total time required for all the customers to check out!
    input:
    ======
    customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
    n: a positive integer, the number of checkout tills.
    output:
    =======
    The function should return an integer, the total time required.
    queueTime([5,3,4], 1) // should return 12, because when there is 1 till, the total time is just the sum of the times
    queueTime([12,2,1,4, 3], 2) // should return 12, because here n=2 and the 2nd, 3rd, 4th and 5th people in the queue finish before the 1st person has finished.
     */

    public static int totalProcessingTime(int[] arr, int tills) {
        // PQ => 12, 2                   (2 + 1 + 4 + 3 + 2) = 12
        // pq =>
        // pq will be initialized with # tills
        // fill completely pq  (pushing n)
        // remove min and then decrement all remaining with it's value and if less than or zero then don't push back ==> increment total time;
        // repeat until you reach end of queue.
        if (tills >= arr.length) {
            return Arrays.stream(arr).max().getAsInt();
        }

        // [12,2,1,4, 3], 2
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        int totalTime = 0;
        while (i < arr.length || pq.size() > 0) {
            while (i < arr.length && pq.size() < tills) {
                pq.offer(arr[i++]);
            }
            // pq : 12, 2
            while (!pq.isEmpty()) {
                totalTime += pq.peek(); // 2
                int dec = pq.remove(); //2
                //pq :  12
                PriorityQueue<Integer> tmp = new PriorityQueue<>();
                while (!pq.isEmpty()) {
                    int newVal = pq.poll() - dec; // 10
                    if (newVal > 0) {
                        tmp.offer(newVal);
                    }
                }
                pq = tmp;
            }
        }

        return totalTime;
    }

    // OR this simpler one
    int queueTime(int[] customers, int n) {
        int[] arr = new int[customers.length];

        for (var i = 0; i < customers.length; i++) {
            var idx = indexOfMin(arr);
            arr[idx] += customers[i];
        }

        return Arrays.stream(arr).max().getAsInt();
    }

    private int indexOfMin(int[] arr) {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[min])
                min = i;
        }
        return min;
    }

    /*
   Q1: In a small town the population is p0 = 1000 at the beginning of a year.
   The population regularly increases by 2 percent per year and moreover 50 new inhabitants per year come to live in the town.
   How many years does the town need to see its population greater or equal to p = 1200 inhabitants?
   More generally, given parameters:
   p0 = initial population, positive integer
   percent = percentage increases, positive or null (Yearly)
   aug = inhabitants coming or leaving each year, integer
   p = target population to surpass, positive integer

   the function nb_year should return n number of entire years needed to get a population greater or equal to p.

   Examples:
   nb_year(1500, 5, 100, 5000) -> 15
   count = 0;
   while(pop < tar){
       pop = pop + pop * perc / 100 + annual
       count++;
   }
   return count;

   nb_year(1500000, 2.5, 10000, 2000000) -> 10 


    */
    public static long countYear(long population, float percent, int annualIncrease, long targetPopulation) {

        int numberOfYears = 0;

        while (population < targetPopulation) {
            population += (population * percent / 100) + annualIncrease;
            numberOfYears++;
        }

        return numberOfYears;

    }
}