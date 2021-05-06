package com.fb;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 *
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,1],[1,0]]
 *
 *
 * Output: 2
 * @author swamy on 12/30/20
 */
public class ShortestPathInBinaryMatrix {
    static int ROW = 2;//9;
    static int COL = 2;//10;

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    };

    static class QueNode{
        Point pt;
        int dist;

        QueNode(Point pt, int dist){
            this.pt = pt;
            this.dist = dist;
        }
    };

    static boolean isValid(int x, int y){
        return (x>=0 && y>=0 && x<ROW && y<COL);
    }

    static int[] rowNum = {-1, 0, 0, 1};
    static int[] colNum = {0, -1, 1, 0};

    static int BFS(int[][] mat, Point src, Point dest){

        //check source and destination cell of matrix have value 1;
        if(mat[src.x][src.y] != 1 &&
           mat[dest.x][dest.y] != 1)
            return -1;

        boolean[][] visited = new boolean[ROW][COL];

        //mark the source cell as visited
        visited[src.x][src.y] = true;

        //Create a que for BFS
        Queue<QueNode> q = new LinkedList<>();

        //distance of source cell is 0
        QueNode s = new QueNode(src, 0);
        q.add(s);

        //do BFS
        while(!q.isEmpty()){
            QueNode cur = q.peek();
            Point pt = cur.pt;

            //if we reached the destination we are done
            if(pt.x == dest.x && pt.y== dest.y)
                return cur.dist;

            //otherwise deque the front cell and enque the adj cell
            q.remove();

            //check all 4 possible moves
            for(int i=0; i< 4; i++){
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                //if adjacent cell have valid path and not yet visited , enque it

                if(isValid(row, col) &&
                mat[row][col] ==1 &&
                        !visited[row][col]){
                                visited[row][col] = true;
                                QueNode adjCell = new QueNode(new Point(row, col), cur.dist+1);
                                q.add(adjCell);
                }

            }

        }
        return -1;



    }
    public static void main(String[] args) {
        int mat[][] = {{0, 1}, {1, 0}};

      /*  int mat[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};*/

        Point source = new Point(0, 0);
        Point dest = new Point(0, 1);

        int dist = BFS(mat, source, dest);

        if (dist != Integer.MAX_VALUE)
            System.out.println("Shortest Path is " + dist);
        else
            System.out.println("Shortest Path doesn't exist");
    }

}
