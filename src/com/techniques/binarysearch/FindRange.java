package com.techniques.binarysearch;

/**
 Given an array of numbers sorted in ascending order, find the range of a given number ‘key’. The range of the ‘key’ will be the first and last position of the ‘key’ in the array.

 Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].

 Example 1:

 Input: [4, 6, 6, 6, 9], key = 6
 Output: [1, 3]
 Example 2:

 Input: [1, 3, 8, 10, 15], key = 10
 Output: [3, 3]
 Example 3:

 Input: [1, 3, 8, 10, 15], key = 12
 Output: [-1, -1]
 */
public class FindRange {
    public static void main(String[] args) {


    FindRange f = new FindRange();
    int[] nums = {4, 6, 6, 6, 9};
    int key = 6;
    int[] res = f.findRange(nums, key);
    for(
    int n:res)
            System.out.println(n);
}
    private int[] findRange(int[] arr, int key) {
        int[] result = new int[]{-1, -1};
        result[0] = search(arr, key, false);
        if(result[0] != -1)//no need to serach, if key is not present int he input
            result[1] =search(arr, key, true);
        return result;
    }

    //modified Binary Search
    private static int search(int[] arr, int key, boolean findMaxIndex){
        int keyIndex = -1;
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(key < arr[mid]){
                end  = mid -1;
            }else if(key > arr[mid ]){
                start = mid + 1;
            }else{//key == arr[mid]
                keyIndex = mid;
                if(findMaxIndex)
                    start = mid +1;//search ahead to find the last index of 'key'
                else
                    end = mid - 1;//serach behind to find the first index of 'key'
            }
        }
        return keyIndex;
    }

}
