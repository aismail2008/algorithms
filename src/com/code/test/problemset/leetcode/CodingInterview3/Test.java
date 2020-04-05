package com.code.test.problemset.leetcode.CodingInterview3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {


	public class Node{
		String value;
		Node nextNode;
	}

	public static void revsres(LinkedList<Node> revserseStr, int start){
		if(revserseStr.size() == 0)
			return;
        
		int last = revserseStr.size() - 1;
        if(start == last || start > last)
            return;
        revserseStr.add(start+1, revserseStr.get(last));
        revserseStr.remove(last+1);
        revsres(revserseStr, start+2);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List test = new LinkedList();
		test.add("A");
		test.add("B");
		test.add("C");
		test.add("D");
		test.add("E");
		test.add("F");
		test.add("G");
		test.add("H");
		test.add("I");
		
//		revsres(test, 0);
		
//		String s = "ab";
//		char c = s.charAt(0);
//
//		int count = 1;
//		for (int i = 1; i < s.length(); i++) {
//			if (s.charAt(i) != c) {
//				s = s.substring(0, i) + count + s.substring(i, s.length());
//				c = s.charAt(++i);
//				count = 1;
//			} else {
//				s = s.substring(0, i) + s.substring(i+1, s.length());
//				i--;
//				count++;
//			}
//		}
//		System.out.println(s+count);
		ArrayList<String> dic = new ArrayList<String>();
		dic.add("sam");
		dic.add("samsung");
		dic.add("sung");
		foundAtDictionary(dic);//sungsamsungsam
		allStringsI("abcde");
	}
	
	int solution(int X, int A[], int N){
		
		return 0;
	}
	
	public static ArrayList<String> allStringsI(String s) {
		ArrayList<String> retVal = new ArrayList<String>();
		retVal.add("");

		if (s == null || s.length() == 0)
			return retVal;

		char c;

		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);

			ArrayList<String> loop = retVal;
			retVal = new ArrayList<String>();

			for (String st : loop) {
				retVal.add(c + st);

				for (int j = 1; j <= st.length(); j++)
					retVal.add(st.substring(0, j) + c + st.substring(j));
			}
		}
		return retVal;
	}
	
	
	public static ArrayList<String> foundAtDictionary(List<String> s) {
//		http://www.programcreek.com/2012/12/leetcode-solution-word-break/                 wordbreak
		ArrayList<String> retVal = new ArrayList<String>();
		retVal.add("");

		if (s == null || s.size() == 0)
			return retVal;

		String c;

		for (int i = 0; i < s.size(); i++) {
			c = s.get(i);

			ArrayList<String> loop = retVal;
			retVal = new ArrayList<String>();

			for (String st : loop) {
				retVal.add(c + st);

				for (int j = 1; j <= st.length(); j++)
					retVal.add(st.substring(0, j) + c + st.substring(j));
			}
		}
		return retVal;
	}
}
