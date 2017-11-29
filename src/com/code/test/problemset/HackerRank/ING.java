package com.code.test.problemset.HackerRank;

/**
 * Created by aliismail on 27/11/2017.
 */
public class ING {
    public static void main(String[] args) {
//        solution(new int{});
        solution(-2, 16);
    }

    //1
    public static int solution(int A, int B) {
        // write your code in Java SE 8
        if (A == 0 && B == 0)
            return 1;
        if (B < 0)
            return 0;

        double start = A;
        if (A > 0)
            start = (int) Math.sqrt(A);

        int end = (int) Math.sqrt(B);

        int cnt = 0;
        for (; start <= end; start++) {
            int p = (int) Math.pow(start, 2);
            if (p >= A && p <= B)
                cnt++;
        }
        return cnt;
    }
    //3
    static int solution(int N) {
        int largest = N;
        int shift = 0;
        int temp = N;
        for (int i = 1; i < 30; i++) {
            int index = (temp & 1);//most right bit
            temp = ((temp >> 1) | (index << 29));
            if (temp > largest) {
                largest = temp;
                shift = i;
            }
        }
        return shift;
    }

    //2
    public int solution(int[] A) {
        int max = 1;
        int[] v = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            int count = 0;
            int ind = i;
            while ((0 < A[ind] && A[ind] < A.length)) {
                ++count;
                v[ind] = 1;//visited
                ind = A[ind];
                if (v[ind] > 0) {
                    count += v[ind];
                    break;
                }
            }
            if (A[ind] >= A.length) {
                count++;
            }
            v[i] = count;
            max = Math.max(max, count);
        }

        return max;
    }
}
