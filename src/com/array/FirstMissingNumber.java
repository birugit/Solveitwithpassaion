package com.array;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingNumber {
    public static void main(String[] args) {
        FirstMissingNumber f = new FirstMissingNumber();
    int[] nums = {7,8,9,11,12};//{3,4,-1,1};//{7,8,9,11,12};//{1, 2, 0};
      int res =  f.firstMissingPositive(nums);
      System.out.println(res);
    }
    //traverse and place in correct place, later find missing number
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length //to get rid of  0 and negative numbers and in range of 0 to length
                    && nums[nums[i]-1] != nums[i]) //check  number in correct position
            {
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }

    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
