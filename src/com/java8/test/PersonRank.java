package com.java8.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonRank {


    // 1 - Print the list of names (String[]) / try with lambdas
    // 2 - Transform this String[] to a List<Person> where Person.rank is the number of times the name appeared in the String[]
   /*
      3 - Print the List<Person> showing rank and the name.
        e.g.
            1 Ana
            3 Tom
            1 Charles
            1 Bob
            4 Paul
   */
   /*
        Write a function that calculates and print a leaderboard given a list of winning usernames.
        For instance:
        ['Tom', 'Tom', 'Ana', 'Bob', 'Charles', 'Paul', 'Paul', 'Paul', 'Tom', 'Paul'];
        Should print:
            4 Paul
            3 Tom
            1 Ana
            1 Bob
            1 Charles

            if there's a tie. Returns in alphabetical order.
    */
    public void printLeaderBoard(String[] names) {
        Stream.of(names).forEach(System.out::println);

        HashMap<String, Integer> personMap = new HashMap<>();

        for (String name : names) {
            personMap.put(name, personMap.getOrDefault(name, 0) + 1);
        }
        System.out.println(personMap);
        List<Person> persons = new ArrayList<>();
        for (Map.Entry<String, Integer> person : personMap.entrySet()) {
            persons.add(new Person(person.getKey(), person.getValue()));
        }

        List<Person> personList = persons.stream()
                .sorted((a, b) -> b.rank - a.rank)
                .collect(Collectors.toCollection(ArrayList::new));

        personList.forEach(System.out::println);

    }


    class Person {
        public String name;
        public int rank;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", rank=" + rank +
                    '}';
        }

        public Person(String n, int r) {
            name = n;
            rank = r;
        }

        public Person() {
        }


    }

    public static void main(String[] args) {
        System.out.println("Nisum Technologies Inc.");
        PersonRank sol = new PersonRank();
        String[] names = {"Tom", "Tom", "Ana", "Bob", "Charles", "Paul", "Paul", "Paul", "Tom", "Paul"};
        sol.printLeaderBoard(names);
    }
}
