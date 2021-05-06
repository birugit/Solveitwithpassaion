package com.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed.
 *  *  Suggested products should have common prefix with the searchWord.
 *  * If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 *  *
 *  */

public class SearchSuggestions {

     //Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
    /*
 [mobile, moneypot, monitor]
[mobile, moneypot, monitor]
[mouse, mousepad]
[mouse, mousepad]
[mouse, mousepad]
     */
     public static void main(String[] args) {
         SearchSuggestions s = new SearchSuggestions();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String >> res = s.searchSuggestionsSystem(products, searchWord);
        res.forEach(word -> System.out.println(word));
     }
    class Trie {
        Trie[] children;
        List<String> suggestions;

        public Trie() {
            children = new Trie[26];
            suggestions = new ArrayList<>();
        }
    }
        List<List<String>> searchSuggestionsSystem(String[] products, String searchWord){
            Trie root = new Trie();
            Arrays.sort(products);
            for(String product: products){
                Trie temp = root;
                for(char c: product.toCharArray()){
                    if(temp.children[c - 'a'] == null)
                        temp.children[c - 'a'] = new Trie();
                    temp = temp.children[c - 'a'];

                    if(temp.suggestions.size() < 3){
                        temp.suggestions.add(product);
                    }
                }
            }

            //search
            List<List<String>> res = new ArrayList<>();
            for(char c: searchWord.toCharArray()){
                if(root != null){
                    root = root.children[c - 'a'];
                    res.add(root == null ? Arrays.asList(): root.suggestions);
                }
            }
            return res;



     }
}
