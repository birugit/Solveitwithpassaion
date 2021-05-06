package com.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author swamy on 1/1/21
 */
public class CriticalConnections {


    public static void main(String[] args) {
        CriticalConnections c=new CriticalConnections();
        List<Integer> edges = new ArrayList<>();
        List<List<Integer>> connections = new ArrayList<>();
        //[[0,1],[1,2],[2,0],[1,3]]
        edges.add(0);
        edges.add(1);
        connections.add(edges);
        edges = null;
        edges = new ArrayList<>();
        edges.add(1);
        edges.add(2);
        connections.add(edges);
        edges = null;
        edges = new ArrayList<>();
        edges.add(2);
        edges.add(0);
        connections.add(edges);
        edges = null;
        edges = new ArrayList<>();
        edges.add(1);
        edges.add(3);
        connections.add(edges);
        edges = null;


        int n = 4;
        //33 ms
        List<List<Integer>> articulationpoints =	c.criticalConnections(n,connections);
        System.out.println(articulationpoints);

    }

    int edgeIndex = 0;
    int[] to;
    int[] next;
    int[] head;
    int[] low;
    int time = -1;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        low = new int[n];
        int m = connections.size();
        to = new int[m * 2];
        head = new int[n];
        next = new int[m * 2];
        Arrays.fill(head, -1);
        Arrays.fill(next, -1);
        Arrays.fill(low, -1);

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            addEdge(u, v);
            addEdge(v, u);
        }

        dfs(1, -1);
        return res;
    }

    private void dfs(int node, int parent) {
        if (low[node] != -1) {
            return;
        }

        int min = low[node] = ++ time;

        for (int edge = head[node]; edge != -1; edge = next[edge]) {
            int next = to[edge];

            if (low[next] == -1) {
                dfs(next, node);
                low[node] = Math.min(low[node], low[next]);

                if (low[next] > min) {
                    res.add(Arrays.asList(node, next));
                }
            } else if (next != parent) {
                low[node] = Math.min(low[node], low[next]);
            }
        }
    }

    private void addEdge(int u, int v) {
        to[edgeIndex] = v;
        next[edgeIndex] = head[u];
        head[u] = edgeIndex ++;
    }


}
