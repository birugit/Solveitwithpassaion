package com.java8.generics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GenericsRestriction {
    class Pair<K, V>{
        private K key;
        private V value;
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {

        //2.Cannot Create Instances of Type Parameters
        List<String> ls = new ArrayList<>();
        append(ls, String.class);

    }
    //1.Cannot Instantiate Generic Types with Primitive Types
    //compile time error
    //Pair<int, char> p = new Pair<>(8, 'c');

    //Right way of instantiation
    Pair<Integer, Character> pair = new Pair<>(8, 's');

    //2.Cannot Create Instances of Type Parameters
    public static <E> void append(List<E> list) {
         // compile-time error
      //  E elem = new E();
      //  list.add(elem);
    }

    //right way of creating instances, using Reflection
    public static <E> void append(List<E> list, Class<E> cls) throws Exception {
        E elem = cls.newInstance();   // OK
        list.add(elem);
    }


    //3.Cannot Declare Static Fields Whose Types are Type Parameters
  /*  public class MobileDevice<T> {
        //compiler error
        private static T os;

        // ...
    }
    //creates confusion, becuase static is a class variable
    MobileDevice<Smartphone> phone = new MobileDevice<>();
    MobileDevice<Pager> pager = new MobileDevice<>();
    MobileDevice<TabletPC> pc = new MobileDevice<>();
*/

    //4. Cannot Use Casts or instanceof with Parameterized Types
    //runtime dont know what is its type, instead use unbounded wild card
   /* public static <E> void rtti(List<E> list) {
        if (list instanceof ArrayList<Integer>) {  // compile-time error
            // ...
        }
    }*/
    //S = { ArrayList<Integer>, ArrayList<String> LinkedList<Character>, ... }

    //using unbounded wildcard
    public static void rtti(List<?> list) {
        if (list instanceof ArrayList<?>) {  // OK; instanceof requires a reifiable type
            // ...
        }
    }

    // cannot cast to a parameterized type unless it is parameterized by unbounded wildcards. For example:
    //
    //List<Integer> li = new ArrayList<>();
    //List<Number>  ln = (List<Number>) li;  // compile-time error

    //some cases the compiler knows that a type parameter is always valid and allows the cast. For example:
    //
    //List<String> l1 = ...;
    //ArrayList<String> l2 = (ArrayList<String>)l1;  // OK


    //5.Cannot Create Arrays of Parameterized Types
  //  List<Integer>[] arrayOfLists = new List<Integer>[2];  // compile-time error

   /* Object[] strings = new String[2];
    strings[0] = "hi";   // OK
    strings[1] = 100;    // An ArrayStoreException is thrown.

    Object[] stringLists = new List<String>[];  // compiler error, but pretend it's allowed
    stringLists[0] = new ArrayList<String>();   // OK
    stringLists[1] = new ArrayList<Integer>();  // An ArrayStoreException should be thrown,
    // but the runtime can't detect it.*/


    //6. Cannot Create, Catch, or Throw Objects of Parameterized Types
    // Extends Throwable indirectly
   // class MathException<T> extends Exception { /* ... */ }    // compile-time error

    // Extends Throwable directly
    //class QueueFullException<T> extends Throwable { /* ... */ // compile-time error

   // cannot catch an instance of a type parameter:
   /* public static <T extends Exception, J>
   void execute(List<J> jobs) {
        try {
            for (J job : jobs)
            // ...
        } catch (T e) {   // compile-time error
            // ...
        }
    }*/
   // You can, however, use a type parameter in a throws clause:

    class Parser<T extends Exception> {
        public void parse(File file) throws T {     // OK
            // ...
        }
    }


    //7.Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type
    //A class cannot have two overloaded methods that will have the same signature after type erasure.
    public class Example {
        public void print(Set<String> strSet) { }
      //  public void print(Set<Integer> intSet) { }
    }
}
