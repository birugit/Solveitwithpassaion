package com.dfs.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 *
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
 class NumberOfDistinctIlandsI {

    public static void main(String[] args) {
        NumberOfDistinctIlandsI n = new NumberOfDistinctIlandsI();
        int[][] grid = {

                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1},
        };
        /*{{11000},
                        {11000},
                        {00011},
                        {00011}
                        };*/
     //  System.out.println( n.numDistinctIslands(grid));
        System.out.println(n.numDistinctIslandsBFS(grid));
    }


    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o"); // origin
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length
                || grid[i][j] == 0)
            return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i-1, j, sb, "u");
        dfs(grid, i+1, j, sb, "d");
        dfs(grid, i, j-1, sb, "l");
        dfs(grid, i, j+1, sb, "r");
        sb.append("b"); // back
    }


    //BFS
    public int numDistinctIslandsBFS(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        Set<String> codeSet = new HashSet<String>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    codeSet.add(bfs(grid, i, j));
                }
            }
        }
        return codeSet.size();
    }

    int[] rm = new int[]{1,-1,0,0};
    int[] cm = new int[]{0,0,1,-1};
    private String bfs(int[][] grid, int i, int j) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> rq = new LinkedList<Integer>();
        Queue<Integer> cq = new LinkedList<Integer>();
        rq.offer(i);
        cq.offer(j);
        grid[i][j] = 0;
        while (!rq.isEmpty()) {
            int r = rq.poll();
            int c = cq.poll();
            for (int k = 0; k < 4; k++) {
                int nr = r+rm[k];
                int nc = c+cm[k];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                    rq.offer(nr);
                    cq.offer(nc);
                    grid[nr][nc] = 0;
                    sb.append("" + (nr-i) + (nc-j));
                }
            }
        }
        return sb.toString();
    }
}
