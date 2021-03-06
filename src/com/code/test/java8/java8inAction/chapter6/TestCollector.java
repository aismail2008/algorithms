package com.code.test.java8.java8inAction.chapter6;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.code.test.java8.java8inAction.chapter4.Dish;
import com.code.test.java8.java8inAction.chapter4.Dish.Type;

public class TestCollector {
	public static void main(String[] args) {
		Pattern p  = Pattern.compile("^en/puzzles//?$");
		boolean b1 = p.matcher("en/puzzles/").matches();
		boolean b2 = p.matcher("en/puzzles/").matches();

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 700, Type.MEAT),
				new Dish("chicken", false, 400, Type.MEAT),
				new Dish("french fries", true, 530, Type.OTHER),
				new Dish("rice", true, 350, Type.OTHER),
				new Dish("season fruit", true, 120, Type.OTHER),
				new Dish("pizza", true, 550, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH),
				new Dish("salmon", false, 450, Type.FISH) );
		
		menu.stream().collect(Collectors.counting());
		
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		 mostCalorieDish = menu.stream().max(new Comparator<Dish>() {
			@Override
			public int compare(Dish o1, Dish o2) {
				return o1.getCalories() - o2.getCalories();
			}
		});

		int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		
		totalCalories = menu.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum));
		
		Map<Type, List<Dish>> r = (Map<Type, List<Dish>>) menu.stream().collect(Collectors.groupingBy(Dish::getType));
	}
}
