package com.fb.dp.topdown;

/**
 * @author swamy on 2/1/21
 */
public class Fibbonacci {
    public static void main(String[] args) {
        Fibbonacci f = new Fibbonacci();
        int res = f.fib(5);
        System.out.println(res);
    }

    private Integer[] cache = new Integer[31];

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(N);
    }

    public int memoize(int N) {
        if (cache[N] != null) {
            return cache[N];
        }
        cache[N] = memoize(N-1) + memoize(N-2);
        return memoize(N);
    }
}
