package com.nov;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author swamy on 11/11/20
 *
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 *
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * Example:
 *
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 *
 *
 * Note:
 *
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
public class ValidSquare {
    public static void main(String[] args) {
        ValidSquare v = new ValidSquare();
      int[]  p1 = {0,0}, p2 = {1,1}, p3 = {1,0}, p4 = {0,1};
      boolean b = v.validSquare(p1, p2, p3, p4);
      System.out.println(b);


    }
    // (4 sides of equal length && 2 diagonals of equal length) <--> The four points can form a square.
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new TreeMap<>();    // Maps distance to number of point-pairs with that distance:
        map.put(dist(p1, p2), map.getOrDefault(dist(p1, p2), 0) + 1);
        map.put(dist(p1, p3), map.getOrDefault(dist(p1, p3), 0) + 1);
        map.put(dist(p1, p4), map.getOrDefault(dist(p1, p4), 0) + 1);
        map.put(dist(p2, p3), map.getOrDefault(dist(p2, p3), 0) + 1);
        map.put(dist(p2, p4), map.getOrDefault(dist(p2, p4), 0) + 1);
        map.put(dist(p3, p4), map.getOrDefault(dist(p3, p4), 0) + 1);

        Iterator<Integer> it = map.values().iterator(); // because the TreeMap sorts keys in ascending order, and we know that the sides are shorter than the diagonals, we know that the first key should have the value 4, and the second key should have the value 2.
        return map.size() == 2 && it.next() == 4 && it.next() == 2;
    }

    // Euclidian distance (without the square root) between two points.
    private int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
