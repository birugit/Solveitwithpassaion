package com.java8.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author swamy on 2/4/21
 */
public class ExecutorTest {
    public static void main(String[] args) {
        //Creates thread pool
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName());

        });

        //Executor service is asynchronous and need to shutdown externally
        //shutdown - gives time to complete running tasks
        //showtdownNow - terminates immediately
        try{
            System.out.println("Attempting to shutdown");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            System.out.println("Task interrupted");
        }finally {
            if(!executorService.isTerminated()){
                System.out.println("terminate non completed task");
            }

            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
