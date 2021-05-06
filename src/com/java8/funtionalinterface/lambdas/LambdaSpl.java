package com.java8.funtionalinterface.lambdas;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaSpl {
    public static void main(String[] args) {

      //lexical scoping
        StringBuilder message = new StringBuilder();
        Runnable r = () ->System.out.println(message);
        message.append("Howdy");
        message.append("World!");
        r.run();

//Functional Interface
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

//Constructor Reference
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Swamy", "Biru");
        System.out.println(person);

        //scopig
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
      //  num  = 3; error
        System.out.println(stringConverter.convert(2));
        //local and static fields accessible to read and write in lambda expression


        //Default interface methods accessble from Anonymus declaration
        // but  not accessible in lambda expresion
      //works
        Formula formula = new Formula(){
            @Override
            public double calculate(int a){
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));//100.0
        System.out.println(formula.sqrt(16));//4.0

        //does not compile
       // Formula f = (a) -> sqrt(a * 100);


        //Built in functional interfaces

        //predicate return boolean, takes one parameter
        //methods: test, negate, and , or , isEqual
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));              // true
        System.out.println(predicate.negate().test("foo"));     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

//Function
        //takes  accept one argument and produce a result.
        // Default methods can be used to chain multiple functions together (compose, andThen). identity
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123"));     // "123"

        //Supplier

//        Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't accept arguments.

        Supplier<Person> personSupplier = Person::new;
        System.out.println(personSupplier.get());   // new Per

      //  Consumers#
       // Consumers represents operations to be performed on a single input argument.
        //returns void, methods: accept, andThen

                Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Biru", "Swamy"));

//Comparator
        //int compare, thenComparing
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("Biru", "Swamy");
        Person p2 = new Person("B", "Ran");

        System.out.println(comparator.compare(p1, p2));             // > 0
        System.out.println(comparator.reversed().compare(p1, p2));  // < 0


        //optional
        //isPresent, get, orElse, ifPresent
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));



        ///Streams: sequence of elements on which one or more operations performed
        //intermdiate and terminal operations

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        //filter: intermdeiate ,accpets predicate
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
//aaa2,aaa1
        //sort: intermediate, natural order if there is no comparator
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        //aaa1, aaa2

//map: intermediate, converts each element into other object via given funtion
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
    }

    //match: terminal, predicate
 /*   boolean anyStartsWithA =
            stringCollection
                    .stream()
                    .anyMatch((s) -> s.startsWith("a"));

System.out.println(anyStartsWithA);      // true

    boolean allStartsWithA =
            stringCollection
                    .stream()
                    .allMatch((s) -> s.startsWith("a"));

System.out.println(allStartsWithA);      // false

    boolean noneStartsWithZ =
            stringCollection
                    .stream()
                    .noneMatch((s) -> s.startsWith("z"));

System.out.println(noneStartsWithZ);      // true*/

    //count: terminal
  /*  long startsWithB =
            stringCollection
                    .stream()
                    .filter((s) -> s.startsWith("b"))
                    .count();

System.out.println(startsWithB);    // 3*/

    //reduce, terminal, tranform and reduce output
  /*  Optional<String> reduced =
            stringCollection
                    .stream()
                    .sorted()
                    .reduce((s1, s2) -> s1 + "#" + s2);

reduced.ifPresent(System.out::println);*/
// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

    //Map does not support streams
    //but have additional methods
    //putIfAbsent, getorDefault,merger, computeifAbsent
    Map<Integer, String> map = new HashMap<>();
/*
        for(int i = 0; i < 10; i++) {
        map.putIfAbsent(i, "val" + i);
    }

map.forEach((id, val) -> System.out.println(val));*/

}
