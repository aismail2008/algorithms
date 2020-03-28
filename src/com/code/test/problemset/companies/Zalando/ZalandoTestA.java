package com.code.test.problemset.companies.Zalando;

import java.io.IOException;
import java.util.StringTokenizer;

public class ZalandoTestA {
	// Write in code a method that finds the first non-repeated character in a String. Explain the algorithm, and why

	/**
	 * Algorithm : 
	 * - initialize int flag array with all characters supports all ASCII codes from 0 to 255
	 * - for each character in the string 
	 * 		increment its count
	 * - for each character in the string 
	 * 		check if count in counts array is 1 then return this character
	 * if not found at all return null
	 * @param input
	 * @return first non repeating character or null if not found
	 */
	public static Character getFirstNotRepeatedChar(String input) {

		int[] counts = new int[256]; // all is initialized by 0

		for (int i = 0; i < input.length(); i++) { // O(n)
			counts[(int) input.charAt(i)]++;
		}

		for (int i = 0; i < input.length(); i++) { // O(n)
			if (counts[(int) input.charAt(i)] == 1)
				return input.charAt(i);
		}

		return null;
	}

	public static void main(String[] args) throws IOException {
		getFirstNotRepeatedChar("stress");
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String s = br.readLine();
		// while (s != null && !s.equalsIgnoreCase("")) {
		// System.out.println("This is : " + s);
		// s = br.readLine();
		// }
		// Scanner sc = new Scanner(System.in);
		// while (true) {
		// int charAscii = (int) sc.nextLine().charAt(0);
		// System.out.println("Your ascii is : " + charAscii);
		// }
		StringBuilder result = new StringBuilder("");
		StringTokenizer s = new StringTokenizer("sdfasdf", " ");
		System.out.println(solution("asdZdi0sdSS"));
	}

	final static String actual = "This world is huge";
	final static String expected = "This dlrow is eguh";

	public static String reverseOdd(String input) {
		if (input == null || input.length() == 0)
			return "";

		String[] arr = input.split(" ");

		boolean reverse = false;
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < arr.length; i++) {
			if (reverse) {
				StringBuilder rev = new StringBuilder(arr[i]);
				result = result.append(rev.reverse() + " ");
			} else {
				result = result.append(arr[i] + " ");
			}
			reverse = !reverse;
		}
		int len = result.toString().length();
		return result.toString().substring(0, len - 1);
	}

	public static int solution(String s) {
		String maxSubStr = "";
		String tempStr = "";

		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') // string start with number
				continue;
			for (int j = i + 1; j <= s.length(); ++j) {
				tempStr = s.substring(i, j);
				if (isValid(tempStr) && tempStr.length() > maxSubStr.length()) {
					maxSubStr = tempStr;
				}
			}
		}
		return maxSubStr.length() == 0 ? -1 : maxSubStr.length();
	}

	public static boolean isValid(String s) {
		boolean isUpper = false;
		// for (int i = 0; i < s.length(); i++) {
		// char c = s.charAt(i);
		// if((c >= '0' && c <= '9'))
		// return false;
		// if(!isUpper)
		// isUpper = (c >= 'A' && c <= 'Z');
		// }
		return s.matches("([a-z]*[A-Z]+[a-z]*)+");
		// return isUpper;
	}
}
