package com.fb;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 * @author swamy on 1/10/21
 */
public class WordLadder {
    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        String beginWord = "hit";
        String		endWord = "cog";
        List<String>		wordList = new ArrayList<String>();// {"hot","dot","dog","lot","log","cog"};
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        //BFS Bidriectional
        System.out.println(	w.ladderLength(beginWord, endWord, wordList));

        //Word Ladder II -- Find the path
     ////   System.out.println(w.ladderLength(beginWord, endWord, wordList));
    }

    /**
     * Time: O(M^2 * N)
     * Space: O(M * N)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.isEmpty())
            return 0;


        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        return biBfs(beginSet, endSet, wordSet, 1);
    }

    public int biBfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int length) {
        if(beginSet.size() == 0 || endSet.size() == 0)
            return 0;

        if(beginSet.size() > endSet.size())
            return biBfs(endSet, beginSet, wordSet, length);

        Set<String> nextSeq = new HashSet<>();
        wordSet.removeAll(beginSet);

        for(String word : beginSet) {
            char[] charSet = word.toCharArray();
            for(int i=0; i<charSet.length; i++) {
                char ch = charSet[i];
                for(char j='a'; j<='z'; j++) {
                    charSet[i] = j;
                   String newWord = new String(charSet);
                    if(wordSet.contains(newWord)) {
                        if(endSet.contains(newWord))
                            return length + 1;
                        nextSeq.add(newWord);
                    }
                }
                charSet[i] = ch;
            }
        }
        if(!nextSeq.isEmpty())
            return biBfs(nextSeq, endSet, wordSet, length+1);
        return 0;
    }
}

