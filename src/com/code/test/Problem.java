package com.code.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problem {
    class MyCalendarTwo {

        ArrayList<int[]> calendarList = new ArrayList<>();
        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            if(calendarList.isEmpty())
                calendarList.add(new int[]{start, end});
            int count = 0;
            for(int[] n : calendarList){
                if ((start > n[0] && start < n[1])
                        || (end > n[0] && end < n[1])
                        || (start < n[0] && end > n[1])
                        || (n[0] < start && n[1] > end)){

                    count++;
                }
                if(count > 2)
                    return false;
            }
            calendarList.add(new int[]{start, end});
            return true;
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}