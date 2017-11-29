package com.code.test.problemset.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Challange {

	public static long sumOfIntegers(int[] arr) {
		long sum = 0;
		for(int i =0; i < arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 Stack<Character> stckX = new Stack();
		 Stack<Character> stckY = new Stack();
		 char x = 'A';//stckX.pop();
		 char y = 'B';//stckY.pop();
		 int f = x;
		 int s = y;
		 if(f > s){
			 System.out.println(y);
		 }
		 
		
//		Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        long res;
//        
//        int _arr_size = Integer.parseInt(in.nextLine());
//        int[] _arr = new int[_arr_size];
//        int _arr_item;
//        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
//            _arr_item = Integer.parseInt(in.nextLine())
//            _arr[_arr_i] = _arr_item;
//        }
//        
//        res = sumOfIntegers(_arr);
//        bw.write(String.valueOf(res));
//        bw.newLine();
//        
//        bw.close();
        
        
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int targetSum = Integer.parseInt(br.readLine());
			int arraySize = Integer.parseInt(br.readLine());
			int[] array = new int[arraySize];
			int item;
	        for(int i = 0; i < arraySize; i++) {
	            item = Integer.parseInt(br.readLine());
	            array[i] = item;
	        }

	        boolean found = false;
			for (int i = 0; i < arraySize && !found; i++) {
				for (int j = i+1; j < arraySize && !found; j++) {
					if((array[i] + array[j]) == targetSum)
						found = true;
				}
			}
			if(found)
				System.out.println(1);
			else 
				System.out.println(0);
			
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
