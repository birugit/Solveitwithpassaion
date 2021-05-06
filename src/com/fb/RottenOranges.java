package com.fb;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * @author swamy on 12/30/20
 */
public class RottenOranges {
    public static void main(String[] args) {
        int[][] oranges = {{2,1,1},
                            {1,1,0},
                            {0,1,1}};
        int days = finDaysToRotten(oranges);
        System.out.println(days);

    }

    private static int finDaysToRotten(int[][] oranges) {
        int rows = oranges.length;
        int columns = oranges[0].length;

        Queue<int[]> que = new LinkedList<>();
        int freshOranges = 0;

        for(int i=0; i< rows; i++){
            for(int j=0; j<columns; j++){
                if(oranges[i][j] == 2)
                que.offer(new int[]{i, j});
                if(oranges[i][j] ==1)
                    freshOranges++;

            }
        }

        int days=0;
        int[][] direction = {{-1,0 },{1,0}, {0,-1}, {0, 1}};
        while(!que.isEmpty() && freshOranges>0){
            int size = que.size();
            for(int i=0; i<size; i++){
                int[] node = que.poll();
                for(int[] dir: direction){
                    int x = dir[0] + node[0];
                    int y = dir[1] + node[1];
                    if(x <0 || y<0 || x>= rows || y>= columns || oranges[x][y]==0 || oranges[x][y]==2)
                        continue;
                    oranges[x][y] = 2;
                    que.offer(new int[]{x,y});
                    freshOranges--;
                }
            }
            days++;
        }
return  freshOranges==0 ?days : -1;
    }
}
