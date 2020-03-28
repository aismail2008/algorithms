package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.List;

/**
 * Created by aliismail on 27/11/2017.
 */
public class N26 {
    //bottem up approach is the correct one
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        int l = triangle.size() - 1;
        for (int i = 0; i < triangle.get(l).size(); i++) {
            total[i] = triangle.get(l).get(i);
        }
        // iterate from last second row
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }
        return total[0];
    }
}
