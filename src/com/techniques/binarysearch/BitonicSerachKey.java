package com.techniques.binarysearch;

/**
 Given a Bitonic array, find if a given ‘key’ is present in it.
 An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

 Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.

 Example 1:

 Input: [1, 3, 8, 4, 3], key=4
 Output: 3
 Example 2:

 Input: [3, 8, 3, 1], key=8
 Output: 1
 Example 3:

 Input: [1, 3, 8, 12], key=12
 Output: 3
 Example 4:

 Input: [10, 9, 8], key=10
 Output: 0
 */
public class BitonicSerachKey {
    public static void main(String[] args) {
        BitonicSerachKey b = new BitonicSerachKey();
        int[] nums={1, 3, 8, 4, 3};//{10, 9, 8};//{1, 3, 8, 12};//{3, 8, 3, 1};//
        int key = 4;//10;//12;//8;//4;
        System.out.println(b.searchKey(nums, key));
    }

    private int searchKey(int[] nums, int key) {
        int maxIndex = findMax(nums);
        int keyIndex = binarySearch(nums, key, 0, maxIndex);
        if(keyIndex != -1)
            return keyIndex;
        return binarySearch(nums, key, maxIndex+1, nums.length - 1);
    }

    //order-agnostic binary search
    private static int binarySearch(int[] arr, int key, int start, int end){
        while(start <= end){
            int mid = start + (end - start) /2;

            if(key == arr[mid])
                return mid;

            if(arr[start] < arr[end]){//ascending order
                if(key < arr[mid]){
                    end = mid - 1;
                }else{//key > arr[mid]
                    start = mid + 1;
                }
            }else{//descending order
                if(key > arr[mid]){
                    end = mid - 1;
                }else{//key < arr[mid]
                    start = mid + 1;
                }
            }
        }
        return -1;//element not found
    }

    private int findMax(int[] nums) {

        int low=0, high = nums.length -1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[mid+1] ){
                high = mid;
            }else {//if(nums[mid]>nums[mid+1]){
                low = mid + 1 ;
            }

        }
        //at the end of loop start == end
        return low;//nums[low];
    }
}
