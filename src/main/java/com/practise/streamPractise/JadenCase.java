package com.practise.streamPractise;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013). Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known for almost always capitalizing every word.

 Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.

 Example:

 Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 Note that the Java version expects a return value of null for an empty string or null.
 */
public class JadenCase {

    public String toJadenCase (String phrase) {
        Optional<String> optPhrase = Optional.ofNullable(phrase);
        if(!optPhrase.isPresent() || phrase.isEmpty()) return null;
        return Stream.of(phrase.split(" ")).map(word -> word.replaceFirst(word.substring(0,1), word.substring(0,1).toUpperCase())).collect(Collectors.joining(" "));
    }

    public static boolean isSquare(int n) {
        return Math.floor(Math.sqrt(n)) == Math.sqrt(n);
    }

    public static String order(String words) {
        return Stream.of(words.split(" ")).sorted(Comparator.comparing(
                s -> s.chars().filter(c -> Character.isDigit(c))
                        .findFirst().getAsInt()))
                .collect(Collectors.joining(" "));
    }

    public static Long fold(Double distance) {
        if(distance < 0) return null;

        Double thickness = 0.0001;
        Long times = 0L;

        while (thickness<distance) {
            thickness = thickness*2;
            times++;
        }

        return times;
    }

    public int squareDigits(int n) {
        return Integer.valueOf(
                String.valueOf(n).chars()
                        .mapToObj(c -> String.valueOf(Character.getNumericValue(c) * Character.getNumericValue(c)))
                        .collect(Collectors.joining()));
    }

    public static BigInteger perimeter(BigInteger n) {
        return BigInteger.valueOf(4L).multiply(Stream.iterate(new BigInteger[]{ BigInteger.ONE, BigInteger.ONE },
                p->new BigInteger[]{ p[1], p[0].add(p[1]) }).limit(n.longValue()+1).map(a -> a[0]).reduce(BigInteger.ZERO, BigInteger::add));
    }
}
