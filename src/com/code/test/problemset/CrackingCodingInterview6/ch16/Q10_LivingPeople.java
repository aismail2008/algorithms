package com.code.test.problemset.CrackingCodingInterview6.ch16;

import java.util.Arrays;
import java.util.Random;

/**
 * Living People:
 * Given a list of people with their birth and death years, implement a method to
 * compute the year with the most number of people alive. You may assume that all people were born
 * between 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should
 * be included in that year's count. For example, Person (birth= 1908, death= 1909) is included in the
 * counts for both 1908 and 1909.
 */
public class Q10_LivingPeople {
    static class Person {
        public int birth;
        public int death;
        public Person(int birthYear, int deathYear) {
            birth = birthYear;
            death = deathYear;
        }
    }

    public static int maxAliveYear_(Person[] people, int min, int max) {
        int[] years = new int[max-min];

        for (int i = 0; i < people.length; i++) {
            for (int j = people[i].birth; j <= people[j].death; j++) {
                years[j - min]++;
            }
        }

        Arrays.sort(years);
        return years[max-min-1];
    }

    public static int maxAliveYear(Person[] people, int min, int max) {
        int[] births = getSortedYears(people, true);
        int[] deaths = getSortedYears(people, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int currentlyAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = min;

        /* Walk through arrays. */
        while (birthIndex < births.length) {
            if (births[birthIndex] <= deaths[deathIndex]) {
                currentlyAlive++; // include birth
                if (currentlyAlive > maxAlive) {
                    maxAlive = currentlyAlive;
                    maxAliveYear = births[birthIndex];
                }
                birthIndex++; // move birth index
            } else {
                currentlyAlive--; // include death
                deathIndex++; // move death index
            }
        }

        return maxAliveYear;
    }
    /* Copy birth years or death years (depending on the value of copyBirthYear)
     * into integer array, then sort array. */
    public static int[] getSortedYears(Person[] people, boolean copyBirthYear) {
        int[] years = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            years[i] = copyBirthYear ? people[i].birth : people[i].death;
        }
        Arrays.sort(years);
        return years;
    }
}
