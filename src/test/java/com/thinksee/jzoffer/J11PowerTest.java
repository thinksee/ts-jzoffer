package com.thinksee.jzoffer;

import org.junit.Test;

/**
 * @auther thinksee
 * @date 2019/6/18.
 * @since
 */
public class J11PowerTest {
    @Test
    public void testExample(){
        System.out.println(J11Power.power(1.3, -5));
        assert Math.abs(J11Power.power(1.3, -5) - 0.26932907) < 1e-6;
    }
}
