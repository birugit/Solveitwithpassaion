package com.hashmap;
/**
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 *
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 *
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 *
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 *
 *
 *
 * Example:
 *
 * Input: [[1,2,2,1],
 *         [3,1,2],
 *         [1,3,2],
 *         [2,4],
 *         [3,1,2],
 *         [1,3,1,1]]
 *
 * Output: 2
 *
 * Explanation:
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickAndWall {
    public static void main(String[] args) {
        BrickAndWall b = new BrickAndWall();
        /*
        [[1,2,2,1],
 *         [3,1,2],
 *         [1,3,2],
 *         [2,4],
 *         [3,1,2],
 *         [1,3,1,1]]
         */
        List<Integer> list1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> list2 = Arrays.asList(3,1,2);
        List<Integer> list3 = Arrays.asList(1, 3, 2);
        List<Integer> list4 = Arrays.asList( 2, 4);
        List<Integer> list5 = Arrays.asList(3,1, 2);
        List<Integer> list6 = Arrays.asList(1, 3, 1, 1);
        List<List<Integer>> list = Arrays.asList(list1, list2, list3, list4, list5, list6);
        System.out.println(b.leastBricks(list));
    }

    public int leastBricks(List <List< Integer >> wall) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (List < Integer > row: wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }
        int res = wall.size();
        for (int key: map.keySet())
            res = Math.min(res, wall.size() - map.get(key));
        return res;
    }
}
