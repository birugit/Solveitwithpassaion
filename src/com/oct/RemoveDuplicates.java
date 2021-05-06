package com.oct;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * @author swamy on 10/12/20
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        String res = r.removeDuplicateLetters("bcabc");
        System.out.println(res);
    }


    public String removeDuplicateLetters(String s) {

        int[] res = new int[26]; // will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; // will contain if character ('a' + i) is present in current result Stack
        char[] ch = s.toCharArray();
        for (char c : ch) {  // count number of occurences of character
            res[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        ; // answer stack
        int index;
        for (char c : ch) {
            index = c - 'a';
            res[index]--;   // decrement number of characters remaining in the string to be analysed
            if (visited[index]) // if character is already present in stack, dont bother
                continue;
            // if current character is smaller than last character in stack which occurs later in the string again
            // it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while ((sb.length() > 0) && c < sb.charAt(sb.length() - 1) && res[sb.charAt(sb.length() - 1) - 'a'] != 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c); // add current character and mark it as visited
            visited[index] = true;
        }

        return sb.toString();

    }
}