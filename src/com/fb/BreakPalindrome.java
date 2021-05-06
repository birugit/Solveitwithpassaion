package com.fb;

/**
 * @author swamy on 1/28/21
 */
public class BreakPalindrome {
    public static void main(String[] args) {
        BreakPalindrome b = new BreakPalindrome();
 String s = "abccba";// "aabaa";// -> "aaaaa"
        String res = b.breakPalindrome(s);
        System.out.print(res);

    }

    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1)
            return "";
        char[] arr = palindrome.toCharArray();

        for(int i=0; i<arr.length/2;i++){
            if(arr[i] != 'a'){ // if not a then change it to be lexographically smallest
                arr[i] = 'a';
                return String.valueOf(arr);
            }
        }
        // if we reach here, there are ONLY 'a' in palindrome string, so we should change the last character to a b
        arr[arr.length-1] = 'b';
        return String.valueOf(arr);
    }
}
