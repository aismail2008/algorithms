package com.code.test.concurrency.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
	private long workLoad = 0;

	public MyRecursiveTask(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected Integer compute() {
		Integer sum = 0;
		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

//			List<MyRecursiveTask> subtasks = new ArrayList<MyRecursiveTask>();
			MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
			MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);
//			subtasks.add(subtask1);
//			subtasks.add(subtask2);

//			List<ForkJoinTask<Integer>> lft = new ArrayList<ForkJoinTask<Integer>>();
//			for (MyRecursiveTask subtask : subtasks) {
//				lft.add(subtask.fork());
//			}
			sum = subtask1.join() + subtask2.join();
		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(10);
		long result = pool.invoke(new MyRecursiveTask(40));
	}
}
