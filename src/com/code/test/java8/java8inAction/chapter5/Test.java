package com.code.test.java8.java8inAction.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Test {
	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300), 
                                        				new Transaction(raoul, 2012, 1000), 
                                        				new Transaction(raoul, 2011, 400), 
                                        				new Transaction(mario, 2012, 710), 
                                        				new Transaction(mario, 2012, 700), 
                                        				new Transaction(alan, 2012, 950));

		System.out.println("=========1===========");
		// 1- Find all transactions in the year 2011 and sort them by value (small to high).
//		transactions.stream().filter(t -> t.getYear() == 2011).sorted((a, b) -> Integer.compare(a.getValue(), b.getValue())).forEach(System.out::println);
		
		transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);

		System.out.println("=========2===========");
		// 2. What are all the unique cities where the traders work?
		transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().forEach(System.out::println);

		System.out.println("=========3===========");
		// 3. Find all traders from Cambridge and sort them by name.
		Predicate<Trader> cambOnly = t -> t.getCity().equalsIgnoreCase("Cambridge");
		transactions.stream().map(Transaction::getTrader).filter(cambOnly).distinct().sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
		
		System.out.println("=========4===========");
		// 4. Return a string of all traders’ names sorted alphabetically.
		transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().forEach(System.out::println);
		
		System.out.println("=========5===========");
		// 5. Are any traders based in Milan?
		System.out.println(transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity().equalsIgnoreCase("Milan")));
		
		System.out.println("=========6===========");
		// 6. Print all transactions’ values from the traders living in Cambridge
		transactions.stream().filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(Transaction::getValue).forEach(System.out::println);
		
		System.out.println("=========7===========");
		// 7. What’s the highest value of all the transactions?
		transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
		transactions.stream().mapToInt(Transaction::getValue).max().ifPresent(System.out::println);
		
		System.out.println("=========8===========");
		// 8. Find the transaction with the smallest value
		BinaryOperator<Transaction> accumlator = (a, b) -> a.getValue() > b.getValue()? b : a;
		transactions.stream().reduce(accumlator).ifPresent(System.out::println);
		
	}
}
