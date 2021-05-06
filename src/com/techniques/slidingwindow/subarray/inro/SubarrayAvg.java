package com.techniques.slidingwindow.subarray.inro;

import java.util.Arrays;

/**
 * @author swamy on 11/11/20
 *
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 *
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 *
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */
public class SubarrayAvg {
    public static void main(String[] args) {
        SubarrayAvg s = new SubarrayAvg();
        int[] input = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;

        double[] avgArray = s.averageOfArraySizeKBruteforce(input, K);
        Arrays.stream(avgArray).forEach(System.out::println);

        //avoid extra time iterating each time five elements by
        //remove beginning element and add next element to sum, using sliding window technique

     //   double[] avgArrayRes = s.averageOfArraySizeKSlidingWindo(input, K);
       // Arrays.stream(avgArrayRes).forEach(System.out::println);
    }

   /* private double[] averageOfArraySizeKSlidingWindo(int[] input, int k) {

    }*/


    /**
     * Time Complexity: N * K
     * @param input
     * @param k
     * @return
     */
    private double[] averageOfArraySizeKBruteforce(int[] input, int k) {
        double[] res = new double[input.length - k + 1];
        for (int i = 0; i <= input.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += input[j];
                res[i] = sum / k;
            }
        }
        return res;
    }

}
