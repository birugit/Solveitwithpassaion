package com.fb.strings;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * <p>Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * <p>If the group's length is 1, append the character to s. Otherwise, append the character
 * followed by the group's length. The compressed string s should not be returned separately, but
 * instead be stored in the input character array chars. Note that group lengths that are 10 or
 * longer will be split into multiple characters in chars.
 *
 * <p>After you are done modifying the input array, return the new length of the array.
 *
 * <p>Follow up: Could you solve it using only O(1) extra space?
 *
 * <p>Example 1:
 *
 * <p>Input: chars = ["a","a","b","b","c","c","c"] Output: Return 6, and the first 6 characters of
 * the input array should be: ["a","2","b","2","c","3"] Explanation: The groups are "aa", "bb", and
 * "ccc". This compresses to "a2b2c3".
 *
 * @author swamy on 2/15/21
 */
public class StringCompression {
  public static void main(String[] args) {
      StringCompression s = new StringCompression();
      char[] chars = {'a','a','b','b','c','c','c'};
      int res = s.compress(chars);
      System.out.print(res);
  }

  /**
   * Time Complexity: O(N), where N is the length of chars.
   *
   * <p>Space Complexity: O(1), the space used by read, write, and anchor.
   *
   * @param a
   * @return
   */
  public int compress(char[] a) {
        if(a == null || a.length == 0)
            return 0;
        int count = 1;//represent the times char appears;
        int len = 0;
        for(int i = 1; i <= a.length; i++) {
            if(i < a.length && a[i] == a[i - 1]) {//avoid post processing for last char
                count += 1;
            } else {
                a[len++] = a[i - 1];
                if(count <= 1)
                    continue;//if count freq < 2, do not append; just continue;
                String s = String.valueOf(count);
                for(int k = 0; k < s.length(); k++) {
                    a[len++] = s.charAt(k);
                }
                count = 1;//after append, reset to 1;
            }

        }
        for(int i=0;i<a.length; i++)
            System.out.println(a[i]);
        return len;
    }
}
