package com.fb.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * @author swamy on 1/12/21
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String  s= "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean isWordbreak = w.wordBreak(s, wordDict);
        System.out.println(isWordbreak);
    }

    /**
     * Time: N for lenght of String
     *       N for for loop of each word break
     *       N for substring
     *       N * N * N * = O(N^3)
     *
     *       Space: o(N)
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
