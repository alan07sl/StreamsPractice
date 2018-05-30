package com.practise.streamPractise;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class JadenCase {

    public String toJadenCase (String phrase) {
        Optional<String> optPhrase = Optional.ofNullable(phrase);
        if(!optPhrase.isPresent() || phrase.isEmpty()) return null;
        return Stream.of(phrase.split(" ")).map(word -> word.replaceFirst(word.substring(0,1), word.substring(0,1).toUpperCase())).collect(Collectors.joining(" "));
    }

    public static int sortDesc(final int num) {
        String numString = String.valueOf(num).chars().mapToObj(i -> String.valueOf(Character.getNumericValue(i))).sorted(Comparator.reverseOrder()).collect(Collectors.joining());

        char[] nums = numString.toCharArray();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length / 2; i++)
        {
            char temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }


        return Integer.valueOf(String.valueOf(nums));
    }

    public static int sortDesc2(final int num) {
        return Integer.parseInt(String.valueOf(num)
                .chars()
                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }

    public static int persistence(long n) {

        Boolean oneDigit = Boolean.FALSE;
        Integer reductionsQuantity = 0;

        while (n > 9) {
            n = Long.valueOf(String.valueOf(n).chars().mapToObj(i -> Character.getNumericValue(i)).reduce(1, (a, b) -> a * b));
            reductionsQuantity++;
        }

        return reductionsQuantity;

    }

    public static boolean validatePin(String pin) {
        return pin.chars().allMatch(i -> Character.isDigit(i)) && (pin.length() == 4 || pin.length() == 6);
    }

    public static long findNextSquare(long sq) {
        Double root = Math.sqrt(sq);
        if(Math.floor(root) == root) {
            root++;
            Long longRoot = root.longValue();
            return longRoot * longRoot;
        }
        return -1;
    }

    public static int makeNegative(final int x) {
        if (x > 0) return -x;
        return x;
    }

    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(i -> -i).toArray();
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
