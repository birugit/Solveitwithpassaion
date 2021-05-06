package com.java8.funtionalinterface.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 *  it takes no arguments and returns a result.
 * @FunctionalInterface public interface Supplier<T> { T get(); }
 *
 * @author swamy on 3/7/21
 */
public class supplierTest<T> {

  public static void main(String[] args) {
      supplierTest<String> s = new supplierTest();
      List<String> list = s.supplier().get();
  }

    private Supplier<List<T>> supplier() {
      return ArrayList::new;
    }
}
