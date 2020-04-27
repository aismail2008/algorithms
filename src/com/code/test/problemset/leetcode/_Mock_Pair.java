package com.code.test.problemset.leetcode;

import java.io.*;
import java.util.*;

class Solution {

    /*
    [1487799425, 14, 1], 14 i =0
    [1487799425, 4,  0], 10
    [1487799425, 8,  1],  8 i

    [1487800378, 10, 1],  18

    [1487801478, 18, 0], 0
    [1487801478, 18, 1], 18

    [1487901013, 1,  0], 17

    [1487901211, 7,  1], 24
    [1487901211, 7,  0]  17
     */
    static int findBusiestPeriod(int[][] data) {
        // your code goes here
        int max = Integer.MIN_VALUE;
        int maxTS = 0;
        int total = 0;
        for(int i = 0; i < data.length; i ++){
            if(data[i][2] == 1){
                total += data[i][1];
            }else{
                total -= data[i][1];
            }
            // compare current with the next one
            if(i + 1 < data.length && data[i][0] == data[i+1][0]){
                continue;
            }

            if(total > max){
                max = total;
                maxTS = data[i][0];
            }
        }
        //data.length-1

        return maxTS;
    }

    public static void main(String[] args) {

    }

}