package com.code.test.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsTrain {
	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();

		ExecutorService executor = Executors.newFixedThreadPool(5);

		ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

		// 1- ------execute -

		executor.execute(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});
		executor.shutdown();

		// 2- ------Submit - ------------------
		Future future = executor.submit(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});

		try {
			future.get();// returns null if the task has finished correctly.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3- --------- submit
		long N = 20;
		Callable<Long> task = (new CollabelTrain()).new Factorial(N);
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Long> futre = es.submit(task);
		System.out.printf("factorial of %d is %d", N, futre.get());
		es.shutdown();
		
		
	}

	// Factorial implements Callable so that it can be passed to a
	// ExecutorService
	// and get executed as a task.
	class Factorial implements Callable<Long> {
		long n;

		public Factorial(long n) {
			this.n = n;
		}

		public Long call() throws Exception {
			if (n <= 0) {
				throw new Exception("for finding factorial, N should be > 0");
			}
			long fact = 1;
			for (long longVal = 1; longVal <= n; longVal++) {
				fact *= longVal;
			}
			return fact;
		}
	}
}
