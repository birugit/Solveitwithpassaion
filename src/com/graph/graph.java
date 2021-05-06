package com.graph;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}

        };

      // System.out.println (n.numIslandsBFS(grid));
        System.out.println (n.numIslandsDFS(grid));
    }

    private int numIslandsDFS(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
                for(int i=0; i< row; i++){
                    for(int j=0; j< col; j++){
                        if(grid[i][j] == '1') {
                            dfs(grid, i, j);
                            count++;
                        }
                    }
                }
        return count;

    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i>= grid.length || j<0|| j>= grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }

    public int numIslandsBFS(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }

        return count;
    }

    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0')
                    continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
