package com.code.test.problemset.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ChallengA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testB();
		compress("abababaabbaaaa");
		 solve("abcdefgh");
	}

	private static void solve(String in) {
		char[] dummy = in.toCharArray();
		Arrays.sort(dummy);
		in = new String(dummy);
		char[] c = in.toCharArray();
		int[] count = new int[26];
		int maxRepetitions = 0;
		int maxKey = 0;

		for (int i = 0; i < c.length; ++i) {
			count[c[i] - 'a']++;
			if (maxRepetitions < count[c[i] - 'a']) {
				maxRepetitions = count[c[i] - 'a'];
			}
		}

		int[] mode = new int[maxRepetitions + 1];
		maxRepetitions = 0;

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				mode[count[i]]++;
				if (maxRepetitions < mode[count[i]]) {
					maxRepetitions = mode[count[i]];
					maxKey = count[i];
				}
			}
		}

		// System.out.println(maxKey);
		// System.out.println(maxRepetitions);

		int res = 1;
		for (int i = 0; i < 26; ++i) {
			if (count[i] != 0 && count[i] != maxKey) {
				if (count[i] < maxKey) {
					System.out.println("NO");
					return;
				}
				res -= (count[i] - maxKey);
			}
		}

		if (res < 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

	public static boolean testB() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char[] cbuf = new char[255];
			int firstChar = br.read();
			int firstCharLenght = 1;
			Map<Character, Integer> chrMap = new HashMap<Character, Integer>();
			while (br.read(cbuf) != -1) {
				String s = new String(cbuf);
				int lastIndex = s.lastIndexOf(firstChar);
				firstCharLenght += lastIndex == -1 ? 0 : lastIndex;
				if (lastIndex == s.length()) {
					continue;
				} else {// new char.
					while (true) {
						chrMap.put((char) firstChar, firstCharLenght);
						if (!checkTrue(chrMap))
							return false;
						firstCharLenght = 1;
						firstChar = s.charAt(lastIndex + 1);
						if (s.lastIndexOf(firstChar) == cbuf.length) {
							firstCharLenght += cbuf.length - lastIndex;
							break;
						} else {
							firstCharLenght += lastIndex == -1 ? lastIndex++ : lastIndex;
						}
					}
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		}

		return true;
	}

	public static boolean checkTrue(Map<Character, Integer> chrMap) {
		int prevCount = -1;
		boolean found = false;
		for (Entry<Character, Integer> ent : chrMap.entrySet()) {
			if (prevCount == -1)
				prevCount = ent.getValue();
			else if (Math.abs(prevCount - ent.getValue()) > 1)
				return false;
			else if (Math.abs(prevCount - ent.getValue()) != 0 && found) {
				return false;
			} else if (Math.abs(prevCount - ent.getValue()) == 1) {
				found = true;
			}
		}
		return true;
	}

	public static void testA() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char[] buff = new char[255];
			int testCases = Integer.parseInt(br.readLine());
			while (testCases > 0) {
				String output = "";
				char[] xAr = br.readLine().toCharArray();
				char[] yAr = br.readLine().toCharArray();

				int i = 0;
				int j = 0;
				while (i < xAr.length && j < yAr.length) {
					int xAsci = xAr[i];
					int yAsci = yAr[j];
					if (xAsci <= yAsci) {
						output += xAr[i];
						i++;
					} else {
						output += yAr[j];
						j++;
					}
				}

				while (i < xAr.length) {
					output += xAr[i];
					i++;
				}
				while (j < yAr.length) {
					output += yAr[j];
					j++;
				}
				System.out.println(output);
				testCases--;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static String compress(String s) {
		if (s.length() == 1) {
			return s + 1;
		}

		char prev = s.charAt(0);
		int count = 1;
		String compressed = "";
		for (int i = 1; i < s.length(); i++) {
			if (prev == s.charAt(i)) {
				count++;
			} else {
				compressed += prev + "" + count;
				prev = s.charAt(i);
				count = 1;
			}
		}

		return compressed + prev + count;
	}
}
