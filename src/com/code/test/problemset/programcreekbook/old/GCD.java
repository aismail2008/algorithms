package com.code.test.problemset.programcreekbook.old;


public class GCD {
	public static int solution(int[] a, int[] b) {
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			int gcdv = gcd(a[i], b[i], 1);
		}
		return k;
	}

	public static int gcd(int a, int b, int res) {
		if (a == b)
			return a * res;
		else if (a % 2 == 0 && b % 2 == 0)
			return gcd(a / 2, b / 2, res * 2);
		else if (a % 2 == 0)
			return gcd(a / 2, b / 2, res);
		else if (b % 2 == 0)
			return gcd(a, b / 2, res);
		else if (a > b)
			return gcd(a - b, b, res);
		else
			return gcd(a, b - a, res);
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
		int p = Integer.parseInt(args[0]);
		int q = Integer.parseInt(args[1]);
		int d  = gcd(p, q);
		int d2 = gcd2(p, q);
		System.out.println("gcd(" + p + ", " + q + ") = " + d);
		System.out.println("gcd(" + p + ", " + q + ") = " + d2);
	}
}
