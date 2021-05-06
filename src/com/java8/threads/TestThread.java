package com.java8.threads;

/**
 * @author swamy on 2/4/21
 */
public class TestThread {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());

        };

        task.run();
        Thread t = new Thread(task);
        t.start();
        System.out.println("Done");
    }
}
