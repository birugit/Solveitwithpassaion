package com.oracle.design.stack;

public interface IStack<A>{
    public boolean isEmpty();
    public A peek();
    public IStack<A> push(A a);
    public IStack<A> pop();
}
