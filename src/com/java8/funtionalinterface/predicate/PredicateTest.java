package com.java8.funtionalinterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Accept argument and return boolean
 * @FunctionalInterface public interface Predicate<T> { boolean test(T t); }
 *
 * @author swamy on 3/7/21
 */
public class PredicateTest {
  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(1, 2, 4,5, 6, 7, 9,3);
      Predicate<Integer> gr5 = x->x > 5;
      Predicate<Integer> noLessThan8 = x -> x < 8;
     List<Integer> res =  nums.stream().filter(gr5.and(noLessThan8)).collect(Collectors.toList());
     res.forEach(System.out::println);
  }
}
