package com.code.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionsTrain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMapTest();
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);

		for (int i : list) {
			list.add(1, 0);
		}

		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Your username is " + username.lastIndexOf(username.charAt(1)));

		// Map<String, Object> parameters = new HashMap<String, Object>();
		// Queue<String> q = new PriorityQueue<String>();
		// q.
		Set<String> s = new HashSet<String>();
		s.add(null);

		PriorityQueue<String> queue = new PriorityQueue<String>(10);
		queue.iterator();
		queue.add("short");
		queue.add("very long indeed");
		queue.add("medium");
		while (queue.size() != 0) {
			System.out.println(queue.remove());
		}

		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.iterator();

		Hashtable<String, String> vars = new Hashtable<String, String>();
		Enumeration<String> en = vars.elements();

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.iterator();
	}

	public static void setExample() {
		TreeSet<String> s = new TreeSet<String>();
		s.add(null);

	}

	public static void patternReco() {
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

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
		TreeMap<String, Double> tm = new TreeMap<String, Double>();
		// Put elements to the map
		tm.put("Zara", new Double(3434.34));
		tm.put("Mahnaz", new Double(123.22));
		tm.put("Ayan", new Double(1378.00));
		tm.put("Daisy", new Double(99.22));
		tm.put("Qadir", new Double(-19.08));

		List<Entry<String, Double>> sortedByValue = new LinkedList<Entry<String, Double>>(tm.entrySet());
		Collections.sort(sortedByValue, new Comparator<Entry<String, Double>>() {
			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		
		
		// Get a set of the entries
		Set set = tm.entrySet();
		// Get an iterator
		Iterator i = set.iterator();
		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		// Deposit 1000 into Zara's account
		double balance = ((Double) tm.get("Zara")).doubleValue();
		tm.put("Zara", new Double(balance + 1000));
		System.out.println("Zara's new balance: " + tm.get("Zara"));
	}
}
