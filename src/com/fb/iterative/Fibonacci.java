package com.fb.iterative;

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
     * T:O(N)
     * S:O(1)
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
