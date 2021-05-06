package com.java8.funtionalinterface.lambdas;

public class Person {
    String firstName;
    String lastName;

    Person(){

    }
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString(){
        return "{"+this.firstName +":"+this.lastName+"}";
    }
}
