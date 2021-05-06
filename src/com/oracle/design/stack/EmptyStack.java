package com.oracle.design.stack;

import java.util.EmptyStackException;


public class EmptyStack<A> implements IStack<A>{
    public boolean isEmpty(){
        return true;
    }
    public A peek(){
        throw new EmptyStackException();
    }
    public IStack<A> push(A a){
        return new Stack<A>(this, a);
    }

    public IStack<A> pop(){
        throw new EmptyStackException();
    }
}
