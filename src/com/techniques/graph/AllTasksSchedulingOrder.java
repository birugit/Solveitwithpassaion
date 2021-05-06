package com.techniques.graph;

import java.util.*;

/**
 here are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a method to print all possible ordering of tasks meeting all prerequisites.

 Example 1:

 Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 Output: [0, 1, 2]
 Explanation: There is only possible ordering of the tasks.
 Example 2:

 Input: Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
 Output:
 1) [3, 2, 0, 1]
 2) [3, 2, 1, 0]
 Explanation: There are two possible orderings of the tasks meeting all prerequisites.
 */
public class AllTasksSchedulingOrder {

    public static void main(String[] args) {
        AllTasksSchedulingOrder.printOrders(4,
                new int[][]{new int[]{3,2}, new int[]{3, 0}
                , new int[] {2, 0}, new int[]{2, 1}
                });
        //System.out.println(result);
    }
    private static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedorder = new ArrayList<>();
        if (tasks <= 0) {
            return;
        }

        //a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();//count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        //b. Build the graph

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child);//put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1);//increment child's inDegree
        }

        //c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        printAllTopologicalSorts(graph, inDegree, sources, sortedorder);
    }

    private static void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> inDegree, Queue<Integer> sources, List<Integer> sortedorder) {
            if(!sources.isEmpty()){
                for(Integer vertex: sources){
                    sortedorder.add(vertex);
                    Queue<Integer> sourceForNextCall = cloneQueue(sources);
                    //only remove the current source, all other sources should remain in the queue for the next
                    sourceForNextCall.remove(vertex);
                    List<Integer> children = graph.get(vertex);//get the node's children to decrement their in-degree
                    for(int child: children){
                        inDegree.put(child, inDegree.get(child) - 1);
                        if(inDegree.get(child) == 0)
                            sourceForNextCall.add(child);//save the new source for the next call
                        }

                        //recursive call to print other orderings form the remaining (and new ) sources
                        printAllTopologicalSorts(graph, inDegree, sourceForNextCall, sortedorder);

                        //backtrack, remove the vertex from the sorted order and put all of its children back
                        //the next source instead of the current vertex
                        sortedorder.remove(vertex);
                        for(Integer child: children)
                            inDegree.put(child, inDegree.get(child) + 1);
                    }
                }
            //if sortedorder doesn't contain all tasks, either we've a cyclic dependency between tasks, or
        // we have not processed all the task in this recursive call
            if(sortedorder.size() == inDegree.size())
                System.out.println(sortedorder);
            }



    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for(Integer num: queue){
            clone.add(num);
        }
        return clone;
    }
}
