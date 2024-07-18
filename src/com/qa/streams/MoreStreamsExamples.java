package com.qa.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoreStreamsExamples {

    public static void main(String[] args){
        exampleA();
        exampleB();
        exampleC();
//        exampleD();
//        exampleE();
//        exampleF();
//        exampleG();
//        exampleH();
    }
    public static void exampleA(){
        List<String> elements =
                Stream.of("a", "b", "c", "bb", "db").filter(element -> element.contains("b"))
                        .collect(Collectors.toList());

        System.out.println(elements);

        Optional<String> anyElement = elements.stream().findAny();
        System.out.println(anyElement);

        Optional<String> firstElement = elements.stream().findFirst();
        System.out.println(firstElement);

    }

    public static void exampleB(){
        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1);
        System.out.println(onceModifiedStream);

        List<String> strings = onceModifiedStream.toList();
        System.out.println(strings);
    }

    public static void exampleC() {

        Stream<String> twiceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1).map(element -> element.substring(0, 3));
        System.out.println(twiceModifiedStream);


        List<String> strings = twiceModifiedStream.toList();
        System.out.println(strings);
    }


    public static void exampleD() {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3", "def123", "xyz234");
        List<String> sortedStrings = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().toList();

        System.out.println(sortedStrings);
    }

    public static void exampleE() {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).count();

        System.out.println(size);
    }


    private static void log(String message) {
        System.out.println(message);
    }
    public static void exampleF() {
//        Intermediate operations are lazy. This means that they will be invoked only if it
//        is necessary for the terminal operation execution.

//        There is no terminal operation so the filter() method isn't called
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        Stream<String> stream = list.stream().filter(element -> {
            log("filter() was called");
            return element.contains("2");
        });

    }
    public static void exampleG(){
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");

        Optional<String> stream = list.stream().filter(element -> {
            log("filter() was called");
            return element.contains("2");
        }).map(element -> {
            log("map() was called");
            return element.toUpperCase();
        }).findFirst();

        System.out.println(stream);
        System.out.println(stream.get());
    }
    public static void exampleH(){
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");

        long size = list.stream().map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).skip(2).count();

        System.out.println(size);
    }

    private static void wasCalled() {
        counter++;
        System.out.println(counter);
    }

    private static int counter =0;
}
