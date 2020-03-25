package com.code.test.concurrency.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
	private int workLoad = 0;

	public MyRecursiveTask(int workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println(Thread.currentThread().getName() + " Splitting workLoad : " + this.workLoad);

			MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
			MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);
			subtask1.fork();
			subtask2.fork();

			sum = subtask1.join() + subtask2.join();
			System.out.println(Thread.currentThread().getName() + " Sum: " + sum);
		} else {
			System.out.println(Thread.currentThread().getName() + " Doing workLoad myself: " + this.workLoad);
			sum = workLoad;
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(10);
		long result = pool.invoke(new MyRecursiveTask(40));
		System.out.println(result);
	}
}
