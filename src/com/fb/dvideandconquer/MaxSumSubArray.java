package com.fb.dvideandconquer;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * Devide and conquer formula:
 * <p>Define the base case(s).
 *
 * <p>Split the problem into subproblems and solve them recursively.
 *
 * <p>Merge the solutions for the subproblems to obtain the solution for the original problem.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has the largest sum =
 * 6.
 *
 * @author swamy on 1/15/21
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        MaxSumSubArray m = new MaxSumSubArray();
        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
       int res = m.maxSubArray(nums);
       System.out.println(res);
    }

    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right)
            return nums[left];

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
