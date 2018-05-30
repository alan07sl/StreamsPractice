package com.practise.streamPractise;

import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class PINValidatorTest {
    // Reference implementation for random tests
    private static boolean _validatePin(String pin) {
        return pin.matches("^(\\d{4}|\\d{6})$");
    }

    @Test
    public void validPins() {
        assertEquals(true, PINValidator.validatePin("1234"));
        assertEquals(true, PINValidator.validatePin("0000"));
        assertEquals(true, PINValidator.validatePin("1111"));
        assertEquals(true, PINValidator.validatePin("123456"));
        assertEquals(true, PINValidator.validatePin("098765"));
        assertEquals(true, PINValidator.validatePin("000000"));
        assertEquals(true, PINValidator.validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertEquals(false, PINValidator.validatePin("a234"));
        assertEquals(false, PINValidator.validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertEquals(false, PINValidator.validatePin("1"));
        assertEquals(false, PINValidator.validatePin("12"));
        assertEquals(false, PINValidator.validatePin("123"));
        assertEquals(false, PINValidator.validatePin("12345"));
        assertEquals(false, PINValidator.validatePin("1234567"));
        assertEquals(false, PINValidator.validatePin("-1234"));
        assertEquals(false, PINValidator.validatePin("1.234"));
        assertEquals(false, PINValidator.validatePin("00000000"));
    }

    @Test
    public void randomTests() {
        BiFunction<Integer, Integer, Integer> randInt = (a, b) -> (int) (Math.floor(Math.random() * (b - a + 1)) + a);
        Supplier<List<String>> randValidPin = () -> {
            int length = Math.random() < 0.5 ? 4 : 6;
            String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            return IntStream.range(0, length).mapToObj(x -> digits[randInt.apply(0, digits.length - 1)]).collect(Collectors.toList());
        };

        for (int i = 0; i < 40; i++) {
            List<String> pin = randValidPin.get();
            if (Math.random() < 0.5) pin.set(randInt.apply(0, pin.size() - 1), Character.toString((char) (int) randInt.apply(32, 127)));

            assertEquals(_validatePin(String.join("", pin)), PINValidator.validatePin(String.join("", pin)));
        }
    }
}