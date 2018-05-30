package com.practise.streamPractise;

import java.util.stream.Collectors;

/**
 * Welcome. In this kata, you are asked to square every digit of a number.

 For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.

 Note: The function accepts an integer and returns an integer
 */
public class SquareDigit {

    public int squareDigits(int n) {
        return Integer.valueOf(
                String.valueOf(n).chars()
                        .mapToObj(c -> String.valueOf(Character.getNumericValue(c) * Character.getNumericValue(c)))
                        .collect(Collectors.joining()));
    }

}