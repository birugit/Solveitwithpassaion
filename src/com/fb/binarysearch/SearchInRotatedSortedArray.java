package com.fb.binarysearch;

/**
 * You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
 *
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * If target is found in the array return its index, otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 * @author swamy on 1/30/21
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;//3,0;
        int res = s.search(nums, target);
        System.out.print(res);

    }

    /**
     * T:O(logN)
     * S:(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
                //Pivot element is larger than the first element in the array,
                // i.e. the subarray from the first element to the pivot is non-rotated,
            else if (nums[mid] >= nums[start]) {
               // If the target is located in the non-rotated subarray:
                //go left: `end = mid - 1`.
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    //- Otherwise: go right: `start = mid + 1`.
                    start = mid + 1;
            }
            //Pivot element is smaller than the first element of the array, i.e.
            // the rotation index is somewhere between 0 and mid.
            // It implies that the sub-array from the pivot element to the last one is non-rotated, .
            else {
                // If the target is located in the non-rotated subarray:
                //  go right: `start = mid + 1`.
                if (target <= nums[end] && target > nums[mid])
                    start = mid + 1;
                else
                    //Otherwise: go left: `end = mid - 1`.
                    end = mid - 1;
            }
        }
        return -1;
    }
}
