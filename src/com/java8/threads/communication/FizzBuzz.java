package com.java8.threads.communication;

/**
 * @author swamy on 3/12/21
 */
public class FizzBuzz {
  public static void main(String[] args) {
    FizzBuzzThread t1 = new FizzBuzzThread(new MutliThreadedFizzBuzz(6), "Fizz");
      FizzBuzzThread t2 = new FizzBuzzThread(new MutliThreadedFizzBuzz(10), "Buzz");
      FizzBuzzThread t3 = new FizzBuzzThread(new MutliThreadedFizzBuzz(15), "FizzBuzz");
      FizzBuzzThread t4 = new FizzBuzzThread(new MutliThreadedFizzBuzz(8), "Number");
      t1.start();
      t2.start();
      t3.start();
      t4.start();
  }
}
