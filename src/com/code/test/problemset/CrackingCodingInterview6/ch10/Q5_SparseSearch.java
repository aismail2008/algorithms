package com.code.test.problemset.CrackingCodingInterview6.ch10;

/**
 * Sparse Search:
 * Given a sorted array of strings that is interspersed with empty strings, write a
 * method to find the location of a given string.
 * EXAMPLE
 * Input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 * Output: 4
 *
 *
 */
public class Q5_SparseSearch {
    public static int search(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }

        /* Move mid to the middle */
        int mid = (last + first) / 2;

        /* If mid is empty, find closest non-empty string. */
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        /* Check for string, and recurse if necessary */
        if (str.equals(strings[mid])) { // Found it!
            return mid;
        } else if (strings[mid].compareTo(str) < 0) { // Search right
            return search(strings, str, mid + 1, last);
        } else { // Search left
            return search(strings, str, first, mid - 1);
        }
    }

    public static int search(String[] strings, String str) {
        if (strings == null || str == null || str.isEmpty()) {
            return -1;
        }
        return search(strings, str, 0, strings.length - 1);
    }

    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "ac"));
    }
}
