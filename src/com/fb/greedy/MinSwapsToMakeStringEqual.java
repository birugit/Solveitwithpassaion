package com.fb.greedy;

/**
 * You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. Your
 * task is to make these two strings equal to each other. You can swap any two characters that
 * belong to different strings, which means: swap s1[i] and s2[j].
 *
 * <p>Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is
 * impossible to do so.
 *
 * <p>Example 1:
 *
 * <p>Input: s1 = "xx", s2 = "yy"
 * Output: 1 Explanation: Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
 *
 * @author swamy on 2/24/21
 */
public class MinSwapsToMakeStringEqual {
  public static void main(String[] args) {
      MinSwapsToMakeStringEqual m = new MinSwapsToMakeStringEqual();
      String s1= "xx", s2 = "yy";
      int res = m.minimumSwapSame(s1, s2);
      System.out.println(res);

  }

    public int minimumSwap(String s1, String s2) {
        int x1 = 0; // number of 'x' in s1 (skip equal chars at same index)
        int y1 = 0; // number of 'y' in s1 (skip equal chars at same index)
        int x2 = 0; // number of 'x' in s2 (skip equal chars at same index)
        int y2 = 0; // number of 'y' in s2 (skip equal chars at same index)

        for(int i = 0; i < s1.length(); i ++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 == c2){ // skip chars that are equal at the same index in s1 and s2
                continue;
            }
            if(c1 == 'x'){
                x1 ++;
            }else{
                y1 ++;
            }
            if(c2 == 'x'){
                x2 ++;
            }else{
                y2 ++;
            }
        } // end for

        // After skip "c1 == c2", check the number of  'x' and 'y' left in s1 and s2.
        if((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0){
            return -1; // if number of 'x' or 'y' is odd, we can not make s1 equals to s2
        }

        int swaps = x1 / 2 + y1 / 2 + (x1 % 2) * 2;
        // Cases to do 1 swap:
        // "xx" => x1 / 2 => how many pairs of 'x' we have ?
        // "yy" => y1 / 2 => how many pairs of 'y' we have ?
        //
        // Cases to do 2 swaps:
        // "xy" or "yx" =>  x1 % 2

        return swaps;
    }

  /**
   * Observation from given example case 1: xx yy => minimum swap is 1
   *
   * <p>case 2: xy yx => minimum swap is 2
   *
   * <p>case 3: xx xy => not possible [If we have odd no of sum of x/y in both strings then it is
   * impossible to make them equal ]
   *
   * <p>Steps: 1. Find sum of x and y in both string, return -1 if case 3 [We can ignore count of x
   * and y which are equal on same index in both string] 2. Reduce the problem to case 1 and case 2.
   *
   * <p>Eg: s1= xxyyxyxyxx s2= xyyxyxxxyx
   *
   * <p>step 1: xs1 =3, ys1=3 xs2 =3, ys2=3
   *
   * <p>step 2:
   *
   * <p>> now we can try to reduce problem to case1 and case 2, as there sum is even we can run loop
   * by subtracting 2 with each [adding 1 to answer , see code below]
   *
   * <p>> we will left with xs1 =1, ys1=1, xs2 =1, ys2=1 => case 2 [add two to answer]
   *
   * @param s1
   * @param s2
   * @return
   */

  // we are looking at string s1. x1/2 represents the number of pairs of x,
  // y1/2 represents the number of pairs of y.
  // this is the case1, which requires one swap for each pair,
  // x1 % 2 represents the remaining number of x, which is the case2. and it requires 2 swaps.

  public int minimumSwapSame(String s1, String s2) {
        int xy = 0, yx = 0;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; ++i) {
            if (c1[i] == c2[i]) continue;// // skip chars that are equal at the same index in s1 and s2
            if (c1[i] == 'x') xy++;
            else yx++;
        }
        return
                (xy + yx) % 2 //odd combination of x n y
                        == 1 ? -1 :
                        xy / 2 //number of x pairs
                                + yx / 2 //number y pairs
                                + xy % 2 + yx % 2;//remaining x n y, this required two swaps
    }

}