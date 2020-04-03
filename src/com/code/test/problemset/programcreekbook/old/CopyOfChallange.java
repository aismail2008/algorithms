package com.code.test.problemset.programcreekbook.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyOfChallange {
	public static void main(String[] args) {
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			Map<String, List<String>> valuesMap = new HashMap<String, List<String>>();

			String theWord = br.readLine();
			while (!theWord.equalsIgnoreCase("")) {
				char[] chars = theWord.toCharArray();
				Arrays.sort(chars);
				String newWord = new String(chars);

				List<String> match = valuesMap.get(newWord);
				if (match == null) {
					match = new ArrayList<String>();
					match.add(theWord);
				} else {
					match.add(theWord);
				}
				valuesMap.put(newWord, match);
				theWord = br.readLine();
			}

			for (Map.Entry<String, List<String>> entry : valuesMap.entrySet()) {
				List<String> val = entry.getValue();
				for (int i = 0; i < val.size(); i++) {
					System.out.print(val.get(i));
					if (i + 1 < val.size())
						System.out.print(",");
				}
				System.out.println("");
			}

		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
