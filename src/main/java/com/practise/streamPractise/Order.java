package com.practise.streamPractise;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Your task is to sort a given string. Each word in the String will contain a single number. This number is the position the word should have in the result.

 Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

 If the input String is empty, return an empty String. The words in the input String will only contain valid consecutive numbers.

 For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est"

 your_order("is2 Thi1s T4est 3a")
 [1] "Thi1s is2 3a T4est"s
 */
public class Order {
    public static String order(String words) {
        return Stream.of(words.split(" ")).sorted(Comparator.comparing(
                s -> s.chars().filter(c -> Character.isDigit(c))
                        .findFirst().getAsInt()))
                .collect(Collectors.joining(" "));
    }
}