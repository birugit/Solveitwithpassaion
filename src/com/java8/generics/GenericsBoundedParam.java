package com.java8.generics;

import java.util.Arrays;
import java.util.List;

public class GenericsBoundedParam {
    public static void main(String[] args) {

        //Bounded
        //use sumOfList for Integer is subtype of Number
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));
    // sumOfList for Double is subtype of Number
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));

        //Unbounded, works for Integer and String
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList(list);
        printList(ls);

        //lower bounded ? , accept Integer or its super type Number, Object anything hold Integer
        addNumbers(list);
    }
    //Generics type bounded params, > operator only applied on primitive type (int, char, ..)
    //fix this by using Comparator interface
   /* public static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e > elem)  // compiler error
                ++count;
        return count;
    }*/

    //Fix
    public interface Comparable<T> {
        public int compareTo(T o);
    }
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }


    //Wildcard ?
    //upperbounded relaxex, ex: ? extends Number, u can use it for Integer, Double...
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    //Unbounded wildcard
    //this accepts only Object or its subtypes, But it wont work for Integer, Double..
  /*  public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }*/

    //Solutuion:
    //? used to allow any type
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }


    //lower bounded wildcard
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
            System.out.println(list);
        }

    }
}
