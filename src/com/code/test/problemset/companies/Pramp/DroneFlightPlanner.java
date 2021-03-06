package com.code.test.problemset.companies.Pramp;

/**
 * Drone Flight Planner
 * You’re an engineer at a disruptive drone delivery startup and your CTO asks you to come up with an efficient algorithm that calculates the minimum amount of energy required for the company’s drone to complete its flight. You know that the drone burns 1 kWh (kilowatt-hour is an energy unit) for every mile it ascends, and it gains 1 kWh for every mile it descends. Flying sideways neither burns nor adds any energy.
 * <p>
 * Given an array route of 3D points, implement a function calcDroneMinEnergy that computes and returns the minimal amount of energy the drone would need to complete its route. Assume that the drone starts its flight at the first point in route. That is, no energy was expended to place the drone at the starting point.
 * <p>
 * For simplicity, every 3D point will be represented as an integer array whose length is 3. Also, the values at indexes 0, 1, and 2 represent the x, y and z coordinates in a 3D point, respectively.
 * <p>
 * Explain your solution and analyze its time and space complexities.
 * <p>
 * Example:
 * <p>
 * input:  route = [ [0,   2, 10],
 * [3,   5,  0],
 * [9,  20,  6],
 * [10, 12, 15],
 * [10, 10,  8] ]
 * <p>
 * output: 5 # less than 5 kWh and the drone would crash before the finish
 * # line. More than `5` kWh and it’d end up with excess energy
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.array.integer route
 * <p>
 * 1 ≤ route.length ≤ 100
 * [output] integer
 */
public class DroneFlightPlanner {
    static int calcDroneMinEnergy(int[][] route) {
        int energy = 0;
        int totalNeeded = 0;
        for (int i = 1; i < route.length; i++) {
            energy += route[i - 1][2] - route[i][2];
            if (energy < 0) {
                totalNeeded += -1 * energy;
                energy = 0;
            }
        }

        return totalNeeded;
    }

    public static void main(String[] args) {
        new DroneFlightPlanner().calcDroneMinEnergy(new int[][]{
                {0, 2, 2},
                {3, 5, 38}, // -36            36
                {9, 20, 6},
                {10, 12, 15},
                {10, 10, 8}});
    }
}
