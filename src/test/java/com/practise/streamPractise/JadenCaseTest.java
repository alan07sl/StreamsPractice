package com.practise.streamPractise;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class JadenCaseTest {


    JadenCase jadenCase = new JadenCase();

    @Test
    public void test() {
        assertEquals("toJadenCase doesn't return a valide JadenCase String! try again please :)", jadenCase.toJadenCase("most trees are blue"), "Most Trees Are Blue");
    }

    @Test
    public void testNullArg() {
        assertNull("Must return null when the arg is null", jadenCase.toJadenCase(null));
    }

    @Test
    public void testEmptyArg() {
        assertNull("Must return null when the arg is null", jadenCase.toJadenCase(""));
    }

    @Test
    public void test_01() {
        assertEquals(0, jadenCase.sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(51, jadenCase.sortDesc(15));
    }


    @Test
    public void test_03() {
        assertEquals(987654321, jadenCase.sortDesc(123456798));
    }

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, jadenCase.persistence(39));
        assertEquals(0, jadenCase.persistence(4));
        assertEquals(2, jadenCase.persistence(25));
        assertEquals(4, jadenCase.persistence(999));
    }

    @Test
    public void validPins() {
        assertEquals(true, jadenCase.validatePin("1234"));
        assertEquals(true, jadenCase.validatePin("0000"));
        assertEquals(true, jadenCase.validatePin("1111"));
        assertEquals(true, jadenCase.validatePin("123456"));
        assertEquals(true, jadenCase.validatePin("098765"));
        assertEquals(true, jadenCase.validatePin("000000"));
        assertEquals(true, jadenCase.validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertEquals(false, jadenCase.validatePin("a234"));
        assertEquals(false, jadenCase.validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertEquals(false, jadenCase.validatePin("1"));
        assertEquals(false, jadenCase.validatePin("12"));
        assertEquals(false, jadenCase.validatePin("123"));
        assertEquals(false, jadenCase.validatePin("12345"));
        assertEquals(false, jadenCase.validatePin("1234567"));
        assertEquals(false, jadenCase.validatePin("-1234"));
        assertEquals(false, jadenCase.validatePin("1.234"));
        assertEquals(false, jadenCase.validatePin("00000000"));
    }

    @Test
    public void test1() {
        assertThat(jadenCase.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Test
    public void test2() {
        assertThat(jadenCase.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Test
    public void test3() {
        assertThat("Empty input should return empty string", jadenCase.order(""), equalTo(""));
    }

    @Test
    public void sampleTests() {
        assertEquals(Long.valueOf(42L), jadenCase.fold(new Double(384000000)));
        assertEquals(Long.valueOf(0L), jadenCase.fold(new Double(0.00005)));
    }

    @Test
    public void squareDigitstest() {
        assertEquals(811181, jadenCase.squareDigits(9119));
    }




    private static HashMap<BigInteger, BigInteger> cache = new HashMap<BigInteger, BigInteger>();
    private static BigInteger ONE  = BigInteger.ONE;
    private static BigInteger ZERO = BigInteger.ZERO;

    public static BigInteger fib(BigInteger n) {
        if (n.equals(ZERO)) return ZERO;
        if (n.equals(ONE))  return ONE;
        if (cache.containsKey(n)) return cache.get(n);

        // odd
        if (n.testBit(0)) {
            BigInteger n2 = n.shiftRight(1);
            BigInteger n3 = n2.add(ONE);
            BigInteger result = fib(n2).multiply(fib(n2)).add(fib(n3).multiply(fib(n3)));
            cache.put(n, result);
            return result;
        }
        // even
        else {
            BigInteger n2 = n.shiftRight(1);
            BigInteger n3 = n2.subtract(ONE);
            BigInteger result = fib(n2).multiply(fib(n2).add(fib(n3).add(fib(n3))));
            cache.put(n, result);
            return result;
        }
    }

    public static BigInteger solution(BigInteger n) {
        return (fib(n.add(BigInteger.valueOf(3))).subtract(BigInteger.valueOf(1))).multiply(BigInteger.valueOf(4));
    }

    @Test
    public void test1Fct() {
        assertEquals(BigInteger.valueOf(80), jadenCase.perimeter(BigInteger.valueOf(5)));
    }
    @Test
    public void test2Fct() {
        assertEquals(BigInteger.valueOf(216), jadenCase.perimeter(BigInteger.valueOf(7)));
    }
    @Test
    public void test3Fct() {
        assertEquals(BigInteger.valueOf(14098308), jadenCase.perimeter(BigInteger.valueOf(30)));
    }
    @Test
    public void test4Fct() {
        BigInteger r = new BigInteger("6002082144827584333104");
        assertEquals(r, jadenCase.perimeter(BigInteger.valueOf(100)));
    }
    @Test
    public void test5Fct() {
        BigInteger r = new BigInteger("2362425027542282167538999091770205712168371625660854753765546783141099308400948230006358531927265833165504");
        assertEquals(r, jadenCase.perimeter(BigInteger.valueOf(500)));
    }

    @Test
    public void test6Fct() {
        System.out.println("****** Random test ******");
        Random rnd = new Random();
        for (int i = 0; i < 25; i++) {
            int a = Math.round(rnd.nextInt(1000) * (65 - 10) + 10000);
            System.out.println("Perimeter for : " + a);
            assertEquals(solution(BigInteger.valueOf(a)), jadenCase.perimeter(BigInteger.valueOf(a)));
        }
    }
}
