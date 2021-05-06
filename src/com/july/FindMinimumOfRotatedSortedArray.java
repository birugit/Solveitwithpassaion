package com.july;

/**
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 The array may contain duplicates.

 Example 1:

 Input: [1,3,5]
 Output: 1
 Example 2:

 Input: [2,2,2,0,1]
 Output: 0
 */
public class FindMinimumOfRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimumOfRotatedSortedArray f = new FindMinimumOfRotatedSortedArray();
        int[] nums ={1,3,5};//{2,2,2,0,1};//{4,5,6,7,0,1,2};
       System.out.println(f.findMin(nums));
    }

    /**
     * Time Complexity : Same as Binary Search O(log N)
     * Space Complexity : O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low =0, mid = 0, high = nums.length -1;
        while(low < high){
            mid = low + (high - low)/2;

            if(nums[mid] < nums[low] ){

                     high = mid - 1;
            }else {
                low = mid;

            }
            if(nums[mid-1] > nums[mid])
                return nums[mid];
        }
       if( nums[mid]< nums[mid+1])
           return nums[mid];
        return -1;

    }

    /**Find Minimum in Rotated Sorted Array II

     Would allow duplicates affect the run-time complexity? How and why?
       */
    public int findMinII(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high])
                high = pivot;
            else if (nums[pivot] > nums[high])
                low = pivot + 1;
            else
                high -= 1;
        }
        return nums[low];
    }

}
