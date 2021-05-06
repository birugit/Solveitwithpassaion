package com.fb.dp.bottomup;

/**
 * @author swamy on 1/28/21
 */
public class PaintFence {
    public static void main(String[] args) {
        PaintFence p = new PaintFence();
        int res = p.numWays(3,2);
        System.out.print(res);
    }

    /**
     * This approach also follows the intuition mentioned in the Approach 1: \text{totalWays}(i)=(\text{totalWays}(i-1)+\text{totalWays}(i-2))\cdot(k-1)totalWays(i)=(totalWays(i−1)+totalWays(i−2))⋅(k−1) for i>2i>2. But, instead of using recursions, we use iterations to retrieve the value for totalWays(i) in the bottom-up manner.
     *
     * Algorithm
     *
     * We would initiate an array dp[] where dp[i] is the number of ways to paint i posts. Hence we have dp[i] = (dp[i-1]+dp[i-2])*(k-1). Iterating i until n, we can calculate the values for i \in \{1, \dotsc,n\}i∈{1,…,n}.
     *
     * T: O(N)
     * S: O(N)
     * @param n
     * @param k
     * @return
     */
    public int numWays1D(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int[] dp = new int[n + 1];
        // initialize special cases
        dp[1] = k;
        dp[2] = k * k;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }
        return dp[n];
    }

    /**
     * Notice that dp[i] only relies on dp[i-1] and dp[i-2], therefore it's possible to use two variables instead of the array to reduce the space complexity from \mathcal{O}(n)O(n) to \mathcal{O}(1)O(1).
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int last = k * k;
        int second_last = k;
        for (int i = 3; i <= n; i++) {
            int tmp = (last + second_last) * (k - 1);
            second_last = last;
            last = tmp;
        }
        return last;
    }
}
