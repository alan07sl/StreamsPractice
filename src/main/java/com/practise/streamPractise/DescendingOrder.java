package com.practise.streamPractise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.

 Examples:
 Input: 21445 Output: 54421

 Input: 145263 Output: 654321

 Input: 1254859723 Output: 9875543221
 */
public class DescendingOrder {
    public static int sortDesc(final int num) {
        String numString = String.valueOf(num);

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
}