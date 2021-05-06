package com.fb.dp.bottomup;

/**
 * @author swamy on 2/1/21
 */
public class Fibonacci {
    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();
        int res = f.fib(6);
        System.out.println(res);
    }

    /**
     * Bottom Up approach
     * T:O(N)
     * S:O(N)
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    public int memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[N];
    }
}
