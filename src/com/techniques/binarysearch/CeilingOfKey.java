package com.techniques.binarysearch;

/**
 Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’. The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.

 Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.

 Example 1:

 Input: [4, 6, 10], key = 6
 Output: 1
 Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
 Example 2:

 Input: [1, 3, 8, 10, 15], key = 12
 Output: 4
 Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
 Example 3:

 Input: [4, 6, 10], key = 17
 Output: -1
 Explanation: There is no number greater than or equal to '17' in the given array.

 */
public class CeilingOfKey {

    public static void main(String[] args) {
        CeilingOfKey c = new CeilingOfKey();
        int[] nums = {4, 6, 10};//{4, 6, 10};//{1, 3, 8, 10, 15};
        int key =7;//12;//4
       System.out.println(c.findCeiling(nums, key));
    }

    /**
     T: O(logN)
     S: O(1)s
     * @param nums
     * @param key
     * @return
     */
    private int findCeiling(int[] nums, int key) {
        //check key is bigger than biggest element
        if(key > nums[nums.length-1])
            return -1;
        int start = 0, pivot = 0, end = nums.length - 1;
        while(start <= end){
            pivot = start + (end - start)/2;

            if(key > nums[pivot] ){
                    start = pivot +1;
            }else if(key < nums[pivot]){

                    end = pivot -1;
            }else{
                return pivot;
            }

        }
        return start;
    }
}
