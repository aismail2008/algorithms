package com.code.test.problemset.CrackingCodingInterview6.ch7;

import java.util.Iterator;

public class Q9_CircularArray<T> implements Iterable<T> {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 10;
		Q9_CircularArray<String> array = new Q9_CircularArray<String>(size);
		for (int i = 0; i < size; i++) {
			array.set(i, String.valueOf(i));
		}

		array.rotate(-33);
		array.get(1);
		for (int i = 0; i < size; i++) {
			System.out.println(array.get(i));
		}

		System.out.println("");

		array.rotate(2);
		for (String s : array) {
			System.out.println(s);
		}
	}

	private T[] items;
	private int head = 0;
	
	public Q9_CircularArray(int size) {
		items = (T[]) new Object[size];
	}
	
	private int convert(int index) {
		if (index < 0) {
			index += items.length;
		}
		return (head + index) % items.length;
	}
	
	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}
	
	public T get(int i) {
		if (i < 0 || i >= items.length) {
			throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
		}
		return items[convert(i)];
	}
	
	public void set(int i, T item) {
		items[convert(i)] = item;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator();
	}
	
	private class CircularArrayIterator implements Iterator<T> {
		private int _current = -1;
		
		public CircularArrayIterator() { }
		
		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}
		
		@Override
		public T next() {
			_current++;
			return (T) items[convert(_current)];
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove is not supported by CircularArray");
		}
	}
}
