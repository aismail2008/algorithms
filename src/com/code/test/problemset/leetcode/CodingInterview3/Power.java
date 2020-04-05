package com.code.test.problemset.leetcode.CodingInterview3;

public class Power {
	static double pow(int m, int n){
		if(n == 0)
			return 1;
		
		if(n == 1)
			return m;
		
		double v = pow(m, n/2);
		
		if(n%2 == 0)
			return v * v;
		else
			return v * v * m;
	}

	static double powBitOperation(int m, int n){
	    int result = 1;
	    while(n != 0){
	        if((n & 1) == 1){
	            result = result * m; 
	        }
	        n >>= 1;
	        m *= m;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		System.out.println(powBitOperation(2,3));
		System.out.println(pow(2,3));
		System.out.println("-------------");
		System.out.println(powBitOperation(4,1));
		System.out.println(pow(4,1));
		System.out.println("-------------");
		System.out.println(powBitOperation(5,3));
		System.out.println(pow(5,3));
		System.out.println("-------------");
		System.out.println(powBitOperation(8,8));
		System.out.println(pow(8,8));
		System.out.println("-------------");
		System.out.println(powBitOperation(6,3));
		System.out.println(pow(6,3));
		System.out.println("-------------");
	}
}
