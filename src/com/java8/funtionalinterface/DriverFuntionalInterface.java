package com.java8.funtionalinterface;

public class DriverFuntionalInterface {
    public static void main(String[] args) {
        ParentFuntionalI a = ()->System.out.println("A");
        ChildFunctionalI b = ()-> {
            System.out.println("B");
        };

    }
}
