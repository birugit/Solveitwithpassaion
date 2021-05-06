package com.fb.shortestpaths.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author swamy on 3/18/21
 */
public class BreadthFirstPaths {

    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;//is there any marked path
    private int[] edgeTo;//previous edge on shortest s v path
    private int[] distTo;//number of edges shortest s v path

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        //validatevertex(s)
        bfs(G,s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<g.V();i++)
            distTo[i] = INFINITY;

        distTo[s] = 0;
        marked[s] = true;

        que.offer(s);
        while(!que.isEmpty()){
            int v = que.poll();
            for(int w : g.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    que.offer(w);
                }
            }
        }


    }

    //is there a path between source vertex s and vertex v
    public boolean hasPathTo(int v){
        return marked[v];
    }

    //number of edges in a shortest path between the source vertex
    public int distTo(int v){
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        //  validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        int s = 2;
        BreadthFirstPaths bfs = new BreadthFirstPaths(g, s);

        for(int v = 0; v<g.V();v++){
            if(bfs.hasPathTo(v)){
                System.out.println("s "+s +" to v "+v +": "+bfs.distTo(v));
                for(int x:bfs.pathTo(v)){
                    if(s == x)
                        System.out.print(x);
                    else
                        System.out.print(" - "+x);
                }
                System.out.println();
            }
            else{
                System.out.println("s "+s +" to v "+v +"not connected");
            }
        }

    }


}
