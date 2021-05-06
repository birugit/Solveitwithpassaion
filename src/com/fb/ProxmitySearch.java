package com.fb;

/**
 * Minimum Distance Between Words of a String Given a string s and two words w1 and w2 that are
 * present in S. The task is to find the minimum distance between w1 and w2. Here distance is the
 * number of steps or words between the first and the second word. Examples:
 *
 * <p>Input : s = “geeks for geeks contribute practice”, w1 = “geeks”, w2 = “practice” Output : 1
 *
 * @author swamy on 2/16/21
 */
public class ProxmitySearch {
  public static void main(String[] args) {
      String s = "geeks for geeks contribute practice";
      String w1 = "geeks";
      String w2 = "practice";
      System.out.println(distance(s, w1, w2));
  }
    static int distance(String s, String w1, String w2) {

        if (w1.equals(w2)) {
            return 0;
        }

        // get individual words in a list
        String[] words = s.split(" ");
        int n = words.length;

        // assume total length of the string as
        // minimum distance
        int min_dist = n + 1;

        // Find the first occurrence of any of the two
        // numbers (w1 or w2) and store the index of
        // this occurrence in prev
        int prev = 0, i = 0;
        for (i = 0; i < n; i++) {

            if (words[i].equals(w1) || words[i].equals(w2)) {
                prev = i;
                break;
            }
        }
        // Traverse after the first occurrence
        while (i < n) {
            if (words[i].equals(w1) || words[i].equals(w2)) {

                // If the current element matches with
                // any of the two then check if current
                // element and prev element are different
                // Also check if this value is smaller than
                // minimum distance so far
                if ((!words[prev].equals(words[i])) && (i - prev) < min_dist) {
                    min_dist = i - prev - 1;
                    prev = i;
                } else {
                    prev = i;
                }

            }
            i += 1;

        }
        return min_dist;
    }
}
