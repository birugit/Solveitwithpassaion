package com.fb;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the
 * point n. (i.e The length of the garden is n).
 *
 * <p>There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 *
 * <p>Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed)
 * means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 *
 * <p>Return the minimum number of taps that should be open to water the whole garden, If the garden
 * cannot be watered return -1.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1 Explanation: The tap at point 0 can cover the
 * interval [-3,3] The tap at point 1 can cover the interval [-3,5] The tap at point 2 can cover the
 * interval [1,3] The tap at point 3 can cover the interval [2,4] The tap at point 4 can cover the
 * interval [4,4] The tap at point 5 can cover the interval [5,5] Opening Only the second tap will
 * water the whole garden [0,5]
 *
 * @author swamy on 2/21/21
 */
public class MinTapsOpenToWaterGarden {
  public static void main(String[] args) {
      MinTapsOpenToWaterGarden m = new MinTapsOpenToWaterGarden();
      int[] ranges = {1,2,1,0,2,1,0,1};//{3,4,1,1,0,0};
      int n = 7;//5
      int res = m.minTaps(n, ranges);
      System.out.println(res);
  }
    public int minTaps(int n, int[] ranges) {
        int[][] rg = new int[n + 1][2];
        for (int i = 0; i <= n; ++i)
            rg[i] = new int[]{i - ranges[i], i + ranges[i]};
        Arrays.sort(rg, Comparator.comparing(r -> r[0]));
        int ans = 0;
        for (int i = 0, start = 0, end = 0; start < n && i <= n; start = end, ++ans) {
            while (i <= n && rg[i][0] <= start)
                end = Math.max(end, rg[i++][1]);
            if (end <= start)
                return -1;
        }
        return ans;
    }
}
