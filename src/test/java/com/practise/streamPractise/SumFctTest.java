package com.practise.streamPractise;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

import static org.junit.Assert.assertEquals;


public class SumFctTest {
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
    public void test1() {
        assertEquals(BigInteger.valueOf(80), SumFct.perimeter(BigInteger.valueOf(5)));
    }
    @Test
    public void test2() {
        assertEquals(BigInteger.valueOf(216), SumFct.perimeter(BigInteger.valueOf(7)));
    }
    @Test
    public void test3() {
        assertEquals(BigInteger.valueOf(14098308), SumFct.perimeter(BigInteger.valueOf(30)));
    }
    @Test
    public void test4() {
        BigInteger r = new BigInteger("6002082144827584333104");
        assertEquals(r, SumFct.perimeter(BigInteger.valueOf(100)));
    }
    @Test
    public void test5() {
        BigInteger r = new BigInteger("2362425027542282167538999091770205712168371625660854753765546783141099308400948230006358531927265833165504");
        assertEquals(r, SumFct.perimeter(BigInteger.valueOf(500)));
    }

    @Test
    public void test6() {
        System.out.println("****** Random test ******");
        Random rnd = new Random();
        for (int i = 0; i < 25; i++) {
            int a = Math.round(rnd.nextInt(1000) * (65 - 10) + 10000);
            System.out.println("Perimeter for : " + a);
            assertEquals(SumFctTest.solution(BigInteger.valueOf(a)), SumFct.perimeter(BigInteger.valueOf(a)));
        }
    }

}