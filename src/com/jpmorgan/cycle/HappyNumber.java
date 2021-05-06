package com.jpmorgan.cycle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author swamy on 1/24/21
 */
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappyF(69));
     //   System.out.println(h.isHappy(7));
    }

    /**
     * T: O(logn)
     * S: O(logn)
     * @param n
     * @return
     */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    //Flyods Cycle finding algorithm

    /**
     * T: O(logn)
     * S: O(1)
     * @param n
     * @return
     */
    public int getNextF(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * T: O(logN)
     * S: o(1)
     * @param n
     * @return
     */
    public boolean isHappyF(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
