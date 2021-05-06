package com.techniques.slidingwindow.subarray.inro;

import java.util.HashMap;
import java.util.Map;

/**
 * @author swamy on 12/13/20
 */
public class CharacterReplacement {
    public static void main(String[] args) {
      /**  String str = "aabccbb";
        int k = 2;
        **/
        /**
        Input: String="abccde", k=1
        Output: 3
        Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
       */
        String str = "abccde";
        int k = 1;
       int len = findLength(str, k);
       System.out.println(len);
    }

    private static int findLength(String str, int k) {
        int windowStart = 0, maxLen = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFreqMap.put(rightChar, letterFreqMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFreqMap.get(rightChar));


            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFreqMap.put(leftChar, letterFreqMap.get(leftChar) - 1);
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }


}
