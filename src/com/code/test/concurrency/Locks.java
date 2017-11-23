package com.code.test.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Locks {
	private volatile long count = 0;
	ThreadLocal<String> myThreadLocal = new ThreadLocal<String>();
	
	private ReentrantReadWriteLock readWritelock = new ReentrantReadWriteLock();
	private Lock lock = new ReentrantLock();

	public void add(long value) {
		Condition cond = lock.newCondition();
		cond.signal();
		cond.signalAll();
		
		String s = myThreadLocal.get();
		this.count += value;
	}
}
