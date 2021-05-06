package com.java8.threads.concurrentmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

class ConcurrentMapForkJoin {

    public static void main(String[] args) {
        //print the available cores in system
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        //parallel processing methods are forEach, Search, reduce
        //prallel processing starts if no of tasks greater than parallelismThreshold. otherwise process sequnetially
        map.forEach(1, (key, value) ->
                System.out.printf("key: %s; value: %s; thread: %s\n",
                        key, value, Thread.currentThread().getName()));
     //   map.forEach(1, (k,v) -> System.out.printf("%s; %s; \n",k,v));

        /*
        output:
        key: r2; value: d2; thread: main
        key: han; value: solo; thread: ForkJoinPool.commonPool-worker-3
        key: foo; value: bar; thread: ForkJoinPool.commonPool-worker-9
        key: c3; value: p0; thread: main
         */

        //Search
        String result = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("foo".equals(key)) {
                return value;
            }
            return null;
        });
        System.out.println("Result: " + result);

        //search based on Values only
        String valResult = map.searchValues(1, value -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });
        System.out.println("Val Result:"+valResult);


        //Reduce
        /*
        The method reduce() already known from Java 8 Streams accepts two lambda expressions of type BiFunction.
         The first function transforms each key-value pair into a single value of any type.
         The second function combines all those transformed values into a single result, ignoring any possible null values.
         */
        System.out.println("*****Reducce:**** " );
        String reduceResult = map.reduce(1,
                (key, value) -> {
                    System.out.println("Transform: " + Thread.currentThread().getName());
                    return key + "=" + value;
                },
                (s1, s2) -> {
                    System.out.println("Reduce: " + Thread.currentThread().getName());
                    return s1 + ", " + s2;
                });

        System.out.println("Result: " + reduceResult);

    }

}
