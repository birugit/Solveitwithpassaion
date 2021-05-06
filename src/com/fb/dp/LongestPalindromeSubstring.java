package com.fb.dp;

/**
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * @author swamy on 1/11/21
 *
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        LongestPalindromeSubstring l = new LongestPalindromeSubstring();
        String s = "babad";
        String res =l.longestPalindrome(s);
        System.out.println(res);
    }
    public String longestPalindrome(String s) {
//using Mancher's algorithim

        char[]    t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';

        int[]  p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*center - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);

            // attempt to expand palindrome centered at i
            System.out.println(t[i + (1 + p[i])]);
            System.out.println(t[i - (1 + p[i])]);
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        int length = 0;   // length of longest palindromic substring
        //  int center = 0;   // center of longest palindromic substring
        for (int i = 1; i < p.length-1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);

    }
}
