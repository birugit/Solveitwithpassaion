package com.java8.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger c = new AtomicInteger(0);
    public static void main(String[] args) {

        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }



    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }
}
