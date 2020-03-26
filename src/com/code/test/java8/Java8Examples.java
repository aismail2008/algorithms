package com.code.test.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Java8Examples {

    public static void main(String[] args) {
        testMethodInterface();
        //======================//
        functionVsConsumer();
    }

    public static void testMethodInterface() {
        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);
    }

    static void functionVsConsumer(){
        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" + (num1 + num2);

        BiConsumer<Integer, Integer> cons = (key, value) -> System.out.println(key + value);

        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(3, 4);
        m.put(6, 189);
        m.forEach(cons);
        System.out.println(biFunction.apply(20, 25));
    }
}