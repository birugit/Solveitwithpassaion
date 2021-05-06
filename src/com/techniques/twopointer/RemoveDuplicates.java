package com.techniques.twopointer;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.
 *
 * Example 1:
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * @author swamy on 12/22/20
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] arr = {2, 3, 3, 3, 6, 9, 9};
        int len = r.removeDupes(arr);
        System.out.println(len);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     * @param arr
     * @return
     */
    private int removeDupes(int[] arr) {
        int nextDuplicate = 1;
        for(int i = 1; i< arr.length; i++){
            if(arr[nextDuplicate - 1] != arr[i]){
                arr[nextDuplicate] = arr[i];
                nextDuplicate++;
            }
        }
        return nextDuplicate;
    }
}
