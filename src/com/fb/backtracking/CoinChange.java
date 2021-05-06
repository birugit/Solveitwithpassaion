package com.fb.backtracking;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *Bruteforce technicque TLE
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * @author swamy on 1/25/21
 */
public class CoinChange {
    public static void main(String[] args) {

        CoinChange c = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        int res =  c.coinChange(0, coins, amount);
        System.out.println(res);
    }

    /**
     * O(S^n)
     * O(n)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        return coinChange(0, coins, amount);
    }
    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            System.out.println("idxCoin: "+idxCoin);
            int maxVal = amount/coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
          if (res != -1) {
              System.out.println("res: "+res+" x: "+x);
            minCost = Math.min(minCost, res + x);
            System.out.println("minCost: "+minCost);
                        }
                }
            }
            System.out.println("minCostOut: "+minCost);
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }
}
