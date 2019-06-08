package com.thinksee.jzoffer;

import org.junit.Test;

public class J04ReplaceBlankTest {
    @Test
    public void testExample(){
        System.out.println("We%20are%20happy.");
        String str = "We are happy.";
        System.out.println(String.valueOf(J04ReplaceBlank.replaceBlank(str.toCharArray())));
    }
}
