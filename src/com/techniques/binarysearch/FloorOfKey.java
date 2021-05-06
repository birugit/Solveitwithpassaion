package com.techniques.binarysearch;

/**
 Given an array of numbers sorted in ascending order, find the floor of a given number ‘key’. The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’

 Write a function to return the index of the floor of the ‘key’. If there isn’t a floor, return -1.

 Example 1:

 Input: [4, 6, 10], key = 6
 Output: 1
 Explanation: The biggest number smaller than or equal to '6' is '6' having index '1'.
 Example 2:

 Input: [1, 3, 8, 10, 15], key = 12
 Output: 3
 Explanation: The biggest number smaller than or equal to '12' is '10' having index '3'.
 Example 3:

 Input: [4, 6, 10], key = 17
 Output: 2
 Explanation: The biggest number smaller than or equal to '17' is '10' having index '2'.
 Example 4:

 Input: [4, 6, 10], key = -1
 Output: -1
 Explanation: There is no number smaller than or equal to '-1' in the given array.
 */
public class FloorOfKey {
    public static void main(String[] args) {
        FloorOfKey f = new FloorOfKey();
        int[] nums = {4, 6, 10};//{4, 6, 10};//{1, 3, 8, 10, 15};
        int key = 11;//-1;//12;
        System.out.println(f.findFloor(nums, key));
    }

    private int findFloor(int[] nums, int key) {
        if(key < nums[0])
            return -1;
        int start =0, pivot = 0, end = nums.length -1;
        while(start <= end){
            pivot = start + (end - start)/2;

            if(key < nums[pivot]){
                end = pivot - 1;
            }
            else if(key > nums[pivot]){
                start = pivot + 1;
            }
            else{
                return pivot;
            }
        }
        return end;
    }
}
