package com.fb.slidingwindow;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 *
 * @author swamy on 2/16/21
 */
public class LengthOfLongestSubString {
  public static void main(String[] args) {
      LengthOfLongestSubString l = new LengthOfLongestSubString();
      String s = "abcabcbb";
      int len = l.lengthOfLongestSubstring(s);
      System.out.println(len);
  }

    /**
     * Sliding Window Optimized
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

   /* public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Integer[] chars = new Integer[128]; // current index of character
        // try to extend the range [i, j]
        int left = 0, right = 0, res = 0;
        while(right<s.length()){
            char r = s.charAt(right);
            Integer index = chars[r];
            if(index != null && index >= left  && index < right )
                left = index + 1;
            res = Math.max(res, right - left + 1);
            chars[r] = right;
            right++;

        }
        return res;
    }*/
}
