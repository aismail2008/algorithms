package com.code.test.problemset.basics;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    /**
     *  Group by map values and list key.
     * @param level
     * @return
     */
    public static Map<Object, List<Object>> mapToListByValue(Map<Object, Object> level) {
        return level.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
    }

    public static void reverseOrder(){
        PriorityQueue priorityQueue = new PriorityQueue(Comparator.reverseOrder());

        Arrays.sort(new Integer[]{}, Comparator.reverseOrder());
    }

    public static void reverseArrayOrList()  {

        String[] typesOfInsurance = {"Cat", "Dog", "Elephant"};
        System.out.println("array before reverse: " + Arrays.toString(typesOfInsurance) );

        List listOfProducts = Arrays.asList(typesOfInsurance);
        Collections.reverse(listOfProducts);

        String[] reversed = new String[3];
        listOfProducts.toArray(reversed);

        System.out.println("array after reverse: " + Arrays.toString(reversed) );
    }

    /**
     * Shortest path between two points in 2d matrix
     */
    private int visitBfsPointToPoint(int[][] forest, Point start, Point end) {
        if (start == end)
            return 0;

        boolean[][] visited = new boolean[forest.length][forest[0].length];
        int n = forest.length;
        int m = forest[0].length;

        Queue<Point> queue = new LinkedList<>();
        HashMap<Point, Integer> pointSteps = new HashMap<>();
        pointSteps.put(start, 0);
        queue.offer(start);
        Point current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            visited[current.x][current.y] = true;
            if (current.equals(end)) {
                break;
            }

            if ((current.y + 1) < m && forest[current.x][current.y + 1] != 0 && !visited[current.x][current.y + 1]) {
                queue.add(new Point(current.x, current.y + 1));
                pointSteps.put(new Point(current.x, current.y + 1), pointSteps.get(current) + 1);
            }
            if ((current.x + 1) < n && forest[current.x + 1][current.y] != 0 && !visited[current.x + 1][current.y]) {
                queue.add(new Point(current.x + 1, current.y));
                pointSteps.put(new Point(current.x + 1, current.y), pointSteps.get(current) + 1);
            }
            if ((current.x - 1) >= 0 && forest[current.x - 1][current.y] != 0 && !visited[current.x - 1][current.y]) {
                queue.add(new Point(current.x - 1, current.y));
                pointSteps.put(new Point(current.x - 1, current.y), pointSteps.get(current) + 1);
            }
            if ((current.y - 1) >= 0 && forest[current.x][current.y - 1] != 0 && !visited[current.x][current.y - 1]) {
                queue.add(new Point(current.x, current.y - 1));
                pointSteps.put(new Point(current.x, current.y - 1), pointSteps.get(current) + 1);
            }
        }

        return pointSteps.getOrDefault(end, -1);
    }

    /**
     * Copy Array except I
     */
    private  int[] copyArrayExceptI(int i, int[] arr) {
        int[] newArr = new int[arr.length - 1];
        int h = 0;
        for (int j = 0; j < newArr.length; j++) {
            if (h == i) {
                h++;
            }
            newArr[j] = arr[h++];
        }
        return newArr;
    }

}
