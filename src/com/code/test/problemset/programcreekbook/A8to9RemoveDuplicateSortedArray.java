package com.code.test.problemset.programcreekbook;

public class A8to9RemoveDuplicateSortedArray {
	public static void main(String[] args) {
		duplicateAllowTwice();
	}

	// 8
	public static void removeDuplicated(){
		int[] a = new int[] {0, 1, 2, 3, 3, 4, 5, 5, 6 };

		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if(j == 0 || a[i] != a[j-1])
				a[j++] = a[i];
		}
		
		System.out.println(a);
	}
	// 9
	public static void duplicateAllowTwice(){
		int[] a = new int[] {0, 1, 2, 3, 3, 3, 4, 5, 5, 6 };

		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if(j == 0 || a[i] != a[j-1] || (a[i] == a[j-1] && a[i] != a[j-2]))
				a[j++] = a[i];
		}
		
		System.out.println(a);
	}
	
}
