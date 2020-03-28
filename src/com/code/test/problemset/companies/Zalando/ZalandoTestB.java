package com.code.test.problemset.companies.Zalando;

import java.io.IOException;

public class ZalandoTestB {

	public static void main(String[] args) throws IOException {
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

		solution(100000000, 100000000);

	}

	public static int solution(int A, int B) {
		String strA = "" + A;
		int aLen = strA.length();
		String strB = "" + B;
		int bLen = strB.length();
		String strC = new String();

		int i;
		for (i = 0; i < Math.min(aLen, bLen); i++) {
			strC += strA.charAt(i) + "" + strB.charAt(i);
		}

		if (aLen > bLen) {
			while (i < strA.length()) {
				strC += strA.charAt(i);
				i++;
			}
		} else {
			while (i < strB.length()) {
				strC += strB.charAt(i);
				i++;
			}
		}

		int result = Long.valueOf(strC) > 100000000L ? -1 : Integer.valueOf(strC);
		return result ;
	}
}
