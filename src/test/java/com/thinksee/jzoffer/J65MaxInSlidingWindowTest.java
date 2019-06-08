package com.thinksee.jzoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J65MaxInSlidingWindowTest {
    @Test
    public void testExample(){
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 2, 6, 2, 5, 1));
        System.out.println(J65MaxInSlidingWindow.maxInWindows(nums, 3));
    }
}
