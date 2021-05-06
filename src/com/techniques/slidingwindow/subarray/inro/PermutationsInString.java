package com.techniques.slidingwindow.subarray.inro;

import java.util.HashMap;
import java.util.Map;

/**
 * find out if the string contains any permutation of the pattern.
 *
 * Permutation is defined as the re-arranging of the characters of the string.
 * @author swamy on 12/13/20
 */
public class PermutationsInString {
    public static void main(String[] args) {


/**
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 *
 *
 */
        String str = "oidbcaf";
        String pattern = "abc";
        Boolean isPerm = findPermutations(str, pattern);
        System.out.println("is Permuation:" + isPerm);
    }

    private static Boolean findPermutations(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for(Character ch: pattern.toCharArray())
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0)+1);
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(charFreqMap.containsKey(rightChar)){
                charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) - 1);
                if(charFreqMap.get(rightChar) == 0)
                    matched++;

            }
            if(matched == charFreqMap.size())
                return true;

            if(windowEnd >= pattern.length() -1){
                char leftChar = str.charAt(windowStart++);
                if(charFreqMap.containsKey(leftChar)){
                    if(charFreqMap.get(leftChar) ==0)
                        matched--;
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
}
