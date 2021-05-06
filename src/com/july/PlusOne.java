package com.july;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        int[] nums = {1,2,3};//129//999
       int[] res= p.plusOne(nums);
       for(int n : res)
           System.out.println(n);
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
            for(int i=n-1; i>=0 ; i--){
                //1.check right most is nine, then set it to 0
                if(digits[i] ==9)
                    digits[i] = 0;
                else{//2. increment by one
                    digits[i]++;
                    return digits;
                }
            }
            //if all numbers are nine s
        //3.add 1 and make remaining numbers 0
            digits = new int[n+1];
            digits[0] = 1;
            return  digits;
    }
}
