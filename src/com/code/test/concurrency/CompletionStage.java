package com.code.test.concurrency;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletionStage {
	public static void main(String argv[]) throws Exception {

	}

	Executor service = Executors.newFixedThreadPool(300);

	public void test_then_combine_async() throws Exception {
		CompletableFuture<Object> firstTask = null;

		CompletableFuture<File> secondTask = null;

		firstTask = firstTask.thenCombineAsync(secondTask, (f, s) -> f, service);

		try {
			firstTask.get();
		} catch (Exception e) {
		}
		firstTask.join();
	}

	private static Object test(Object futA, File futB) {
		// TODO Auto-generated method stub
		return null;
	}

	private static CompletableFuture<String> test(StringBuilder s) {
		return null;
	}
}