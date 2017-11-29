package com.code.test.problemset.book.CodingInterview3;

import oracle.sql.CHAR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aliismail on 27/11/2017.
 */
public class N23_ {
    //not so clear
    public static void main(String[] args) {
        convertAli("PAYPALISHIRING",3);
    }

    static public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        // step
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            //first & last rows
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + step) {
                    sb.append(s.charAt(j));
                }
                //middle rows
            } else {
                int j = i;
                boolean flag = true;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    if (flag)
                        j = j + step1;
                    else
                        j = j + step2;
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

    static public void convertAli(String s, int numRows) {
        int index = 0;
        List<List<Character>> all = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<Character> col = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                col.add(s.charAt(index++));
            }
            all.add(col);
//            middle
            List<Character> mid = new ArrayList<>();
            for (int j = 0; j < numRows - 2; j++) {
                mid.add(s.charAt(index++));
            }
            all.add(mid);
        }
        Character[][] mat = new Character[numRows][];
        Arrays.fill(mat, " ");
        //printing
        int mod = 0;
        int j = 0;
        for (List<Character> col : all) {
            int i = 0;
            if (mod == 0) {
                for (char c : col) {
                    mat[i++][j] = c;
                }
                mod = 1;
            }
            if (mod == 1) {
                for (char c : col) {
                    mat[--i][++j] = c;
                }
                mod = 0;
            }
        }
        for(Character[] c : mat){
            Arrays.stream(c).forEach(System.out::print);
            System.out.println();
        }
//        then print a[][]// skipping empty slots
    }
}