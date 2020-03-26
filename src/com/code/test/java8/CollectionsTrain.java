package com.code.test.java8;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CollectionsTrain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMapTest();
		setExample();
		patternReco();
	}

	public static void setExample() {
		TreeSet<String> s = new TreeSet<>();
		try {
			s.add(null); //NPE
		}catch (Exception e){}
	}

	public static void patternReco() {
		String line = "This order was placed for QT3000! OK?";
		// Create a Pattern object
		Pattern r = Pattern.compile("(.*)(\\d+)(.*)");

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
		} else {
			System.out.println("NO MATCH");
		}
	}

	public static void TreeMapTest() {
		// Create a hash map
		Map<String, Double> tm = new TreeMap();
		// Put elements to the map
		tm.put("Zara", Double.valueOf(3434.34));
		tm.put("Mahnaz", Double.valueOf(123.22));
		tm.put("Ayan", Double.valueOf(1378.00));
		tm.put("Daisy", Double.valueOf(99.22));
		tm.put("Qadir", Double.valueOf(-19.08));

		tm.entrySet().stream().forEach(System.out::println);
		System.out.println("==============");

		tm.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
					(oldValue, newValue) -> oldValue, LinkedHashMap::new))
				.entrySet().stream().forEach(System.out::println);

		// Get a set of the entries
		Set set = tm.entrySet();
		// Get an iterator
		Iterator i = set.iterator();
	}
}
