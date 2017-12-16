package com.code.test.problemset.HackerRank;

/**
 * Created by aliismail on 27/11/2017.
 */
public class ING {
//    public static void main(String[] args) {
//        solution(new int{});
//        solution(-2, 16);
//    }

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


    /* Flips a 1 to a 0 and a 0 to a 1 */
    public static int flip(int bit) {
        return 1 ^ bit;
    }

    /* Returns 1 if a is positive, and 0 if a is negative */
    public static int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    public static int getMaxNaive(int a, int b) {
        int k = sign(a - b);
        int q = flip(k);
        return a * k + b * q;
    }

    public static int getMax(int a, int b) {
        int c = a - b;

        int sa = sign(a); // if a >= 0, then 1 else 0
        int sb = sign(b); // if b >= 0, then 1 else 0
        int sc = sign(c); // depends on whether or not a - b overflows

		/* We want to define a value k which is 1 if a > b and 0 if a < b.
		 * (if a = b, it doesn't matter what value k is) */

        int use_sign_of_a = sa ^ sb; // If a and b have different signs, then k = sign(a)
        int use_sign_of_c = flip(sa ^ sb); // If a and b have the same sign, then k = sign(a - b)

		/* We can't use a comparison operator, but we can multiply values by 1 or 0 */
        int k = use_sign_of_a * sa + use_sign_of_c * sc;
        int q = flip(k); // opposite of k

        return a * k + b * q;
    }

    public static void main(String[] args) {
        int a = 26;
        int b = -15;

        System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

        a = -15;
        b = 2147483647;

        System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
    }
}
