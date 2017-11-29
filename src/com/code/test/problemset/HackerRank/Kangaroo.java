package com.code.test.problemset.HackerRank;

/**
 * Created by aliismail on 21/11/2017.
 */
public class Kangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int max = Math.max(x1, x2);
        while (max <= 10000) {
            if (x1 == x2)
                return "YES";

            x1 += v1;
            x2 += v2;
            max = Math.max(x1, x2);
        }
        return "NO";
    }

    static int solve(int n, int[] s, int d, int m) {
        if(n < m)
            return 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += s[i];
        }
        int cnt = 0;

        if(sum == d){
            cnt++;
        }

        for (int i = 1; i < n - m + 1; i++) {
            sum -= s[i - 1];
            sum += s[i + m - 1];
            if(sum == d){
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int x1 = in.nextInt();
//        int v1 = in.nextInt();
//        int x2 = in.nextInt();
//        int v2 = in.nextInt();
//        String result = kangaroo(x1, v1, x2, v2);
//        System.out.println(result);
                            // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8
        solve(19, new int[]{2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1}, 18, 7);
    }
}
