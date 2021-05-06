package com.techniques.twopointer;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 *
 * Example 1:
 *
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * @author swamy on 12/28/20
 */
public class TripletSumClosestToTarget {
    public static void main(String[] args) {
    System.out.println(TripletSumClosestToTarget.searchTriplet(new int[]{-2, 0, 1, 2}, 2));

    }

    private static int searchTriplet(int[] arr, int targetSum) {
        if(arr == null || arr.length < 2)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 2; i++){
            int left = i + 1, right= arr.length - 1;
            while(left < right) {
                //comparing the sum of three numbers to the 'targetSum' can cause overflow
                //so, we will try to find a target difference
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0)//we have found a triplet with an exact sum
                    return targetSum - targetDiff;//return sum of all the numbers

                //the second part of the above 'if' is to handle the smallest sum when we have more than one
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
                    smallestDifference = targetDiff; //save the closest and the biggest difference

                if (targetDiff > 0)
                    left++; //we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum
            }

            }
        return targetSum - smallestDifference;
        }

}
