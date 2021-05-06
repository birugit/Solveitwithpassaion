package com.july;

import java.math.BigInteger;

/**
 Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "11", b = "1";
        String res =AddBinary.addBinaryUsingInteger(a, b);
        System.out.println(res);

        System.out.println(AddBinary.addBinaryBitManipulation(a, b));
    }
//works only for single digits, if number is big,it wont fit in memory
    /*
    T: O(N+M)
     */
    public static String addBinaryUsingInteger(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

/*
T: O(N+M)
S: O(max(N,M)
 */
    public static String addBinaryBitManipulation(String a, String b) {
        //Convert a and b into integers x and y, x will be used to keep an answer, and y for the carry.
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {//While carry is nonzero: y != 0:
            answer = x.xor(y);//Current answer without carry is XOR of x and y: answer = x^y.
            carry = x.and(y).shiftLeft(1);//Current carry is left-shifted AND of x and y: carry = (x & y) << 1.
            x = answer;//Job is done, prepare the next loop: x = answer, y = carry.
            y = carry;
        }
        return x.toString(2);
    }
}
