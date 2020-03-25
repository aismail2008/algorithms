package com.code.test.concurrency.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
	private long workLoad = 0;

	public MyRecursiveAction(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected void compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 2) {
			System.out.println(Thread.currentThread().getName() + " Splitting workLoad : " + this.workLoad);

			new MyRecursiveAction(this.workLoad / 2).fork();
			new MyRecursiveAction(this.workLoad / 2).fork();

		} else {
			System.out.println(Thread.currentThread().getName() + " Doing workLoad myself: " + this.workLoad);
		}
	}

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(5);
		pool.invoke(new MyRecursiveAction(20));
	}
}
