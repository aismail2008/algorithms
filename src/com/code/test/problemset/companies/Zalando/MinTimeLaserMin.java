package com.code.test.problemset.companies.Zalando;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by aliismail on 19/11/2017.
 */
public class MinTimeLaserMin {

    public static void main(String[] args) {
        Point2D[] A = new Point2D[5];
        A[0] = new Point2D(-1,-2);
        A[1] = new Point2D(1,2);
        A[2] = new Point2D(2,4);
        A[3] = new Point2D(-3,2);
        A[4] = new Point2D(2,-2);
        solution(A);
    }

    public static class Point2D {
        public Point2D (int x, int y){
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;
    }

    public static int solution(Point2D[] A) {

        // write your code in Java SE 8
        Map<String, Integer> uperRight = new HashMap<String, Integer>();
        Map<String, Integer> uperLeft = new HashMap<String, Integer>();
        Map<String, Integer> lowerRight = new HashMap<String, Integer>();
        Map<String, Integer> lowerLeft = new HashMap<String, Integer>();
        for (Point2D p : A) {
            if (p.x > 0 & p.y > 0) {
                double slop = p.y / p.x;
                DecimalFormat df = new DecimalFormat("###.##");
                String s = new String(df.format(slop));
                if (uperRight.containsKey(s))
                    uperRight.put(s, uperRight.get(s) + 1);
                else
                    uperRight.put(s, 1);
            } else if (p.x < 0 & p.y > 0) {
                double slop = p.y / p.x;
                DecimalFormat df = new DecimalFormat("###.##");
                String s = new String(df.format(slop));
                if (uperLeft.containsKey(s))
                    uperLeft.put(s, uperLeft.get(s) + 1);
                else
                    uperLeft.put(s, 1);
            } else if (p.x > 0 & p.y < 0) {
                double slop = p.y / p.x;
                DecimalFormat df = new DecimalFormat("###.##");
                String s = new String(df.format(slop));
                if (lowerRight.containsKey(s))
                    lowerRight.put(s, lowerRight.get(s) + 1);
                else
                    lowerRight.put(s, 1);
            } else if (p.x < 0 & p.y < 0) {
                double slop = p.y / p.x;
                DecimalFormat df = new DecimalFormat("###.##");
                String s = new String(df.format(slop));
                if (lowerLeft.containsKey(s))
                    lowerLeft.put(s, lowerLeft.get(s) + 1);
                else
                    lowerLeft.put(s, 1);
            }
        }

        return uperRight.size() + uperLeft.size() + lowerLeft.size() + lowerRight.size();
    }


    static TreeSet<String> times = new TreeSet<String>();

    public static String solution(int A, int B, int C, int D, int E, int F) {
        permutation("", new String("" + A + B + C + D + E + F));
        if (times.toArray().length == 0)
            return "NOT POSSIBLE";

        String minimum = times.toArray()[0].toString();
        return minimum.substring(0, 2) + ":" + minimum.substring(2, 4) + ":" + minimum.substring(4);

//        String minimum = "";
//        for (Iterator<String> iterator = times.iterator(); iterator.hasNext();) {
//            String s =  iterator.next();
//            if (minimum.length() == 0) {
//                minimum = s;
//            }
//
//            if(s.compareTo(minimum) < 0 )
//                minimum = s;
//        }
//        String time = minimum.substring(0, 2) +":" + minimum.substring(2, 2) +":" + minimum.substring(4);
//        return time;
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            if (isvalidTime(prefix))
                times.add(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    public static boolean isvalidTime(String s) {
        if (s.length() == 0)
            return false;
        int hours = Integer.parseInt(s.substring(0, 2));
        if (hours < 0 || hours > 23)
            return false;
        int min = Integer.parseInt(s.substring(2, 4));
        if (min < 0 || min > 59)
            return false;

        int sec = Integer.parseInt(s.substring(4));
        if (sec < 0 || sec > 59)
            return false;

        return true;
    }
}
