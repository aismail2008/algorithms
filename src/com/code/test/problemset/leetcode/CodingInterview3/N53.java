package com.code.test.problemset.leetcode.CodingInterview3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aliismail on 17/12/2017.
 */
public class N53 {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"DoctorWho", "Torchwood"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            str = str.toLowerCase();
            int[] arr = new int[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }

            StringBuilder ns = new StringBuilder("");
            int a = 'a';
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > 0){
                    char ch =  (char)(i + a);
                    ns.append(ch + "" + arr[i]);
                }
            }

            if(map.containsKey(ns.toString())){
                map.get(ns.toString()).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns.toString(), al);
            }
        }

        result.addAll(map.values());

        return result;
    }
}
