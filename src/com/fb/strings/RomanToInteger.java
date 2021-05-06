package com.fb.strings;

/**
 * @author swamy on 2/13/21
 */
public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        String s = "LVIII";
        //Output: 58
        //Explanation: L = 50, V= 5, III = 3.
        int res = r.romanToInt(s);
        System.out.println(res);
    }
    public int romanToInt(String s) {
        int total = 0;
        int prevVal = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int currVal = 0;
            char curr = s.charAt(i);
            switch(curr) {
                case 'I':
                    currVal = 1;
                    break;
                case 'V':
                    currVal = 5;
                    break;
                case 'X':
                    currVal = 10;
                    break;
                case 'L':
                    currVal = 50;
                    break;
                case 'C':
                    currVal = 100;
                    break;
                case 'D':
                    currVal = 500;
                    break;
                case 'M':
                    currVal = 1000;
                    break;
            }
            if(prevVal != 0 && currVal < prevVal) {
                total -= currVal;
            } else {
                total += currVal;
            }
            prevVal = currVal;
        }
        return total;
    }
}
