package com.code.test.java8.java8inAction.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.code.test.java8.java8inAction.chapter4.Dish;
import com.code.test.java8.java8inAction.chapter4.Dish.Type;
import com.sun.javafx.collections.MappingChange.Map;

public class TestCollector {
	public static void main(String[] args) {



		Pattern p  = Pattern.compile("^en/puzzles//?$");
		boolean b1 = p.matcher("en/puzzles/").matches();
		boolean b2 = p.matcher("en/puzzles/").matches();




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
		
		menu.stream().collect(Collectors.counting());
		
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		
		int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		
		totalCalories = menu.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum));
		
		Map<Dish.Type, List<Dish>> r = (Map<Type, List<Dish>>) menu.stream().collect(Collectors.groupingBy(Dish::getType));
	}
}
