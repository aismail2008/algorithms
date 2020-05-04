package com.code.test.java8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExcep {

    /**
     * In case of CopyOnWriteArrayList, iterator doesn’t accomodate the changes in the list and works on the original list.
     * In case of ConcurrentHashMap, the behavior is not always the same.
     */
    public static void main(String[] args) {
        trySet();
        System.out.println("--");
        tryMap();
        System.out.println("--");
        tryMap();
        System.out.println("--");
        tryMap();
        System.out.println("--");
        tryMap();
    }
    public static void tryMap() {
        Map<String, List<String>> myMap = new Hashtable<>();
        myMap.put("1", List.of(new String[]{"1"}));
        myMap.put("2", List.of(new String[]{"2"}));
        myMap.put("3", List.of(new String[]{"3"}));

        for ( Map.Entry<String, List<String>> ent: myMap.entrySet()) {
            String key = ent.getKey();
            System.out.println("Map Value:" + myMap.get(key));
            if (key.equals("1")) {
                myMap.remove("3");
                myMap.put("4", List.of(new String[]{"4"}));
                myMap.put("5", List.of(new String[]{"5"}));
                myMap.get("4").add("0"); // This throws exception you can change value of key on hashMap
            }
        }
        System.out.println("Map Size:" + myMap.size());
    }

    public static void tryMap_() {
        Map<String, String> myMap = new ConcurrentHashMap<String, String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<String> it1 = myMap.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            System.out.println("Map Value:" + myMap.get(key));
            if (key.equals("1")) {
                myMap.remove("3");
                myMap.put("4", "4");
                myMap.put("5", "5");
            }
        }

        System.out.println("Map Size:" + myMap.size());
    }

    public static void trySet() {
        Set<int[]> mySet = new HashSet<>();
        mySet.add(new int[]{1,1});
        mySet.add(new int[]{2,2});
        mySet.add(new int[]{3,3});

        // Iterator will through concurrentModiExce. so that it the work around
        int[][] it1 = new int[mySet.size()][];
        mySet.toArray(it1);
        for (int i = 0; i < it1.length; i++) {
            int[] key = it1[i];
            System.out.println("Set Value:" + key);
            if (Arrays.equals(key,new int[]{1,1})) {
                mySet.remove(new int[]{3,3});
                mySet.remove(new int[]{4,4});
                mySet.remove(new int[]{5,5});
            }
        }

        System.out.println("Map Size:" + mySet.size());
    }

    public static void tryList() {
        List<String> myList = new CopyOnWriteArrayList<>();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals("3")) {
                myList.remove("4");
                myList.add("6");
                myList.add("7");
            }
        }
        System.out.println("List Size:" + myList.size());
    }
}
