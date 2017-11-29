package com.code.test.problemset.HackerRank;

import java.util.*;

/**
 * Created by aliismail on 19/11/2017.
 */
public class HackerRankBooking {

    public static void main(String[] args) {
        polygon(100, 0, 100, 0);
    }

    static int polygon(int a, int b, int c, int d) {
        if (a < 0 || b < 0 || c < 0 || d < 0)
            return 0;

        if (a == 0 || c == 0)
            return 0;

        if (a == b && b == c && c == d)
            return 2;

        if (a == c && b == d)
            return 1;
        return 0;
    }

    //--------------------------------
    static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
        Set<String> keys = new HashSet<String>();
        String[] spl = keywords.split(" ");
        Arrays.stream(spl).forEach(s -> { //O(M) where M is number of keywords
            keys.add(s.toLowerCase());
        });

        Map<Integer, Integer> countsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < hotel_ids.length; i++) { // O(N * K) where N is number of Reviews and K is max number of words in reviews
            final int[] cnt = {0};

            if (countsMap.containsKey(hotel_ids[i]))
                cnt[0] = countsMap.get(hotel_ids[i]);

            String[] review = reviews[i].split(" ");
            Arrays.stream(review).forEach(r -> {
                if (keys.contains(r.toLowerCase()))
                    cnt[0]++;
            });

            countsMap.put(hotel_ids[i], cnt[0]);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(countsMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() { //	O(h log h) for merge sort where h is number of unique hotels
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) { //O(n log n) for merge sort
            res[i] = list.get(i).getKey();
        }
        return res;
    }
    //--------------------------------

    /**
     * Our customer service team is an important contributor to custer satisfaction. During busy times, however, there might be more calls to
     * customer service than the number of the customer service executives can manage. Fortunately, we record data on that.
     * We've collected info about all phone calls to our call centers for the year .
     * Given that our current number of customer care executives is X, determine how many more people we would need to hire, to make sure
     * that our customers would not have to wait during peak hours (i.e. that we don't have more phone calls than we have customer service exectives)
     * Input:
     * The first line contains the current number of customer service executives X.
     * The second line contains one integer N, N is the number of data points in the data set.
     * The third line contains one integer M, M is the number of integers in each data point (Note, this will always be equal to 2)
     * The next N lines are whitespace separated pairs of timestamps ( a timestamp is an integer that represents the number of seconds since the epoch).
     * On each line, the fist time is the time when the call was started, and the second one is when that end
     * Output:
     * A single integer, representing the number of additional customer service executives that we would need to employ, to cover the call volume during peaks times.
     * If the current coverage is already sufficient,  then print 0
     * Sample input:
     * 1
     * 3
     * 2
     * 1481122000 1481122020
     * 1481122000 1481122040
     * 1481122030 1481122035
     * Sample output:
     * 1
     * Explanation: the first call overlaps with the second call. the third call also overlaps with the second call.
     * However the first and the third are not overlapping with each other .
     * This means that we have at most 2 concurrent calls. Given that there was only 1 customer service executive to stat,
     * we would employs 1 more customer service executive, to be able to ensure that all customer phone calls could be handled
     * as soon as they arrive
     *
     * @param noOfCurrentAgents
     * @param callsTimes
     * @return
     */
    static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        if (callsTimes == null || callsTimes.length == 0)
            return 0;
        int count = 0; //employee count
        Set<Integer> set = new HashSet<>();// answered phone calls
        while (set.size() < callsTimes.length) { // will be O(N^2) n is first dimension of call times as worst case if all calls are in same time
            int[] prev = null;//currently answering
            for (int i = 0; i < callsTimes.length; i++) {
                if (set.contains(i))
                    continue;
                if (prev == null) {
                    prev = callsTimes[i];
                    set.add(i);
                } else if (callsTimes[i][0] > prev[1]) {
                    set.add(i);
                    prev = callsTimes[i];
                }
            }
            count++;
        }
        if (noOfCurrentAgents > count)
            return 0;
        return count - noOfCurrentAgents;
    }

    static int[] delta_encode(int[] a) {
        int[] rs = new int[a.length * 2];
        int j = 0;
        rs[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            int diff = a[i] - a[i - 1];
            if (diff > 127 || diff < -127) {
                rs[j++] = -128;
                rs[j++] = a[i];
            } else
                rs[j++] = a[i];
        }
        return Arrays.copyOf(rs, j);
    }
}
