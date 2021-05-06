package com.techniques.binarysearch;

/**
 Find the maximum value in a given Bitonic array. An array is considered bitonic if it is monotonically increasing and
 then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

 Example 1:

 Input: [1, 3, 8, 12, 4, 2]
 Output: 12
 Explanation: The maximum number in the input bitonic array is '12'.
 Example 2:

 Input: [3, 8, 3, 1]
 Output: 8
 Example 3:

 Input: [1, 3, 8, 12]
 Output: 12
 Example 4:

 Input: [10, 9, 8]
 Output: 10
 */
public class BitonicArraymax {
    public static void main(String[] args) {
        BitonicArraymax b = new BitonicArraymax();
        int[] nums={1, 3, 8, 12, 4, 2};
        System.out.println(b.findMax(nums));
    }

    private int findMax(int[] nums) {

        int low=0, high = nums.length -1;
        while(low < high){
            System.out.println("low:"+low +"high:"+high);
            int hl = high - low;
            System.out.println("high - low:"+ hl);
            int mid = low + (high - low)/2;
            System.out.println("mid:"+mid);
            if(nums[mid] > nums[mid+1]){
                high = mid;
                System.out.println("high:"+high);
            }else{ //if(nums[mid]>nums[mid+1]){
                low = mid + 1 ;
                System.out.println("low:"+low);
            }
        }
        //at the end of loop start == end
        return nums[low];
    }
}
/*
Trace:
8> 12 =false
low = 3
4> 2= true
high = 4
*/
