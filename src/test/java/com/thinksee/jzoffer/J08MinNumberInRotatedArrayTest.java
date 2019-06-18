package com.thinksee.jzoffer;

import org.junit.Test;

public class J08MinNumberInRotatedArrayTest {
    @Test
    public void testExample(){
        int[] arr = {1, 0, 1, 1, 1};
        assert J08MinNumberInRotatedArray.getMin1(arr) == 0;
    }
}
