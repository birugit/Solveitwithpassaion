package com.java8.threads.concurrentcollections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList makes a copy each time new element added to it
 * read or write operations performed on copy
 * compared to Synchronization lock, this is better in performance.
 * @author swamy on 3/11/21
 */
public class CopyOnWriteArrayListTest {
  public static void main(String[] args) {
      CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<>(new Integer[]{1 ,2, 3});
      Iterator<Integer> it = arr.iterator();
      arr.add(10); //this 10 not available in above iterator, iterator only have immutable copy of 1, 2, 3
      List<Integer> result = new LinkedList<>();
      it.forEachRemaining(result::add);
      result.forEach(System.out::println);

      //if we create a new iteraot, it will be having the 1,2,3,10

      //removing while iterating is not allowed

  }
}
