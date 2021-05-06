package com.oracle.design.stack;

public class Stack<A> implements IStack<A> {
    private IStack<A> stack;
    private A a;
    public Stack(IStack<A> stack, A a){
        this.stack = stack;
        this.a = a;
    }

    public boolean isEmpty(){
        return false;
    }

    public A peek(){
        return a;
    }
    public IStack<A> push(A a){
        return new Stack<A>(this, a);
    }

    public IStack<A> pop(){
        return stack;
    }
}
