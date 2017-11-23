package com.code.test.java8.java8inAction.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Test {

	public static void main(String[] args){
		testFlatMap();
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		Stream<String> s = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3);//collect(toList());
		s.forEach(System.out::println);// streams are consumed once
		s.forEach(System.out::println);// this prints nothing as it is already closed
		
		s.collect(toList()).stream().map(word->word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
		
		List<String> lS = s.collect(toList());
		lS.forEach(System.out::println);
		
		
		menu.stream().filter(Dish::isVegetarian).distinct().skip(2).limit(3).collect(toList());
	}
	
	private static void testFlatMap(){
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2
														.stream()
														.map(j -> new int[]{i, j})
												 )
											.collect(toList());
		
		pairs.forEach(ar -> System.out.println("[" + ar[0] + ", " + ar[1] + "]"));
		
	}
}
