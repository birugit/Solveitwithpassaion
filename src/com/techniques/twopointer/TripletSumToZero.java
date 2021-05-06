package com.techniques.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Example 1:
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * @author swamy on 12/23/20
 */
public class TripletSumToZero {
    public static void main(String[] args) {
        TripletSumToZero t = new TripletSumToZero();
        int[] arr = {-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> res = t.findTripletSumToZero(arr);
        res.stream().forEach(System.out::println);
    }

    /**
     * sorting will take O(N * logN)
     * Search pair will take o(N^2)
     * Time: O(N^2) asymptotically
     *
     * Space: O(N)
     * @param arr
     * @return
     */
    private List<List<Integer>> findTripletSumToZero(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i=0; i< arr.length -2; i++){
            if(i > 0 && arr[i] == arr[i - 1]){//skip the same element to avoid duplicate triplets
                continue;
            }
            searchPair(arr, -arr[i], i+1, triplets);
        }
        return triplets;

    }

    /**
     * Time: O(N) for one number, for all numbers O(N^2)
     * @param arr
     * @param targetSum
     * @param left
     * @param triplets
     */
    private void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while(left < right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == targetSum){// found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while(left < right && arr[left] == arr[left -1])
                    left++; //skip same element to avoid duplicate triplets
                while(left < right && arr[right] == arr[right + 1])
                    right--; //skip same element to avoid duplicate triplets
            }else if(targetSum > currentSum)
                left++;// we need a pair with a bigger sum
            else
                right--; //we need a pair with a smaller sum
        }
    }
}
