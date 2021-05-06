package com.techniques.slidingwindow.subarray.inro;

import java.util.HashMap;
import java.util.Map;

/**
 * find the length of the longest substring in it with no more than K distinct characters.
 * @author swamy on 12/13/20
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 */
public class LongestSubArrayWithKDistinctChar {
    public static void main(String[] args) {
        String str = "araaci";
        int k = 2;
        int len = findLongestSubArry(str, k);
        System.out.println(len);
        }

    /**time : O(N)
     * outer loop runs for each element and inner while loop runs only once for each elem
     * O(N+N) = O(N) asymptotically
     * Space: O(K)
     * storing K+ 1 characters in HashMap
     *
     * @param str
     * @param k
     * @return
     */
    private static int findLongestSubArry(String str, int k) {
        int maxLen = 0, windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            while (freqMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                freqMap.put(leftChar, freqMap.getOrDefault(leftChar, 0) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;

    }


}
