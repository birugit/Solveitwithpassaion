package com.fb.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author swamy on 3/1/21
 */
public class FirstMissingNumber {
  public static void main(String[] args) {
      FirstMissingNumber f = new FirstMissingNumber();
      int[] nums = {3, 4, 5};
      int res= f.missingNumber(nums);
      System.out.println(res);
  }

    /**
     * T:O(n)
     * adding nums to hashset O(1), creating set costs o(n)
     * Main loops O(n)
     * O(n+n) = O(n)
     * S: o(n) N-1 distinct elements
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums)
            numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
