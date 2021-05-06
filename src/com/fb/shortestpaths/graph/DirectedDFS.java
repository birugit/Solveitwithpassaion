package com.fb.shortestpaths.graph;

/**
 * @author swamy on 3/25/21
 */
public class DirectedDFS {

    private boolean[] marked;
    private int count;

    public DirectedDFS(Diagraph d, int s){
        marked = new boolean[d.V()];
        dfs(d, s);
    }

    private void dfs(Diagraph G, int v) {
        count++;
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w])
            dfs(G, w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) {
    Diagraph G = new Diagraph();
    DirectedDFS dfs = new DirectedDFS(G, 0);
    for(int v=0; v<G.V(); v++){
        if(dfs.marked(v))
            System.out.print(v +" ");
    }
  }
}
