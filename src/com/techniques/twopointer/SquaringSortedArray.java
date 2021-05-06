package com.techniques.twopointer;

import java.util.Arrays;

/**
 * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
 *
 * Example 1:
 *
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * @author swamy on 12/23/20
 */
public class SquaringSortedArray {
    public static void main(String[] args) {
        SquaringSortedArray s = new SquaringSortedArray();
        int[] arr = {-2, -1, 0, 2, 3};
        int[] res = s.calcSquare(arr);
        Arrays.stream(res).forEach(i -> System.out.println(i));
    }

    /**
     * Time: O(N)
     * Space: O(N)
     * @param arr
     * @return
     */
    private int[] calcSquare(int[] arr) {
        int left = 0, right = arr.length - 1;
        int highIndex = arr.length - 1;
        int[] squares = new int[arr.length];
        while(left <= right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if(leftSquare > rightSquare){
                squares[highIndex--] = leftSquare;
                left++;
            } else {
                squares[highIndex --] = rightSquare;
                right --;
            }
        }
        return squares;
    }

}
