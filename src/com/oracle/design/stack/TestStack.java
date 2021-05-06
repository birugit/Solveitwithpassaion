package com.oracle.design.stack;

public class TestStack {

    public static void printInfo(String stackName, IStack<?> stack){
        System.out.println("-----------");
        System.out.println(stackName + ":");
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is Empty: " + isEmpty);
        if(!isEmpty){
            System.out.println("Item: " + stack.peek());
        }
    }
    public static void main(String[] args) {
        IStack<Character> empty1 = new EmptyStack<>();
        IStack<Character> aStack1 = empty1.push('a');
        IStack<Character> abStack = aStack1.push('b');
        IStack<Character> aStack2 = abStack.pop();
        IStack<Character> empty2 = aStack2.pop();

        printInfo("empty1", empty1);
        printInfo("aStack1", aStack1);
        printInfo("abStack", abStack);
        printInfo("aStack2", aStack2);
        printInfo("empty2", empty2);

    }
}
