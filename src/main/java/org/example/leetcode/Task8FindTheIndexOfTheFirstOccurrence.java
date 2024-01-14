package org.example.leetcode;

/**
 * 28. Find the Index of the First Occurrence in a String
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * <p>
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1
 */
public class Task8FindTheIndexOfTheFirstOccurrence {
    public static void main(String[] args) {
        String haystack = "sadtfgsad";
        String needle = "af";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (true) {
            int index = haystack.indexOf(needle);
            return index;
        } else return -1;
    }
}
