package com.java8.funtionalinterface.lambdas;

@FunctionalInterface
public interface Converter<F, T> {
    //one abstract method
    T convert(F from);
   // T convert(F from, T to);
}
