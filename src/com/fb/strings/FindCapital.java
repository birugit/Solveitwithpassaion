package com.fb.strings;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * <p>We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * <p>All letters in this word are capitals, like "USA". All letters in this word are not capitals,
 * like "leetcode". Only the first letter in this word is capital, like "Google". Otherwise, we
 * define that this word doesn't use capitals in a right way.
 *
 * <p>Example 1:
 *
 * <p>Input: "USA" Output: True
 *
 * <p>Example 2:
 *
 * <p>Input: "FlaG" Output: False
 *
 * @author swamy on 3/12/21
 */
public class FindCapital {
  public static void main(String[] args) {
    boolean res = detectCapitalRegex("USA");
    System.out.println(res);
  }

  /**
   * The pattern of case 1 in regex is [A-Z]*[A−Z]∗, where [A-Z][A−Z] matches one char from 'A' to
   * 'Z', *∗ represents repeat the pattern before it at least 0 times. Therefore, this pattern
   * represents "All capital".
   *
   * <p>The pattern of case 2 in regex is [a-z]*[a−z]∗, where similarly, [a-z][a−z] matches one char
   * from 'a' to 'z'. Therefore, this pattern represents "All not capital".
   *
   * <p>Similarly, the pattern of case 3 in regex is [A-Z][a-z]*[A−Z][a−z]∗.
   *
   * <p>Take these three pattern together, we have
   * [A-Z]*|[a-z]*|[A-Z][a-z]*[A−Z]∗∣[a−z]∗∣[A−Z][a−z]∗, where "|" represents "or".
   *
   * <p>Still, we can combine case 2 and case 3, and we get .[a-z]*.[a−z]∗, where "." can matches
   * any char.
   *
   * <p>Therefore, the final pattern is [A-Z]*|.[a-z]*[A−Z]∗∣.[a−z]∗. Time complexity: Basically
   * O(n)O(n), but depends on implementation.
   *
   * <p>Space complexity : O(1)O(1). We only need constant spaces to store our pattern.
   *
   * @param word
   * @return
   */
  private static boolean detectCapitalRegex(String word) {

    return word.matches("[A-Z]*|.[a-z]*");
    }
}
