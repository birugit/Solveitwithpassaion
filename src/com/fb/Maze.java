package com.fb;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  There is a ball in a maze with empty spaces and walls. The ball can go
 *  * through empty spaces by rolling up, down, left or right, but it won't stop
 *  * rolling until hitting a wall. When the ball stops, it could choose the next
 *  * direction.
 *  *
 *  * Given the ball's start position, the destination and the maze, determine
 *  * whether the ball could stop at the destination.
 *  *
 *  * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 *  * the empty space. You may assume that the borders of the maze are all walls.
 *  * The start and destination coordinates are represented by row and column
 *  * indexes.
 *  *
 *  *
 *  *
 *  * Example 1:
 *  *
 *  * Input 1: a maze represented by a 2D array
 *  *
 *  * 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 1 1 0 0 0 0 0
 *  *
 *  * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 *  Input 3: destination
 *  * coordinate (rowDest, colDest) = (4, 4)
 *  *
 *  * Output: true
 *  *
 *  * Explanation: One possible way is : left -> down -> left -> down -> right ->
 *  * down -> right.
 *  *
 *  * Example 2:
 *  *
 *  * Input 1: a maze represented by a 2D array
 *  *
 *  * 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 1 1 0 0 0 0 0
 *  *
 *  * Input 2: start coordinate (rowStart, colStart) = (0, 4) Input 3: destination
 *  * coordinate (rowDest, colDest) = (3, 2)
 *  *
 *  * Output: false
 *  *
 *  * Explanation: There is no way for the ball to stop at the destination.
 *  *
 *  *
 *  *
 *  * Note:
 *  *
 *  * There is only one ball and one destination in the maze. Both the ball and the
 *  * destination exist on an empty space, and they will not be at the same
 *  * position initially. The given maze does not contain border (like the red
 *  * rectangle in the example pictures), but you could assume the border of the
 *  * maze are all walls. The maze contains at least 2 empty spaces, and both the
 *  * width and height of the maze won't exceed 100.
 * @author swamy on 1/1/21
 */
public class Maze {

    static class Cordinate {
        private int x, y;

        public Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        //int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
        //		{ 0, 0, 0, 0, 0 } };

        int[][] maze =
                {{0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination ={3,2};
        /*
         *
         * Input 2: start coordinate (rowStart, colStart) = (0, 4)
         * Input 3: destination
         * coordinate (rowDest, colDest) = (4, 4)
         */

        // Cordinate start = new Cordinate(0, 4);
        // Cordinate destination = new Cordinate(4, 3);
        //	int[] start = { 0, 4 };
        //	int[] destination = { 4, 3 };
        System.out.println(findMazePath(maze, start, destination));
    }

    private static boolean findMazePath(int[][] maze, int[] start, int[] destination) {
        Queue<Cordinate> ballQue = new LinkedList<>();
        Cordinate startCo = new Cordinate(start[0], start[1]);
        ballQue.offer(startCo);
        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[startCo.x][startCo.y] = true;
        while (!ballQue.isEmpty()) {
            Cordinate prev = ballQue.poll();
            if (prev.x == destination[0] && prev.y == destination[1])
                return true;
            for (int[] dir : direction) {
                int next_x = dir[0] + prev.x;
                int next_y = dir[1] + prev.y;
                while(isSafe(next_x, next_y, maze.length, maze[0].length, maze)) {
                    next_x += dir[0];
                    next_y += dir[1];

                }

                if(!visited[next_x - dir[0]][next_y - dir[1]]) {
                    System.out.println(next_x+" : "+next_y);

                    System.out.println(dir[0]+" dir "+dir[1]);
                    System.out.println((next_x - dir[0])+":"+(next_y - dir[1]));
                    ballQue.offer(new Cordinate(next_x - dir[0], next_y - dir[1]));
                    visited[next_x - dir[0]][next_y - dir[1]] = true;
                    System.out.println();
                }
            }
        }

        return false;
    }

    private static boolean isSafe(int next_x, int next_y, int row, int col, int[][] maze) {

        return (next_x >= 0 && next_x < row && next_y >= 0 && next_y < col && maze[next_x][next_y] == 0
        );
    }


}
