package com.code.test.problemset.leetcode.CodingInterview3;

import java.util.ArrayList;
import java.util.List;

public class FromBaseToBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> numb =fromBaseToBase(72, 2); 
	}

	public static List<String> fromBaseToBase(int n, int b) {
		// def toDigits(n, b):
		// """Convert a positive number n to its digit representation in base b."""
		// digits = []
		List<String> numb = new ArrayList<String>(); 
		 while( n > 0){
			 numb.add(0, (n % b)+"");
			 n /= b;
		}
		 return numb;
		//
		// def fromDigits(digits, b):
		// """Compute the number given by digits in base b."""
		// n = 0
		// for d in digits:
		// n = b * n + d
		// return n
	}

}
