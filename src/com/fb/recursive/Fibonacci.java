package com.fb.recursive;

/**
 * @author swamy on 3/1/21
 */
public class Fibonacci {
  public static void main(String[] args) {

      System.out.println(fib(6));
  }

    /**
     * T:(2^n) exponential
     * S:(N) max size of stack space required. app recurse too deeply
     * @param n
     * @return
     */

    private static int fib(int n) {
      if(n<=1)
          return n;
      return fib(n-1)+fib(n-2);
    }
}
