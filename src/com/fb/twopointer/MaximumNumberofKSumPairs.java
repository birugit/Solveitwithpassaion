package com.fb.twopointer;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer k.
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
    int[] nums = {1, 2, 3, 4};
    int k = 5;
    int res = m.maxNumOfSumPairs(nums, k);
    System.out.println(res);
}

    private int maxNumOfSumPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        int count =0;
        while(left < right){
            int curSum= nums[left] + nums[right];
            if(curSum > k){
                right--;
            }else if(curSum < k){
                left++;
            }else{
                left++;
                right--;
                count++;
            }
        }
        return count;
    }
}
