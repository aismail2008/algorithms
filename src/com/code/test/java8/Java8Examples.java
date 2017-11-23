package com.code.test.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Java8Examples {

	
	public void test(){
		//The simplest asynchronous computation
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(this::sendMessage);
		//Attaching a callback
		cf.thenAccept(System.out::println);
		
		//Chaining multiple callbacks
		 CompletableFuture.supplyAsync(this::sendMessage)
		 					.thenApply(this::sendMessageApply)
		 					.thenAccept(System.out::println);
		 
		 
		 //If we kept using thenApply to compose the example above, we would end up with nested CompletionStages.
		 CompletableFuture.supplyAsync(this::findReceiver).thenApply(this::sendMessageAsynch);
	
		 //instead we use thenCompose like a flat map
		 CompletableFuture.supplyAsync(this::findReceiver).thenCompose(this::sendMessageAsynch);
		 
		 
		 //thenComplete - 
	}
	public Person findReceiver(){
		return new Person("Ali", "MR");
	}
	
	
	
	public CompletableFuture<String> sendMessageAsynch(Person p){
		return CompletableFuture.completedFuture("I am done asych");
	}

	
	public String sendMessageApply(String s){
		return s +" thenapply";
	}
	
	public String sendMessage(){
		return "abc";
	}
	
	
	public static void main(String []args) {

		BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" + (num1 + num2);
		
		BiConsumer<Integer, Integer > cons = (key, value) -> System.out.println(key + value);
		Map<Integer, Integer> m = new HashMap<>();
		m.put(1, 2);
		m.put(3, 4);
		m.put(6, 189);
		m.forEach(cons);
		System.out.println(biFunction.apply(20, 25));

		testMethodInterface();
		testLambda();
	}

	// -----------------------Method Reference----------------------//
	public static void testMethodInterface() {

		List names = new ArrayList();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		names.forEach(System.out::println);
	}

	// ----------------------Lambda Expr--------------------------//
	public static void testLambda() {
		Java8Examples tester = new Java8Examples();

		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		// with parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// without parenthesis
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");
	}

	// ----------------------Functional Interface --------------------------//
	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
	class Person{
		String name;
		String title;
		
		public Person(String name, String title){
			this.name = name;
			this.title = title;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
	}
}