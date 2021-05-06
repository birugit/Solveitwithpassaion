package com.aug;

/**
 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 Example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        System.out.println(w.search("pad"));// -> false
        System.out.println(w.search("bad"));//-> true
        System.out.println(w.search(".ad"));// -> true
        System.out.println(w.search("b.."));// -> true


    }

    TrieNode root ;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(null);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++) {
            Character ch = word.charAt(i);
            TrieNode child = current.children[ch-'a'];
            if(child == null)
                child = new TrieNode(ch);
            current.children[ch-'a'] = child;
            current = child;
        }
        current.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchUtil(root, word, 0);
    }

    private boolean searchUtil(TrieNode current, String word, int index) {
        if(index == word.length()) {
            return current.isEnd ? true : false;
        }
        Character ch = word.charAt(index);
        if(ch == '.') {
            //    System.out.println("At index found . " + index);
            for(TrieNode child : current.children) {
                if(child != null && searchUtil(child, word, index+1)) {
                    //    System.out.println("Child is " + child.ch);
                    return true;
                }
            }
            return false;
        }else {
            TrieNode child = current.children[ch-'a'];
            if(child == null)
                return false;
            else
                return searchUtil(child, word, index+1);
        }

    }
}

class TrieNode {
    Character ch;
    TrieNode[] children;
    boolean isEnd;
    TrieNode(Character ch) {
        this.ch = ch;
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}
