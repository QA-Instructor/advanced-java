package com.qa.generics;

// Generics were introduced in Java 5 to provide developers with more compile-time type information.
// Removes the risk of ClassCastException
// Commonly used when working with Collections

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

    public static void main(String[] args) {
//  Create a list, add an item to it, get the zeroth item out of the list, print to the terminal
        nonGenericListExample();
//        genericListExample();
//
//        nonGenericMethodExample();
//        genericMethodExample();

    }

    public static void nonGenericListExample(){
        // Example without Generics - effectively Object
        List names = new ArrayList();
        names.add("Victoria");
//        Note the downcast
        String name = (String) names.get(0);
        System.out.println("First name: " + name);
//        Compiler is happy to let us add anything to our list. Difficult to work with if a large list
        names.add(7);
        names.add(true);
        System.out.println(names);
//        String name2 = (String) names.get(1);
//        String name2 = names.get(1).toString();
//        System.out.println(name2);
    }

    public static void genericListExample(){
        // Example with Generics - <String>
        List<String> names2 = new ArrayList();
        names2.add("Rob");
        String name2 = names2.get(0); // Note - no downcast is required
        System.out.println("First name: " + name2);
//        Compiler warning when uncommented because it checks that only strings can be added
//        names2.add(7);
//        names2.add(String.valueOf(7));
        System.out.println(names2);
    }


    public static void nonGenericMethodExample() {
        Character[] charArray = {'w', 'e', 'l', 'c', 'o', 'm', 'e'};
        Boolean[] boolArray = {true, false, true};
        Integer[] intArray = {1, 2, 3, 4, 5};

        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
        List<Integer> intList = arrayToList(intArray, new ArrayList<>());

        // There is no type checking - I have assigned a list of ints to a list of strings
        List<String> stringListOfInts = arrayToList(intArray, new ArrayList<>());
        // Try to get the zeroth value
        System.out.println(intList.get(0));//original intList, so okay, correct type
//        System.out.println(stringListOfInts.get(0));//not okay, incorrect type ClassCastException

    }
// non generic
    public static List arrayToList(Object[] array, List<Object> list) {
        for (Object object : array) {
            list.add(object);
        }
        return list;
    }
// generic - uses <T>
    public static <T> List<T> arrayToListGeneric(T[] array, List<T> list) {
    //    Useful if we want to be flexible about the types of objects we can pass in
    //    Put the type parameter before the method's return type
        for (T object : array) {
            list.add(object);
        }
        return list;
    }

    public static void genericMethodExample() {
        Character[] charArray = {'w', 'e', 'l', 'c', 'o', 'm', 'e'};
        Boolean[] boolArray = {true, false, true};
        Integer[] intArray = {1, 2, 3, 4, 5};

        List<Character> charList = arrayToListGeneric(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToListGeneric(boolArray, new ArrayList<>());
        List<Integer> intList = arrayToListGeneric(intArray, new ArrayList<>());

        // Now there is type checking - I can not assign a list of ints to a list of strings
//        List<String> stringListOfInts = arrayToListGeneric(intArray, new ArrayList<>());
        // Try to get the zeroth value
        System.out.println(intList.get(0));//okay, correct type
    }

}