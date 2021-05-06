package com.fb;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * @author swamy on 1/3/21
 */
public class NumberOfIslands {

    private int n;
    private int m;

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}

        };

        //O(m*n)
        //O(m*n)
        int count = n.numOfIslandsDFS(grid);
        System.out.println(count);

        //BFS
        //	int countBFS = n.numIslands(grid);
        //	System.out.println(countBFS);

        //int uf = n.numOfIslandsUnionFind(grid);
        //System.out.println(uf);
    }

/*	private int numOfIslandsUnionFind(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int row = grid.length;
		int col = grid[0].length;

		UnionFind uf = new UnionFind(row, col, grid);

		for(int i= 0; i<row; i++) {
			for(int j = 0; j<col; j++) {
				if(grid[i][j] == '1') {
					int p = i * col + j;
					//right
					if(j < col - 1 && grid[i][j + 1] == '1') {
						int q = i * col + j + 1;
						if(!uf.find(p,q)) {
							uf.union(p,q);
						}
					}
					//down
					if(i < row - 1 && grid[i + 1][j] == '1') {
						int q = (i + 1) * col + j;
						if(!uf.find(p, q)) {
							uf.union(p, q);
						}
					}
				}
			}
		}
		return uf.count();
	}*/

    private  int numOfIslandsDFS(char[][] grid) {
        int count = 0;
        n = grid.length;//rows
        if(n == 0) return 0;

        m = grid[0].length;//cols
        for(int i = 0; i< n; i++) {
            for(int j = 0; j< m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i , j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0|| j<0 || i>=n || j>= m || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }


    //BFS
    //T: O(M X N)
    //S: O(min(M X N))
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }


}
