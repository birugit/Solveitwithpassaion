package com.fb.threads;

import java.util.concurrent.*;

/**
 * Write a Java Program in which a class takes four integer arguments as input(a, b, c and d). Do addition of (a+b) on one thread, addition of (c+d) on another thread and multiplication of(a+b) * (c+d)) on main thread.
 * Like: Thread1 = (a+b)
 * Thread2 = (c+d)
 * Main Thread = (Thread1 * Thread2)
 * @author swamy on 1/31/21
 */
public class Calculator {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executerService = Executors.newFixedThreadPool(2);

        Task task1 = new Task(1, 2);

        Task task2 = new Task(3, 4);

        Future<Integer> asyncResult1 = executerService.submit(task1);

        Future<Integer> asyncResult2 = executerService.submit(task2);

        System.out.println(" Final output is - "+asyncResult1.get() * asyncResult2.get());


    }
    static class Task implements Callable<Integer> {


        Integer val1 = null;
        Integer val2 = null;

        public Task(Integer a, Integer b){
            this.val1 = a;
            this.val2 = b;
        }

        @Override
        public Integer call() throws Exception {
            return this.val1 + this.val2;
        }

    }

}
