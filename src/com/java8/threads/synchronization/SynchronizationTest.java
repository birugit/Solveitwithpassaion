package com.java8.threads.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author swamy on 2/5/21
 */
public class SynchronizationTest {
    static int count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, 1000)
                .forEach(i -> executorService.submit(SynchronizationTest::increment));
        executorService.shutdownNow();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
    static void increment(){
        synchronized("obj1") {
            count = count + 1;
        }
    }

}
