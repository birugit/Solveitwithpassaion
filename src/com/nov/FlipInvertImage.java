package com.nov;

import java.util.Arrays;

/**
 *
 Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

 To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

 To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

 Example 1:

 Input: [[1,1,0],[1,0,1],[0,0,0]]
 Output: [[1,0,0],[0,1,0],[1,1,1]]
 Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 Example 2:

 Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * @author swamy on 11/10/20
 */
/*
The idea is simple. For each row, use two pointers. One is going forward and the other is going backward.
(1). If the two elements are the same, then make a slight change like this 0 -> 1 or 1 -> 0.
(2). If the two elements are different, DON'T do anything. Just let it go.
 */
    public class FlipInvertImage {

    public static void main(String[] args) {
        FlipInvertImage f = new FlipInvertImage();

        int image[][] = {
                {1,1,0},
                {1,0,1},
                {0,0,0}

        };
        int[][] res = f.flipAndInvertImage(image);
        Arrays.stream(res).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::print);



    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int lo = 0, hi = A[0].length - 1;
            while (lo <= hi) {
                if (A[i][lo] == A[i][hi]) {
                    A[i][lo] = 1 - A[i][lo];
                    A[i][hi] = A[i][lo];
                }
                lo++;
                hi--;
            }
        }

        return A;
    }
}
