package com.techniques.graph;

import java.util.*;

/**
 There is a dictionary containing words from an alien language for which we don’t know the ordering of the characters. Write a method to find the correct order of characters in the alien language.

 Example 1:

 Input: Words: ["ba", "bc", "ac", "cab"]
 Output: bac
 Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
 from the given words we can conclude the following ordering among its characters:

 1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
 2. From "bc" and "ac", we can conclude that 'b' comes before 'a'

 From the above two points, we can conclude that the correct character order is: "bac"
 Example 2:

 Input: Words: ["cab", "aaa", "aab"]
 Output: cab
 Explanation: From the given words we can conclude the following ordering among its characters:

 1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
 2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'

 From the above two points, we can conclude that the correct character order is: "cab"
 Example 3:

 Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
 Output: ywxz
 Explanation: From the given words we can conclude the following ordering among its characters:

 1. From "ywx" and "wz", we can conclude that 'y' comes before 'w'.
 2. From "wz" and "xww", we can conclude that 'w' comes before 'x'.
 3. From "xww" and "xz", we can conclude that 'w' comes before 'z'
 4. From "xz" and "zyy", we can conclude that 'x' comes before 'z'
 5. From "zyy" and "zwz", we can conclude that 'y' comes before 'w'

 From the above five points, we can conclude that the correct character order is: "ywxz"
 */
public class AlienDictionary {

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[]{"ba", "bc", "ac", "cab"});
        System.out.println(result);
    }

    private static String findOrder(String[] words) {
        if(words.length == 0 || words == null)
            return "";

        //1. Initialize the graph
        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, List<Character>> graph = new HashMap<>();
      for(String word : words ){
          for(Character character: word.toCharArray()){
              inDegree.put(character, 0);
              graph.put(character, new ArrayList<Character>());
          }
      }

      //2. Build the graph
        for(int i=0; i< words.length - 1; i++){
            String word1 = words[i], word2 = words[i + 1];
            for(int j=0; j< Math.min(word1.length(), word2.length()); j++){
                char parent = word1.charAt(j), child = word2.charAt(j);
                if(parent != child){
                    graph.get(parent).add(child);//add adjacency list
                    inDegree.put(child, inDegree.getOrDefault(child, 0)+1);//increment childs degree
                    break;//only difference between two characters will helps us find the order
                }
            }
        }

        //3. find all sources with 0 in-degree
        Queue<Character> sources = new LinkedList<>();
        for(Map.Entry<Character, Integer> source: inDegree.entrySet()){
            if(source.getValue() == 0){
                sources.add(source.getKey());
            }
        }

        //4. Add the sources with zero in-degree to sortedorder and decrement the in-gree of neighbors to zero
        //repeat to add 0 in=degree vertex to sortedorder
        StringBuilder sortedOrder = new StringBuilder();
        while(!sources.isEmpty()){
            Character vertex  = sources.poll();
            sortedOrder.append(vertex);
            List<Character> children = graph.get(vertex);
            for(Character child: children){
                inDegree.put(child, inDegree.getOrDefault(child,0)-1);
                if(inDegree.get(child) ==0)
                    sources.add(child);
            }
        }

        //if sortedOrder not equal to size of indegree, then there will be a cycle in graph
        if(sortedOrder.length() != inDegree.size())
            return  "";

        return  sortedOrder.toString();


    }
}
