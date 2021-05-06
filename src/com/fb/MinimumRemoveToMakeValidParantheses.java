package com.fb;

/**
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * @author swamy on 12/29/20
 */
public class MinimumRemoveToMakeValidParantheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";

       String res= MinimumRemoveToMakeValidParantheses.minRemoveInvalid(s);
       System.out.println(res);
           }

    /**
     * Time: O(N)
     * space: O(N)
     * @param s
     * @return
     */
    private static String minRemoveInvalid(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();

    }

    private static StringBuilder removeInvalidClosing(CharSequence s, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == open){
                balance++;
            }
            if(c == close){
                if(balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }


}
