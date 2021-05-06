package com.fb.strings;

import java.util.Arrays;

/**
 * @author swamy on 2/21/21
 */
public class ValidAnagram {
  public static void main(String[] args) {
      ValidAnagram v = new ValidAnagram();
 //     boolean isValid = v.isValidAnagram("anagram","nagaram");
      boolean isValid = v.isAnagramSort("anagram", "nagaram");
      System.out.println(isValid);
  }

    /**
     * T:O(N)//accessing counter table in constant time operations
     * s:O(1)//although we use extra space for hsh its constant, it wont grow much
     * @param s
     * @param t
     * @return
     */
  boolean isValidAnagram(String s, String t){
      if(s.length()!= t.length()){
          return false;
      }else{
          int[] count = new int[26];
          for(int i=0; i<s.length(); i++){
              count[s.charAt(i)-'a']++;
              count[t.charAt(i)-'a']--;
          }

          for(int cnt:count){
              if(cnt!=0){
                  return false;
              }
          }
      }

      return true;
  }

  /**
   * T: O(nlogn)sorting time takes O(nlogn)
   * S:O(1) O(1).
   * Space depends on the sorting implementation
   * which, usually, costs O(1)O(1) auxiliary space if heapsort is used. Note that in Java,
   * toCharArray() makes a copy of the string so it costs O(n)O(n) extra space, but we ignore this
   * for complexity analysis because:
   *
   * <p>It is a language dependent detail. It depends on how the function is designed. For example,
   * the function parameter types can be changed to char[].
   *
   * @param s
   * @param t
   * @return
   */
  boolean isAnagramSort(String s, String t) {
      if(s.length() != t.length())
          return false;
      char[] s1 = s.toCharArray();
      char[] t1 = t.toCharArray();
    Arrays.sort(s1);
    Arrays.sort(t1);
      return Arrays.equals(s1,t1);
  }
}
