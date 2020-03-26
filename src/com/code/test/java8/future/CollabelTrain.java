package com.code.test.java8.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CollabelTrain {

	// Factorial implements Callable so that it can be passed to a
	// ExecutorService
	// and get executed as a task.
	static class Factorial implements Callable<Long> {
		long number;

		public Factorial(long n) {
			this.number = n;
		}

		public Long call() throws Exception {
			if (number <= 0) {
				throw new Exception("for finding factorial, N should be > 0");
			}
			long fact = 1;
			for (long longVal = 1; longVal <= number; longVal++) {
				fact *= longVal;
			}
			return fact;
		}
	}

	// Illustrates how Callable, Executors, ExecutorService, and Future are
	// related;
	// also shows how they work together to execute a task
	public static void main(String[] args) throws Exception {
		long number = 20;
		Callable<Long> task = new Factorial(number);
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Long> future = es.submit(task);
		System.out.printf("factorial of %d is %d", number, future.get());
		es.shutdown();
	}

}
