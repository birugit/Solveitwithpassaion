package com.jpmorgan;

/**
 * @author swamy on 12/20/20
 */
public class FiboncciNumbers {
    public static void main(String[] args) {
        int sum = fibonacci(6);
        System.out.println(sum);
        //1 + 1 + 2 + 3 + 5
    }

    /**
     * Bottom up approach using memorization
     * Time: O(N)
     * Space: O(N)
     * @param N
     * @return
     */
    private static int fibonacci(int N) {

        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    static int  memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }

}
