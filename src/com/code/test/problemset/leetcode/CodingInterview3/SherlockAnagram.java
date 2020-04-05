package com.code.test.problemset.leetcode.CodingInterview3;

import java.util.Map;

public class SherlockAnagram {
	Map<String, Integer> m;

//	int main()
//	{
//		int t;
//		cin >> t;
//		while (t--)
//		{
//			m.clear();
//			Scanner in = new Scanner(System.in);
//			String s = in.next();
//
//			int len = s.length();
//			for (int i = 0; i < len; i++)
//			{
//				for (int l = 1; i + l - 1 < len; l++)
//				{
//					String t = s.substring(i, l);
//					char[] temp = t.toCharArray();
//					Arrays.sort(temp);
//					t = new String(temp);
//					sort(t.begin(), t.end());
//					m.put(t, m.get(t) == null? 1 : m.get(t)+1);
//				}
//			}
//			long ans = 0;
//			for (map<string, int>::iterator it = m.begin(); it != m.end(); ++it)
//				ans += (long long)(it->second) * (it->second - 1) / 2;
//			cout << ans << endl;
//		}
//		return 0;
//	}
//	
//	public static int countPairs(String str) {
//	    int n = str.length();
//	    if(n < 2) {
//	        return 0;
//	    }
//
//	    int cnt = 0;
//	    char[] tmp = new char[n];
//	    for(int i = 0; i < n; i++) {
//	        int k = 0;
//	        for(int j = i; j < n; j++) {
//	            tmp[k] = str.charAt(j);
//	            tmp[k+1] = '\0';
//
//	            cnt += findPair(str, i+1, tmp, k+1);
//	            k++;
//	        }
//	    }
//	    delete []tmp;
//	    return cnt;
//	}
//	
//	public static boolean isAnagram(int *count1, int *count2) {
//	    for(int i = 0; i < MAX; i++) {
//	        if(count1[i] != count2[i])
//	            return false;
//	    }
//	    return true;
//	}
//
//	public static int findPair(String str, int start, char[] tmp, int n) {
//	    int len = str.length();
//	    if(strlen(tmp) > len-start) {
//	        return 0;
//	    }
//
//	    int[] count1 = new int[26];
//	    int[] count2 = new int[26];
//	    int cnt = 0;
//	    int i;
//	    for(i = 0; i < 26; i++) {
//	        count1[i] = 0; 
//	        count2[i] = 0;
//	    }
//
//	    for(i = 0; i < n && (start+i) < len; i++) {
//	        count1[tmp[i]-'a']++;
//	        count2[str[start+i]-'a']++;
//	    }
//
//	    int j;
//	    for(j = start + i; j < len; j++) {
//	        if(isAnagram(count1, count2)) {
//	            cnt++;
//	        }
//	        count2[str[start]-'a']--;
//	        count2[str[j]-'a']++;
//	        start++;
//	    }
//	    if(j == len) {
//	        if(isAnagram(count1, count2)) {
//	            cnt++;
//	        }
//	    }
//
//	    delete []count1;
//	    delete []count2;
//
//	    return cnt;
//	}
}