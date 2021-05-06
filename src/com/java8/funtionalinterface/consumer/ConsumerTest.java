package com.java8.funtionalinterface.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @FunctionalInterface
 * public interface Consumer<T> {
 * void accept(T t);
 * }
 *
 * @author swamy on 3/7/21
 */
public class ConsumerTest {
  public static void main(String[] args) {

      //Consumer take one input arg and not returns anything
    Consumer<String> print = x->System.out.println(x);
    print.accept("Swamy");

    //custom forEach
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
      Consumer<Integer> consumer = x -> System.out.println(x);
      forEach(list, consumer);
  }

    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
      for(T n: list){
          consumer.accept(n);
      }
    }
}
