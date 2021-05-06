package com.fb;

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
 * @author swamy on 12/31/20
 */
//The complexity of creating a trie is O(W*L),
//where W is the number of words, and L is an average length of the word:
//search:O(W*L)
class Trie {
    public Trie[] children;
    public List<String> suggestions;
    public Trie() {
        children = new Trie[26];
        suggestions = new ArrayList<>();
    }
}
public class SearchSuggestionSystem {
    public static void main(String[] args) {
        SearchSuggestionSystem search = new SearchSuggestionSystem();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mousepad";
        List<List<String>> s = search.suggestedProducts(products, searchWord);
        for (List<String> prod : s) {
            System.out.println(prod);
        }
    }

    private List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        Arrays.sort(products);
        for(String product : products){
            Trie ptr = root;
            for(char c: product.toCharArray()){
                if(ptr.children[c - 'a'] == null)
                    ptr.children[c - 'a'] = new Trie();
                ptr = ptr.children[c - 'a'];
                if(ptr.suggestions.size() < 3)
                    ptr.suggestions.add(product);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(char c: searchWord.toCharArray()){
            if(root != null)
                root = root.children[c - 'a'];
            res.add(root == null ? Arrays.asList() : root.suggestions);
        }
        return res;
    }
    }
