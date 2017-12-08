package com.code.test.problemset.HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by aliismail on 16/11/2017.
 */
public class HackerRank {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        int N = Integer.parseInt(line);
//        for (int i = 0; i < N; i++) {
//            System.out.println("hello world");
//        }

        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in.nextInt();
        }

        int apple_cnt = 0;
        for (int i = 0; i < apple.length; i++) {
            if ((apple[i] + a) >= s && (apple[i] + a) <= t)
                apple_cnt++;
        }

        int orange_cnt = 0;
        for (int i = 0; i < orange.length; i++) {
            if ((orange[i] + b) >= s && (orange[i] + b) <= t)
                orange_cnt++;
        }

        System.out.println(apple_cnt);
        System.out.println(orange_cnt);
    }

    public int solution(int[] A) {
        boolean[] ar = new boolean[1000000];
        Arrays.stream(A).forEach(i -> {
            ar[i] = true;
        });
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == false)
                return i;
        }
        return 1000001;
    }

    static int[] getRecord(int[] s){
        int high = s[0];
        int low = s[0];
        int highBeatCount = 0;
        int lowDecreaseCount = 0;
        for(int i = 1; i < s.length; i++){
            if(s[i] > high){
                high = s[i];
                highBeatCount++;
            }

            if(s[i] < low){
                low = s[i];
                lowDecreaseCount++;
            }
        }

        return new int[]{highBeatCount, lowDecreaseCount};
    }



    static void warningCount() {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int d = in.nextInt();
        List<Integer> lst = new ArrayList<>();
        int md = -1;
        int warn = 0;
        while (lst.size() < l) {
            lst.add(in.nextInt());
            int i = lst.size() - 1;
            if (lst.size() > d) {
                md = (i + 1) % 2 == 0 ? (lst.get(i / 2) + lst.get(i / 2 + 1)) / 2 : lst.get(i / 2);
                if (lst.get(i) >= (2 * md)) {
                    warn++;
                }
            }
            Collections.sort(lst);
        }

        System.out.print(warn);
    }

    static String timeConversion(String s) {
        String dayNight = s.substring(8);
        String newTime = "";
        if (dayNight.toUpperCase().equals("PM")) {
            int hours = Integer.parseInt(s.substring(0, 2));
            if (hours == 12)
                newTime = newTime.concat("00");
            else
                newTime = newTime.concat(hours + 12 + "");

            newTime = newTime.concat(s.substring(2, s.length() - 2));
        } else {
            int hours = Integer.parseInt(s.substring(0, 2));
            if (hours == 12) {
                newTime = "00" + newTime.substring(2);

            } else
                newTime = newTime.concat(s.substring(0, s.length() - 2));
        }
        return newTime;
    }

    static int[] solve(int[] grades) {
        int[] newGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 40)
                newGrades[i] = grades[i];
            else {
                if (grades[i] % 5 > 1) {
                    newGrades[i] = grades[i] + 5 - grades[i] % 5;
                }
            }
        }
        return newGrades;
    }


    public static void nonDivisableSet() {
        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
        int n = in.nextInt(); //Integer.parseInt(line.split(" ")[0]);
        int k = in.nextInt(); //Integer.parseInt(line.split(" ")[1]);
//        List<Integer> numbers = Arrays.stream(in.nextLine().split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(in.nextInt());
        }
        List<Integer> solution = new ArrayList<>();
        while (!numbers.isEmpty()) {
            List<Integer> first = new ArrayList<Integer>();
            first.add(numbers.remove(0));
            for (int i = 0; i < numbers.size(); i++) {
                boolean isDivsible = false;
                for (int j = 0; j < first.size(); j++) {
                    if ((numbers.get(i) + first.get(j)) % k == 0) {
                        isDivsible = true;
                        break;
                    }
                }
                if (!isDivsible) {
                    first.add(numbers.remove(i));
                    i--;
                }
            }

            if (first.size() > 1 && first.size() > solution.size())
                solution = new ArrayList<>(first);
        }
        System.out.println(solution.size());
    }


    static String richieRich() {
        // 4 3 1 0 2 1 3 5  ==> k = 3, diff = 2
        // 9             9          1         1
        //       2                  0         0

        // 4 3 1 0 2 1 3 4  ==> k = 2, diff = 1
        //                          1         1
        //       2                  0         0

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        int length = s.length();
        char[] car = s.toCharArray();

        int diff = 0;
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < length / 2; i++) {
            if (car[i] != car[length - 1 - i]) {
                diff++;
                pos.add(i);
            }
        }
        if (k < diff)
            return "-1";
        while (k > diff && diff > 0) {
            int i = pos.remove(0);
            if (car[i] != '9') {
                car[i] = '9';
                k--;
            }
            if (car[length - 1 - i] != '9') {
                car[length - 1 - i] = '9';
                k--;
            }
            diff--;
            //now k is > or = diff
        }

        while (k == diff && diff > 0) {
            int i = pos.remove(0);
            char max = car[i] - car[length - 1 - i] > 0 ? car[i] : car[length - 1 - i];
            if (car[i] != max) {
                car[i] = max;
                k--;
            }
            if (car[length - 1 - i] != max) {
                car[length - 1 - i] = max;
                k--;
            }
            diff--;
            //now k is always -1
        }

        for (int i = 0; i < length / 2 && k > 1; i++) {
            if (car[i] != '9') {
                car[i] = '9';
                car[length - 1 - i] = '9';
                k = k - 2;
            }
        }

        if (k > 1 && length % 2 != 0) {
            car[length / 2] = '9';
        }

        return new String(car);
    }

    public static void plusMinus() {
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine());
        StringTokenizer s = new StringTokenizer(in.nextLine().trim(), " ");
        float pos = 0;
        float neg = 0;
        float nut = 0;
        while (s.hasMoreTokens()) {
            int val = Integer.parseInt(s.nextToken());
            if (val > 0)
                pos++;
            else if (val < 0)
                neg++;
            else
                nut++;
        }

        System.out.println(new Double(pos / number));
        System.out.println(new Double(neg / number));
        System.out.println(new Double(nut / number));
    }
}
