package com.java8.funtionalinterface.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author swamy on 3/7/21
 */
public class FunctionTest {
  public static void main(String[] args) {
      FunctionTest f = new  FunctionTest();
    //Function is functional interface takes input T and returns result R
      //have method apply
      Function<String, Integer> func = s -> s.length();
      Integer apply = func.apply("Swamy");//5
      System.out.println(apply);

      //Chain Function <T, R>
      //chain fucntion with andThen

      Function<Integer, Integer> func2 = s -> s * 2;
      Integer res = func.andThen(func2).apply("Swamy");//10
      System.out.println(res);

      //convert list to map
      List<String> lang = Arrays.asList("java", "Go", "python");
      Map<String,Integer> map = f.convertListToMap(lang, func);
      System.out.println(map);
  }

    private <T, R> Map<T, R> convertListToMap(List<T> lang, Function<T, R> func) {
      Map<T, R> res = new HashMap<>();
      for(T t : lang){
            res.put(t, func.apply(t));
      }
      return res;
    }
}
