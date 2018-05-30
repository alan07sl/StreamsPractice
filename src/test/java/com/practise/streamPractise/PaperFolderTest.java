package com.practise.streamPractise;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class PaperFolderTest {

    public static Long solution(Double distance) {
        if (distance < 0)
            return null;
        if (distance < 0.0001)
            return Long.valueOf(0L);
        String str = Double.toString(Math.ceil(Math.log(distance*10000) / Math.log(2)));
        str = str.substring(0, str.indexOf("."));
        Long answer = new Long(str);
        return answer;
    }

    @Test
    public void sampleTests() {
        assertEquals(Long.valueOf(42L), PaperFolder.fold(new Double(384000000)));
        assertEquals(Long.valueOf(0L), PaperFolder.fold(new Double(0.00005)));
    }
    @Test
    public void additionalTests() {
        assertEquals(Long.valueOf(4L), PaperFolder.fold(new Double(0.0016)));
        assertEquals(Long.valueOf(5L), PaperFolder.fold(new Double(0.0032)));
        assertEquals(Long.valueOf(0L), PaperFolder.fold(new Double(0.0000001)));
    }
    @Test
    public void randomTests() {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            Double d = new Double(Math.pow(rand.nextDouble(), (double)(rand.nextInt(20) - 10)));
            String message = "Testing " + d;
            assertEquals(message, PaperFolderTest.solution(d), PaperFolder.fold(d));
        }
    }
    @Test
    public void invalidParameter() {
        assertEquals(null, PaperFolder.fold(new Double("-1")));
    }
}