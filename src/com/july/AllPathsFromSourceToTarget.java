package com.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

 The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

 Example:
 Input: [[1,2], [3], [3], []]
 Output: [[0,1,3],[0,2,3]]
 Explanation: The graph looks like this:
 0--->1
 |    |
 v    v
 2--->3
 There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 Note:

 The number of nodes in the graph will be in the range [2, 15].
 You can print different paths in any order, but you should keep the order of nodes inside one path.

 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        AllPathsFromSourceToTarget  a= new AllPathsFromSourceToTarget();
        int[][] graph = {
                {1,2},
                {3},
                {3},
                {}
        };
     // List<List<Integer>>   res=a.allPathsSourceTarget(graph);
      //System.out.println(res);
        List<List<Integer>>   res=a. allPathsSourceTargetDP(graph);
        System.out.println(res);
    }



    /**
    T: O(2^N N)
     S: O2^N.N)
     */
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            // Note: one should make a deep copy of the path
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        // explore the neighbor nodes one after another.
        for (int nextNode : this.graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<List<Integer>>();
        // adopt the LinkedList for fast access to the tail element.
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        // kick of the backtracking, starting from the source (node 0)
        this.backtrack(0, path);
        return this.results;
    }


    //Top Down Dynamic Programming
    private HashMap<Integer, List<List<Integer>>> memo;

    protected List<List<Integer>> allPathsToTargetDP(int currNode) {
        // memoization. check the result in the cache first
        if (memo.containsKey(currNode))
            return memo.get(currNode);

        List<List<Integer>> results = new ArrayList<>();
        // base case
        if (currNode == this.target) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(target);
            results.add(path);
            return results;
        }

        // iterate through the paths starting from each neighbor.
        for (int nextNode : this.graph[currNode]) {
            for (List<Integer> path : allPathsToTargetDP(nextNode)) {
                ArrayList<Integer> newPath = new ArrayList<>();
                newPath.add(currNode);
                newPath.addAll(path);
                results.add(newPath);
            }
        }
        memo.put(currNode, results);
        return results;
    }

    public List<List<Integer>> allPathsSourceTargetDP(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.memo = new HashMap<>();

        return this.allPathsToTargetDP(0);
    }

    //BFS

    public void bfs(int[][]graph, List<Integer> output1, int i){
        List<Integer> output = new ArrayList<>(output1);
        if(i == graph.length-1){
            output.add(i);
            results.add(output);
            return;
        }
        // if(visited[i] == 1)
        //     return;
        // visited[i] = 1;
        output.add(i);
        for(int t : graph[i]){
            bfs(graph,output,t);
        }
    }

    public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        int n = graph.length;
        if(n <= 1){
            return null;
        }

        results = new ArrayList<>();
        // int[] visited = new int[n];

        bfs(graph,new ArrayList<>(),0);

        return results;
    }
}
