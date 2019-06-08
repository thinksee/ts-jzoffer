package com.thinksee.jzoffer;

import org.junit.Test;

public class J31CreatestSumOfSubarraysTest {
    @Test
    public void testExample(){
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        assert J31CreatestSumOfSubarrays.findGeatestSumOfSubarrays(nums) == 18;
    }
}
