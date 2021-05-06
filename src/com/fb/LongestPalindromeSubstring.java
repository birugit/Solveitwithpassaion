package com.fb;

/**
 *
 *  Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 * @author swamy on 12/31/20
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        LongestPalindromeSubstring l = new LongestPalindromeSubstring();
        String s = "babad";//"cbbd";
        String palindrome = l.longestPalindrome(s);
        System.out.println(palindrome);
    }

    int startIndex = 0;
    int endIndex = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int n = s.length();

        char ss[] = s.toCharArray();
        int i = 0;
        while (i < n) {
            i = expansion(ss, i);
        }

        return s.substring(startIndex, endIndex + 1);
    }

    public int expansion(char[] ss, int start) {
        int nextSt = start + 1;
        int size = ss.length;

        while (start >= 0 && nextSt < size && ss[start] == ss[nextSt])
            nextSt++;
        int end = nextSt - 1;

        while (start - 1 >= 0 && end + 1 < size && ss[start - 1] == ss[end + 1]) {
            start--;
            end++;
        }

        if ((endIndex - startIndex) < (end - start)) {
            endIndex = end;
            startIndex = start;
        }

        return nextSt;
    }
}
