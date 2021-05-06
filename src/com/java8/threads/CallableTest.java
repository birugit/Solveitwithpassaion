package com.java8.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author swamy on 2/5/21
 */
public class CallableTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<Integer> task = ()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
                return 123;
            }catch(InterruptedException e){
                throw new IllegalStateException();
            }
        };

        Future<Integer> future = executorService.submit(task);
        System.out.println("Execturo is done?"+future.isDone());

        try {
            Integer res = future.get();
            System.out.println("Execturo is done?"+future.isDone());
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();

        //Invoke All
        ExecutorService eService = Executors.newWorkStealingPool();
        List<Callable<String>> tasks = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");
        eService.invokeAll(tasks)
                .stream().map(
                futre -> {
            try{
                return futre.get();
            }catch(Exception e){
throw new IllegalStateException();
            }
        }).forEach(System.out::println);

        eService.shutdownNow();
    }
}
