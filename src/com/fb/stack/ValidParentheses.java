package com.fb.stack;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * @author swamy on 2/1/21
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        String s = "(((()))";//""()[]{}";
        boolean isValid =v.valid(s);
        System.out.println(isValid);
    }

    private boolean valid(String s) {
        if(s.length()%2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){

                if( s.charAt(i) == '(')
                    stack.push(')');
                    else if(s.charAt(i) =='{')
                        stack.push('}');
                    else if(s.charAt(i) == '[')
                        stack.push(']');
                    else if(stack.isEmpty() ||stack.pop()!= s.charAt(i))
                        return false;
            }
        return stack.isEmpty();
        }

}
