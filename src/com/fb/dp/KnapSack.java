package com.fb.dp;

/**
 *  Given a Knapsack of a maximum capacity of W and N items each with its own
 *  * value and weight, throw in items inside the Knapsack such that the final
 *  * contents has the maximum value.
 * @author swamy on 1/13/21
 */
public class KnapSack {


    public static void main(String[] args) {
        // int val[] = new int[] {60, 100, 120};
        // int wt[] = new int[]{10, 20, 30};
        int val[] = new int[] { 1, 2, 5, 6 };
        int wt[] = new int[] { 2, 3, 4, 5 };
        int W = 8;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));

    }

    private static int knapsack(int W, int[] wt, int[] val, int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // build table k[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w) {
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }

            }

        }

        // print
        while (n != 0) {
            if (K[n][W] != K[n - 1][W]) {
                System.out.println("\tPakckage " + n + " with W= " + wt[n - 1] + "and value = " + val[n - 1]);
                W = W - wt[n - 1];//8-6=2
            }
            n--;
        }

        return K[n][W];
    }

    private static int max(int a, int b) {
        return (a > b ? a : b);

    }


}
