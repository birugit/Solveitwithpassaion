package com.techniques.binarysearch;

/**
 Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.

 Example 1:

 Input: [4, 6, 10], key = 7
 Output: 6
 Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
 Example 2:

 Input: [4, 6, 10], key = 4
 Output: 4
 Example 3:

 Input: [1, 3, 8, 10, 15], key = 12
 Output: 10
 Example 4:

 Input: [4, 6, 10], key = 17
 Output: 10
 */
public class MinimumDiff {
    public static void main(String[] args) {
        MinimumDiff m = new MinimumDiff();
        int[] nums = {4, 6, 10};
        int key = 9;
       System.out.println( m.minDifference(nums, key));
    }

    private int minDifference(int[] nums, int key) {
        if(key < nums[0])
            return nums[0];
        if(key > nums[nums.length - 1])
            return nums[nums.length - 1];

        int low = 0, high = nums.length -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(key < nums[mid]){
                high = mid -1;
            }else if(key > nums[mid]){
                low = mid + 1;
            }else {
                return  nums[mid];
            }
        }
        /**
        at the end of the while loop, 'start == end +1'
         we are not able to find the element in the given array
         return the element which is closest to the key
         */
        if(nums[low] - key < key -nums[high] ){
            return nums[low];
        }
        return nums[high];
    }
}
