package com.code.test.problemset.leetcode;

/**
 * 􏰲􏰣􏰴􏰵􏰭􏰶 Search in Rotated Sorted Array II
 * 􏰷􏰕
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * https://leetcode.com/problems/search-in-rotated-sorted-array􏰳􏰰􏰸􏰴􏰸􏰣􏰹 􏰈􏰂􏰂􏰀􏰅􏰉 􏰈􏰃􏰠􏰂􏰌 􏰉 􏰺􏰻􏰼􏰽􏰾􏰶 􏰨􏰼􏰼􏰉􏰿 􏰂􏱀 􏰌 􏰆􏰌􏰚􏰅􏰁􏰅􏰍􏰊 􏱁􏱂􏰇􏱁 􏱂􏱃􏰕 􏰀􏰅􏰅􏰌 􏱄􏱅􏱆􏱇􏱆􏱈􏱉 􏱃􏱊 􏱋􏱊􏱌􏱍􏱅􏱎􏱍 􏰃􏱏􏰊􏰓􏰀􏰆 􏰲􏱐 􏰈􏰁􏰊􏰅􏰚􏱑 􏰏􏱒􏰁􏰬􏰅 􏰭􏰲􏰠􏰅 􏰈􏰵 􏱓􏱔􏰠 􏰉􏰄 􏱕􏱖􏰀􏰊􏰞􏰃􏰈 􏰁􏰃 􏱗􏰋􏰞 􏰉􏱘􏱙􏰑􏱚􏱛 􏱜􏱝􏱞 􏰊􏰑􏱚 􏱟􏱠􏱠􏱞􏱡􏱢 􏱣􏱤􏰑􏱣 􏱥􏱤􏱢 􏰑􏱦􏱧􏰑􏱨 􏰏􏰑􏱠 􏰂􏰘􏱩􏰥􏱪􏰄􏰇􏰍􏰍􏰡 􏰌􏰻􏰆􏰈􏰅􏰠 􏰄􏰌 􏰁􏰃􏰭􏰷􏰞􏰉􏰚􏱫􏰄􏰥 􏰂􏰷􏰠􏰅􏰆􏰰
 */
public class Q45_SearchInRotatedArrayII {

    public static void main(String[] args) {
        System.out.println(new Q45_SearchInRotatedArrayII().search(new int[]{3, 1, 1}, 0));
        System.out.println(new Q45_SearchInRotatedArrayII().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(new Q45_SearchInRotatedArrayII().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }


    boolean search(int a[], int x) {
        return index(a, 0, a.length - 1, x);
    }

    boolean index(int[] a, int low, int high, int x) {
        if (low > high)
            return false;
        if (low == high && a[low] != x)
            return false;

        int mid = low + (high - low) / 2;
        if (a[mid] == x) {
            return true;
        }

        if (a[mid] == a[low]) {
            while (a[mid] == a[low] && mid != low)
                low++;
            return index(a, mid != low ? low : low + 1, high, x);
        } else if (a[mid] == a[high]) {
            while (a[mid] == a[high] && mid != high)
                high--;
            return index(a, low, mid != high ? high : high - 1, x);
        }

        if (a[low] < a[mid]) { //left sorted
            if (x < a[mid] && x >= a[low]) {
                return index(a, low, mid - 1, x);
            } else {
                return index(a, mid + 1, high, x);
            }
        } else { //right sorted
            if (x > a[mid] && x <= a[high]) {
                return index(a, mid + 1, high, x);
            } else {
                return index(a, low, mid - 1, x);
            }
        }
    }
}
