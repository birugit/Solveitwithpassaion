package com.fb;

import java.util.Arrays;

/**
 * Given an integer array nums of size n, return the minimum number of moves required to make all
 * array elements equal.
 *
 * <p>In one move, you can increment n - 1 elements of the array by 1.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,2,3] Output: 3 Explanation: Only three moves are needed (remember each move
 * increments two elements): [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4] Example 2:
 *
 * <p>Input: nums = [1,1,1] Output: 0
 *
 * @author swamy on 3/10/21
 */
public class MinimumMovesToMakeArrayEqual {
  public static void main(String[] args) {
      MinimumMovesToMakeArrayEqual m = new MinimumMovesToMakeArrayEqual();
      int[] nums = {1, 2, 3};
      int res = m.minMovesMath(nums);
      System.out.print(res);
  }

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = (moves + nums[i]) - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }
        return moves;
    }

  /**
   * This approach is based on the idea that adding 1 to all the elements except one is equivalent
   * to decrementing 1 from a single element, since we are interested in the relative levels of the
   * elements which need to be equalized. Thus, the problem is simplified to find the number of
   * decrement operations required to equalize all the elements of the given array. For finding
   * this, it is obvious that we'll reduce all the elements of the array to the minimum element.
   * But, in order to find the solution, we need not actually decrement the elements. We can find
   * the number of moves required as moves=\sum_{i=0}^{n-1} a[i] - min(a)*nmoves=∑ i=0 n−1 ​
   * a[i]−min(a)∗n, where nn is the length of the array.
   *
   * T: O(N)
   * S: O(1)
   * @param nums
   * @return
   */
  public int minMovesMath(int[] nums) {
      int moves = 0, min = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length; i++) {
          min = Math.min(min, nums[i]);
      }
      for (int i = 0; i < nums.length; i++) {
          moves += nums[i] - min;
      }
      return moves;
    }
}
