package com.techniques.graph;
/**
 Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.

 Given a directed graph, find the topological ordering of its vertices.

 Example 1:

 Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
 Output: Following are the two valid topological sorts for the given graph:
 1) 3, 2, 0, 1
 2) 3, 2, 1, 0


 Input: Vertices=7, Edges=[6, 4], [6, 2], [5, 3], [5, 4], [3, 0], [3, 1], [3, 2], [4, 1]
 Output: Following are all valid topological sorts for the given graph:
 1) 5, 6, 3, 4, 0, 1, 2
 2) 6, 5, 3, 4, 0, 1, 2
 3) 5, 6, 4, 3, 0, 2, 1
 4) 6, 5, 4, 3, 0, 1, 2
 5) 5, 6, 3, 4, 0, 2, 1
 6) 5, 6, 3, 4, 1, 2, 0

 There are other valid topological ordering of the graph too.
 */

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{new int[]{3,2}, new int[]{3, 0}, new int[] {2, 0}, new int[]{2, 1}});
   System.out.println(result);
    }

    private static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedorder = new ArrayList<>();
        if(vertices <= 0){
            return sortedorder;
        }

        //a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();//count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for(int i=0; i<vertices; i++){
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        //b. Build the graph

        for(int i=0; i < edges.length; i++){
            int parent = edges[i][0],
                    child = edges[i][1];
            graph.get(parent).add(child);//put the child into it's parent's list
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);//increment child's inDegree
        }

        //c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()){
            if(entry.getValue() == 0){
                sources.add(entry.getKey());
            }
        }

        //c. For each sources, add it to the sortedOrder and subtract one form all of its children's in-dgree
        //if a child's in-degree becomes zero, add it to the sources queue
        while(!sources.isEmpty()){
            int vertex = sources.poll();
            sortedorder.add(vertex);
            List<Integer> children = graph.get(vertex);// get the node's children to decrement their in-dgree
            for(int child: children){
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        if(sortedorder.size() != vertices)//topological sort is not possible as the graph has a cycle
            return  new ArrayList<>();
        return sortedorder;

    }
}
