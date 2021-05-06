package com.fb.shortestpaths.graph;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author swamy on 3/13/21
 */
public class Graph {


    private static final String CHARSET_NAME = "UTF-8";
    private Scanner scanner;

    private  int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        if(V < 0)throw new IllegalArgumentException();
        this.V = V;
        this.E = 0;
        adj =  new Bag[V];
        for(int v=0; v < V;v++){
            adj[v] = new Bag<Integer>();
        }
  //  Arrays.fill(adj, new Bag<Integer>());
    }

    //Initialize a new Graph that it reads form URL/File
    @SuppressWarnings("unchecked")
    public Graph(String input) {
/*
        try {
            //first try to read file from local file system
            File file = new File(input);
            if(file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), CHARSET_NAME);
                scanner.useLocale(Locale.US);
                return;
            }

            //resource erelative to .class file
            URL url = getClass().getResource(input);
            //resource relative to classloader root
            if(url == null) {
                url = getClass().getClassLoader().getResource(input);
            }
            //URL from web
            if(url == null) {
                url = new URL(input);
            }

            //	URLConnection site = url.openConnection();
            // in order to set User-Agent, replace above line with these two
            // HttpURLConnection site = (HttpURLConnection) url.openConnection();
            // site.addRequestProperty("User-Agent", "Mozilla/4.76");
            //		System.out.println(site);
            //InputStream is = site.getInputStream();
            scanner =	new Scanner( url.openStream(), "UTF-8" );
            //	scanner = new Scanner(new BufferedInputStream(is), CHARSET_NAME);
            //	scanner.useLocale(Locale.US);

            //Graph initialization
            //	System.out.println(scanner.nextInt());
            this.V  = scanner.nextInt();
            System.out.println("V:"+V);
            if(V < 0)
                throw new IllegalArgumentException("Invalid vertex size");

            this.E = scanner.nextInt();
            System.out.println("E:"+E);
            adj =(Bag<Integer>[]) new Bag[V];

            for(int v=0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }

            for(int i =0; i < E; i++) {
                while(scanner.hasNext()) {
                    int v = scanner.nextInt();
                    int w = scanner.nextInt();
                    System.out.println(v +" -- "+w);


                    addEdge(v, w);
                }
            }

        }catch(IOException e) {
            throw new IllegalArgumentException("could not open");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

    public boolean isEmpty() {
        return !scanner.hasNext();
    }


    //Initializes a new Graph that is a deep copy of Graph
    public Graph(Graph G){
        this.V = G.V();
        this.E = G.E();

        //update adjacency list
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v=0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

        for(int v= 0; v< G.V(); v++){
            //reverses that adjecency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for(int w : G.adj[v]){
                reverse.push(w);
            }
            for(int w : reverse){
                adj[v].add(w);
            }
        }
    }


    public Graph() {
        //this(13);//
        //g.E = 13;
        //13
        //13
	/*	addEdge(0, 5);
		addEdge(4, 3);
		addEdge(0, 1);
		addEdge(9, 12);
		addEdge(6, 4);
		addEdge(5, 4);
		addEdge(0, 2);
		addEdge(11, 12);
		addEdge(9, 10);
		addEdge(0, 6);
		addEdge(7, 8);
		addEdge(9, 11);
		addEdge(5, 3);*/

        //addEdge();
	/*	this(6);
		//6
		//8
		addEdge(0, 5);
		addEdge(2, 4);
		addEdge(2, 3);
		addEdge(1, 2);
		addEdge(0, 1);
		addEdge(3, 4);
		addEdge(3, 5);
		addEdge(0, 2);*/

        //Articulation point Biconnected Graph-- FindCriticalServers
//numNodes = 7, numEdges = 7,
        //[[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
      /*  this(7);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(2, 5);
        addEdge(5, 6);
        addEdge(3, 4);*/
        //Output: [2, 3, 5]

        //n = 4, connections = [[0,1],[1,2],[2,0],[1,3]] TarjanSCC only for diagraph
		this(4);
		addEdge(0, 1);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(1, 3);

        //JPMC
     /*      this(9);
        addEdge('A', 'B');
        addEdge('B', 'C');
        addEdge('A', 'C');
        addEdge('B', 'D');
        addEdge('C', 'D');
        addEdge('D', 'E');
        addEdge('F', 'G');
        addEdge('G', 'H');
        addEdge('F', 'H');*/

        System.out.println("Degree:"+degree(0));
        System.out.println("Adjacent:"+adj(0));
    }

    private int E() {

        return E;
    }

    public int V() {

        return V;
    }

    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);

    }

    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public void validateVertex(int v){
        if(v < 0 | v >= V) throw new IndexOutOfBoundsException();

    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(V+"vertices "+E+"Edges");
        sb.append("\n");
        for(int v=0; v< V; v++){
            sb.append(v+": ");
            for(int w:adj[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph();


        System.out.println(g);
        //	System.out.println(g.adj(0));
        //	System.out.println(g.degree(9));

        //	Graph gg = new Graph(g);
        //	System.out.println(gg);

        //Graph input from file or web
        //https://algs4.cs.princeton.edu/41graph/tinyG.txt
        //https://algs4.cs.princeton.edu/41graph/largeG.txt
        //Vertices 1000000
        //Edges: 7586063
        //Graph web = new Graph("https://algs4.cs.princeton.edu/41graph/largeG.txt");
        //System.out.println(web);
    }


}
