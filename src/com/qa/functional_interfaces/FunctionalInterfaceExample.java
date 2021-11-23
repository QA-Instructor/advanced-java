package com.qa.functional_interfaces;

import java.util.ArrayList;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        exampleA();
//        exampleB();
//        exampleC();
//        exampleD();
    }

    public static void exampleA(){
// Create an anonymous inner class from the interface

        Greeter greeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("Hello " + name); // implement the abstract method
            }
        }; // end of anonymous inner class

//        call the method of the anonymous class
        greeter.greet("Everyone");
        greeter.greet("Team");
    }

    public static void exampleB(){
// Shorten the syntax by using a lambda
// Lambdas provide a short and simple way to implement functional interfaces

        Greeter greeter = (String name) -> {
            System.out.println("Hello " + name);
        };

//        call the method of the anonymous class
        greeter.greet("Everyone");
        greeter.greet("Team");
    }

    public static void exampleC() {
// Method references are a shorthand way of writing a certain type of lambda expression
// A lambda that passes in a variable and then calls a method on that variable can
// be replaced with a method reference
// Method references use the :: operator (aka Method Reference Delimiter)
// target of reference (receiver) :: name of method (or constructor)
// A method reference refers to the method but doesn't invoke it (the forEach does the invocation)
// They refer to methods of existing classes or objects whereas a lambda expression allows us to
// define an anonymous method and treat it as an instance of a functional interface

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

//        as lambda expression
        arrayList.forEach(n -> System.out.println(n));
//        as method reference to static println method
        arrayList.forEach(System.out::println);
    }

    public static void exampleD() {
// Constructor references
// target of reference (receiver) :: name of method (or constructor)
// A constructor / method reference refers to the method but doesn't invoke it (the 'get' does the invocation here)

//        The get method within this functional interface matches the empty constructor
        EmployeeEmpty empEmpty = Employee::new;

        System.out.println("Constructor has yet to be called");
//        get will create the object instance e.g. a factory method
        Employee emp1 = empEmpty.get(); // constructor called and employee instance is returned
        System.out.println(emp1); // toString is invoked by the print statement
        System.out.println(empEmpty); // the method reference expression has an implicit lambda expression
        // which uses the implementation of referred method or constructor at runtime.

//        The get method within this functional interface matches the constructor that takes a string
        EmployeeWithName empWithName = Employee::new;

        System.out.println("Constructor has yet to be called");
        System.out.println(empWithName.get("Rob"));
    }
}
