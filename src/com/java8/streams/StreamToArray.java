package com.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamToArray {
    public static void main(String[] args) {



     //   List<String> userNames = Arrays.asList("James", "Jack", "Johnny", "Frank", "Bob");
        String[] a = {"Dog", "Cat", "Llama", "Monkey"};
        List<String> userNames = Arrays.asList(a);
        List<String> longestPair =
                IntStream.range(0, userNames.size() - 1)
                        .mapToObj(i -> Arrays.asList(userNames.get(i),  userNames.get(i + 1)))
                        .max(Comparator.comparing(pair -> pair.get(0).length() > pair.get(1).length()))
                        .orElseThrow(() -> new IllegalStateException("the list should have at least 2 elements"));

//returns the length of longest item
     /*   Optional<String> maxOpt  = userNames.stream()
               // .map(A::getName)
                .map(String::length)
              //  .filter()
                .max();
            System.out.println("longestPair = " + maxOpt);*/

        final int max_len = userNames.stream()
                .max(Comparator.comparingInt(s ->
                        s.length())) //need a lambda
           //     .map(A::getName)
                .map(String::length)
                .orElse(0); //defaulting to 0

        System.out.println("max_len = " + max_len);

        //Gap Jesie Test
        //return string with ma length
        // String[] a = {"Dog", "Cat", "Llama", "Monkey"};
       String res = userNames.stream()
                .max(Comparator.comparingInt(s ->
                        s.length())) //need a lambda
                //     .map(A::getName)
                .get();
       System.out.println("maxlenght Stirng:"+res);




        System.out.println("max_len = " + max_len);

        List<String>  wordList = new ArrayList<>();
        wordList.add("Java8");
        wordList.add("life");
        wordList.add("easy");

        //convert  list -> stream -> array
        String[] wordArr = wordList.stream()
                            .map(String::toUpperCase)//method reference
                            .toArray(String[]::new);//method reference
        System.out.println("**List to Array via stream**");
        for(String word: wordArr)
        System.out.println(word);

        //String --> stream --> String Array
        String wordS = "Java8 made life easy";
        String[] stringToArray = Arrays.stream(wordS.split("\\s+"))
                                    .map(s -> s.toUpperCase())//lambda expression
                                    .toArray(String[]::new);//method reference
        System.out.println("**String to Array via stream**");
        for(String word: stringToArray)
            System.out.println(word);

        String[] stringToArraySize = Arrays.stream(wordS.split("\\s+"))
                .map(s-> s.toLowerCase())
                .filter(s -> s.length() > 4)//lambda expression
                .toArray(size -> new String[size]);//by specifying sizeR
        System.out.println("**String to Array via stream using size**");
        for(String word: stringToArraySize)
            System.out.println(word);


        //String --> stream --> ArrayList
        System.out.println("## String to ArrayList ##");
        ArrayList<String> wordAList = Arrays.stream(wordS.split("\\s+"))
                                        .map(s -> s.toLowerCase())
                                        .peek(System.out::println)//watches all elements of stream, used for debeuuging
                                        .collect(Collectors.toCollection(ArrayList::new));
                                       // .collect(Collectors.toList());this doest work, its not thread safe, mutable, not profiding specific type list

        System.out.println("**String to ArrayList via stream**");
            System.out.println(wordAList);


            //Array to Stream
        String[] strArr = {"one", "two", "three"};
        Stream arrToStream = Stream.of(strArr);//of is factory method of stream to convert
                System.out.println("** Array to Stream **");
                arrToStream.forEach(System.out::println);
    }

   // int getLongestLenthAnimal( String[] a){
       // List<String> animalList = Arrays.asList(a);


  //  }

}
