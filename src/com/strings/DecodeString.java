package com.strings;
/**
 Given an encoded string, return its decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].



 Example 1:

 Input: s = "3[a]2[bc]"
 Output: "aaabcbc"
 Example 2:

 Input: s = "3[a2[c]]"
 Output: "accaccacc"
 Example 3:

 Input: s = "2[abc]3[cd]ef"
 Output: "abcabccdcdcdef"
 Example 4:

 Input: s = "abc3[cd]xyz"
 Output: "abccdcdcdxyz"
 */

import java.util.LinkedList;
import java.util.Queue;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        String  s = "3[a]2[bc]";
       System.out.println( d.decodeString(s));
    }
    public String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            queue.offer(c);
        }

        return dfs(queue);
    }
    public String dfs(Queue<Character> queue) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char c = queue.poll();

            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                String str = dfs(queue);

                for (int i = 0; i < count; i++) {
                    sb.append(str);
                }

                // Note: after use the count, need to reset it. since another number could follow.
                count = 0;

            } else {  // ']'
                break;
            }
        }

        return sb.toString();
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
