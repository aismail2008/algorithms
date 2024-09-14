package com.code.test.problemset.companies.talabt;

public class PopulationYear {

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


   /**
    * Let's analyze the time and space complexity of the nbYear function:
Time Complexity:
O(n), where n is the number of years it takes for the population to reach or exceed the target.
The while loop runs once for each year until the target population is reached.
The number of iterations depends on the input parameters and how quickly the population grows.
Space Complexity:
O(1) or constant space.
We only use a fixed number of variables (years, currentPopulation) regardless of the input size.
No additional data structures are created that grow with input size.
The time complexity could potentially be high if the growth rate is very slow or the target is very far from the initial population. However, for most practical scenarios, it should be reasonably fast.
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
