package com.code.test.problemset.basics;

import java.util.*;
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

    public static void main(String[] args) {
        reverseArrayOrList();
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
}
