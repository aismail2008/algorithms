package com.code.test.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aliismail on 21/11/2017.
 */
public class Kangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int max = Math.max(x1, x2);
        while(max <= 10000){
            if(x1== x2)
                return "YES";

            x1 += v1;
            x2 += v2;
            max = Math.max(x1, x2);
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
