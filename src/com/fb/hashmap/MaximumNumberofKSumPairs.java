package com.fb.hashmap;

import java.util.HashMap;

/**
 * ou are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * @author swamy on 1/18/21
 */
public class MaximumNumberofKSumPairs {

    public static void main(String[] args) {
        MaximumNumberofKSumPairs m = new MaximumNumberofKSumPairs();
        int[] nums = {1, 2, 3,4};
        int k = 5;

       int res = m.maxOperations(nums, k);
       System.out.println(res);

    }

    /**
     * T: O(N) -> One complete iteration of array
     * S: O(N) -> HashMap take O(n) sopace, where N is the length of the array.
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = k - current;
            if (map.getOrDefault(complement, 0) > 0) {
                // remove complement from the map
                map.put(complement, map.get(complement) - 1);
                count++;
            } else {
                // add current element in the map
                map.put(current, map.getOrDefault(current, 0) + 1);
            }
        }
        return count;
    }

}
