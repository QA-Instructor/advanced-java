package com.qa.optionals;
import java.util.Optional;

//  Note the import for java.util.Optional
//  Optional acts as a container for objects that might or might not contain a value
//  Used instead of returning a null pointer
//  We will see these used with the Stream API later

public class OptionalsExample {
    public static void main(String[] args) {
//  Assign a value using 'ofNullable' or 'of'
//  Use 'of' with a present non-null value
//  Use 'ofNullable' if the value may be null e.g. extracting data from a database that may or may
//  not exist

        Optional<String> item;

        if(Math.random() >= 0.5) {
            item =  Optional.of("Hello"); // would throw a NullPointerException if the value is null
//          item =  Optional.ofNullable("Hello"); would return an empty Optional if value is null
        } else {
//          Use empty() to return an empty optional instance
            item = Optional.empty();
        }

//  Use isPresent to test for a non-empty value
        System.out.println("Is there a value present? " + item.isPresent());

        if (item.isPresent()){
            System.out.println(item);
//          use get to retrieve the item within the optional (throws an error if empty)
            String unwrappedString = item.get();
            System.out.println(unwrappedString);
        }
        else
        {
            System.out.println("There is no value in the optional");
            System.out.println("This will raise an exception of type: NoSuchElementException if uncommented");
//            String unwrappedString = item.get();
        }

//      A preview of what we will see soon...functional interfaces
//      The ifPresent method returns a void but expects a consumer interface
//      ifPresent(Consumer<? super T> consumer)
//      Consumer is a functional interface and can therefore be used as the assignment
//      target for a lambda expression or method reference.

//      ifPresent()
//      If a value is present, invoke the specified consumer with the value, otherwise do nothing.
        item.ifPresent(System.out::println);
//      System.out::println is an example of a method reference

        Optional<String> comparisonString = Optional.of("Hello");
        boolean theyAreEqual = item.equals(comparisonString);
        System.out.println(theyAreEqual ? "The strings are equal" : "The strings are different");

//      'orElse' examples: Return the value if present, otherwise return other.
//        orElseExample();
//        orElseEmptyExample();

//      For self-study homework
//      'orElseThrow' examples: If a value is present, returns the value, otherwise throws NoSuchElementException.
//      Return a custom supplied Exception: If a value is present, returns the value, otherwise throws an exception produced by the exception supplying function.
//        orElseThrowExample();
//        orElseThrowSuppliedExample();


    }

    private static void orElseThrowSuppliedExample() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
        //   This uses a Java 8 method reference to pass in the exception constructor
    }

    private static void orElseThrowExample() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow();
        //  Introduced in Java 10. It throws a NoSuchElementException
    }

    public static void orElseExample(){
        // create a non-empty Optional
        Optional<Integer> op = Optional.of(2021);

        // print value
        System.out.println("Optional: " + op);
//        From Java 11 onwards, can use isEmpty() to check opposite of isPresent
        System.out.println("Is the optional empty? " + op.isEmpty());

        try {
            // orElse value
            System.out.println("Value by orElse"
                    + "(2022) method: "
                    + op.orElse(2022));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void orElseEmptyExample(){
        // create an empty Optional
        Optional<Integer> op = Optional.empty();

        // print value
        System.out.println("Optional: " + op);
        //        From Java 11 onwards, can use isEmpty() to check opposite of isPresent
        System.out.println("Is the optional empty? " + op.isEmpty());

        try {
            // orElse value
            System.out.println("Value by orElse"
                    + "(2022) method: "
                    + op.orElse(2022));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
