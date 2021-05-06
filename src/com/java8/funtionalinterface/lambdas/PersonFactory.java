package com.java8.funtionalinterface.lambdas;

public interface PersonFactory <P extends Person>{
    P create(String firstName, String lastName);
}
