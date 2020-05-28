package com.code.test.problemset.companies.adyen;

public class Nails {
    public int solution(int[] arr, int y) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = 1;

            while (i + 1 < arr.length && arr[i] == arr[i+1]) {
                curr++;
                i++;
            }
            if(i != arr.length - 1)
                curr += i + y <= arr.length - 1 ? y : arr.length - i - 1;
            maxLength = Math.max(curr, maxLength);
        }
        System.out.println(maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        new Nails().solution(new int[]{1}, 5);
    }
}
