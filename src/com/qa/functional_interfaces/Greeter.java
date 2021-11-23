package com.qa.functional_interfaces;

// A functional interface is an interface that has only one abstract method
// Also called Single Abstract Method interfaces
// May contain default or static methods also but only one abstract method
// Instances of the interface can be created using:
//  - anonymous inner classes
//  - lambda expressions
//  - method references
//  - constructor references

// Lambdas represent the implementation of a functional interface

@FunctionalInterface
public interface Greeter {

    public abstract void greet(String name);

//    public abstract void sayFarewell(String name);
}
