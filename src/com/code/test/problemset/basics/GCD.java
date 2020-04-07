package com.code.test.problemset.basics;

/**
 * Greatest Common Divisor of two integers
 */
public class GCD {

	public static int gcd3(int num1, int num2) {
		while (num1 != num2) {
			if(num1 > num2)
				num1 = num1 - num2;
			else
				num2 = num2 - num1;
		}
		return num1;
	}

	// recursive implementation
	public static int gcd(int p, int q) {
		if (q == 0) return p;
		else return gcd(q, p % q);
	}

	// non-recursive implementation
	public static int gcd2(int p, int q) {
		while (q != 0) {
			int temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}

	public static void main(String[] args) {
		int p = 55;
		int q = 121;
		int d  = gcd(p, q);
		int d2 = gcd2(p, q);
		int d3 = gcd3(p, q);
		System.out.println("gcd(" + p + ", " + q + ") = " + d);
		System.out.println("gcd(" + p + ", " + q + ") = " + d2);
		System.out.println("gcd(" + p + ", " + q + ") = " + d3);
	}
}
