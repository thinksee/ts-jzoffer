package com.thinksee.jzoffer;

import org.junit.Test;

public class J10NumberOf1InBinaryTest{
    @Test
    public void testExample(){
        // 负数右移会陷入死循环
//        assert J10NumberOf1InBinary.numberOf11(0x80000000) == 1;
        assert J10NumberOf1InBinary.numberOf12(0x80000000) == 1;
    }
}