package com.code.test.java8.streamsZA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    private static boolean isPrime(final int number) {
        IntPredicate isDivisble = divisor -> number % divisor == 0;

        return number > 1 && IntStream.range(2, number).noneMatch(isDivisble);
    }

    public static void main(String[] args) {
        isPrime(5);

        List<Person> persons = populateWithData();
        //-- Obtain US and non US based persons using partitioning by and grouping by
        Map<Boolean, List<Person>> result = persons.stream().collect(Collectors.partitioningBy(p -> p.getCountry().equals("US")));
        result.get(true).forEach(System.out::println);
        result.get(false).forEach(System.out::println);
        System.out.println("============");

        result = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry().equals("US")));
        result.get(true).forEach(System.out::println);
        result.get(false).forEach(System.out::println);
        System.out.println("============");

        //-- Obtain US and non US based persons using partitioning by and grouping by
        Map<Boolean, Long> countResult = persons.stream().collect(Collectors.partitioningBy(p -> p.getCountry().equals("US"), Collectors.counting()));
        System.out.println(countResult.get(true));
        System.out.println(countResult.get(false));
        System.out.println("============");

        countResult = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry().equals("US"), Collectors.counting()));
        System.out.println(countResult.get(true));
        System.out.println(countResult.get(false));
        System.out.println("============");

        //-- Obtain the persons in each country and count them using groupingby
        Map<String, Long> groupResult = persons.stream().collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));
        groupResult.entrySet().stream().forEach(ent -> System.out.println(ent.getKey() + ": " + ent.getValue()));
        //-- Obtain US and non US based persons using partitioning by and & map names to uppercase using mapping
        persons.stream().collect(Collectors.partitioningBy(p -> p.getCountry().equals("US"), Collectors.mapping(p -> p.getName().toUpperCase(), Collectors.toList())));

        //-- Obtain the persons in each country using groupingBy and map names to upperCase using mapping
        persons.stream().collect(Collectors.groupingBy(Person::getCountry, Collectors.mapping(p -> p.getName().toUpperCase(), Collectors.toList())));

    }

    static List<Person> populateWithData() {
		Person p1 = new Person("Person01", "US");
		Person p2 = new Person("Person02", "US");
		Person p3 = new Person("Person03", "Brazil");
		Person p4 = new Person("Person04", "US");
		Person p5 = new Person("Person05", "Brazil");
		Person p6 = new Person("Person06", "US");
		Person p7 = new Person("Person07", "Germany");
		Person p8 = new Person("Person08", "US");
		List<Person> personList = new ArrayList<Person>();

		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p5);
		personList.add(p6);
		personList.add(p7);
		personList.add(p8);

		return personList;
	}
}
