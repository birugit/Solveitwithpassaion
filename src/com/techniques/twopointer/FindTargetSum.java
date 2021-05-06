package com.techniques.twopointer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * find a pair in the array whose sum is equal to the given target.
 * @author swamy on 12/21/20
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 */
public class FindTargetSum {
    public static void main(String[] args) {
        FindTargetSum f = new FindTargetSum();
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;
       // int[] pos = f.findSum(arr, target);
        int[] pos = f.findTargetSum(arr, target);
        Arrays.stream(pos).forEach(i -> System.out.println(i));
    }

    /**
     * Time: O(N)
     * Space: 1
     * @param arr
     * @param target
     * @return
     */
    private int[] findSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while(left < right){
            int current = arr[left] + arr[right];
            if(target == current){
                return new int[]{left,right};
            }
            if(target > current){
                left++;
            }else{
                right--;
            }
        }
        return new int[] {-1, -1};
    }

    /**
     * Time: O(N)
     * Space: O(N)
     * @param arr
     * @param target
     * @return
     */
    private int[] findTargetSum(int[] arr, int target){
        HashMap<Integer, Integer> num = new HashMap<>();
        for(int i =0; i<arr.length; i++){

            if(num.containsKey(target-arr[i])){
                return new int[] {num.get(target - arr[i]),i};
            }else{
                num.put(arr[i],i);
            }
        }
        return new int[] {-1, -1};
    }
}
