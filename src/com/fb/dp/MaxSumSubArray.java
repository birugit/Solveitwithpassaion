package com.fb.dp;

/**
 * @author swamy on 1/16/21
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        MaxSumSubArray m = new MaxSumSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = m.maxSubArrayKadane(nums);//m.maxSubArray(nums);
        System.out.println(sum);
    }

    /**
     * dp
     * T O(N)
     * S O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] >0? dp[i - 1] : 0);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;

    }

    /**
     * kadane
     * T: O(N)
     * S:O(1)
     * @param nums
     * @return
     */
    public int maxSubArrayKadane(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
