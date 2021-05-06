package com.techniques.slidingwindow.subarray.inro;

import java.util.HashMap;
import java.util.Map;

/**
 * find the length of the longest substring which has no repeating characters
 * @author swamy on 12/13/20
 */
public class NoRepeatingSubstring {
    public static void main(String[] args) {
        String str = "aabccbb";
        //Output: 3
        //Explanation: The longest substring without any repeating characters is "abc".
        int len = findLengthOfLongestSubWithNoRepeatingChar(str);
        System.out.println(len);
    }

    private static int findLengthOfLongestSubWithNoRepeatingChar(String str) {
        int maxLen = 0, windowStart = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }
}
