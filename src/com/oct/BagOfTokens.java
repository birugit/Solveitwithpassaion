package com.oct;

import java.util.Arrays;

/**
 * @author swamy on 10/24/20
 * Idea
 * It is clear that we should follow these two rules:
 *
 * Always trade less power for a point
 * Always trade a point for higher power
 * However, in my Solution1 I tried both the possibilities and got TLE. So I added memoization in Solution1.1 but still got TLE.
 *
 * Solution2 follows an overall greedy strategy of always favoring in gaining a point first over giving away a point for power (prefer rule1 over rul2) and it works. Since we are interested in maximizing points (and not power), we need to convert as many tokens as possible into points. There are no multiple paths to verify here (like in Solution1) as our strategy is to keep contracting the window [i..j] with the aim of maiximizing points.
 */
public class BagOfTokens {
    public static void main(String[] args) {
       int[] tokens = {100,200,300,400};
        int P = 200;
      int score =  BagOfTokens.bagOfTokensScore(tokens, P);
      System.out.println(score);
    }

    public static int bagOfTokensScore(int[] t, int p) {
        Arrays.sort(t);
        return helper(t, 0, t.length-1, p, 0);
    }
    private static int helper(int[] t, int i, int j, int p, int points){
        if(i > j) return points;
        int max = points;
        if(t[i] <= p)
            max = Math.max(max, helper(t, i+1, j, p-t[i], points+1));
        else if(points >= 1)
            max = Math.max(max, helper(t, i, j-1, p+t[j], points-1));
        return max;
    }
}
