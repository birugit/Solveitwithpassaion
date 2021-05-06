package com.techniques.slidingwindow.subarray.inro;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * @author swamy on 12/8/20
 */
public class MaxSubArray {
   // Input: [2, 1, 5, 1, 3, 2], k=3
   // Output: 9
   public static void main(String[] args) {


       int[] arr = {2, 1, 5, 1, 3, 2};
       int k = 3;

       //T O(N * K)
       //int maxSum = maxSumSubArray(arr, k);
       //System.out.println(maxSum);

       int maxSum = maxSumSubArrayBest(arr, k);
       System.out.println(maxSum);
   }

    /**
     * Time O(N)
     * Space O(1)
     * approach : use the window sum and , remove starting value and add the next value, slide window
     * @param arr
     * @param k
     * @return
     */
    private static int maxSumSubArrayBest(int[] arr, int k) {
       int maxSum = 0;
       int windowStart = 0;
       int windowSum = 0;
       for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
           windowSum += arr[windowEnd];//add the next element
           //slide the window, dont need to slide if dont meet window size.
           if(windowEnd >= k -1){
               maxSum = Math.max(maxSum, windowSum);
               windowSum -= arr[windowStart];//remove starting element
               windowStart++;//move window ahead
           }
       }
       return maxSum;
    }

    /**
     * Time O(N * K) N is number of elements
     * @param arr
     * @param k
     * @return
     */
    private static int maxSumSubArray(int[] arr, int k) {
       int maxSum = 0, windowSum = 0;
       for(int i=0; i<=arr.length - k; i++){
           windowSum = 0;
           for(int j=i; j< i+k; j++){
               windowSum += arr[j];
               maxSum = Math.max(maxSum, windowSum);
           }
       }
       return maxSum;
    }
}
