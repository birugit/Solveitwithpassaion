package com.fb.shortestpaths.graph;

import java.util.Iterator;

/**
 * @author swamy on 3/25/21
 */
public class Diagraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private int[] indegree;
    private static final String NEWLINE = System.getProperty("line.separator");

    /**
     * Initialize empty Graph
     * @param V
     */
    public Diagraph(int V){
        this.V = V;
        this.E = 0;
        indegree = new int[V];

        adj = new Bag[V];
        for(int i=0; i< V; i++){
            adj[i] = new Bag<>();
        }
    }

    public Diagraph(){
        this(13);
        //wihtout cycle
		addEdge(2,3);
		addEdge(0,6);
		addEdge(0,1);
		addEdge(2,0);
		addEdge(11,12);
		addEdge(9,12);
		addEdge(9,10);
		addEdge(9,11);
		addEdge(3,5);
		addEdge(8,7);
		addEdge(5,4);
		addEdge(0,5);
		addEdge(6,4);
		addEdge(6,9);
		addEdge(7,6);
    /**
     * 13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 7 9 10 12 11 4 4 3 3 5 6 8 8 6 5 4 0 5 6 4
     * 6 9 7 6
     */
  }

    public void addEdge(int v, int w){
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public  int V(){
        return V;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + "vertices, " + E + "edges" + NEWLINE);
        for(int v = 0; v < V; v++) {
            sb.append(String.format("%d", v));
            sb.append(": ");
            for(int w: adj[v]) {
                sb.append(String.format("%d", w));
                sb.append(" ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

  public static void main(String[] args) {
    Diagraph d = new Diagraph();
    System.out.println(d);
  }
}
