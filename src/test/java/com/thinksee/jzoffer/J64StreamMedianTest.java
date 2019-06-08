package com.thinksee.jzoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class J64StreamMedianTest {
    @Test
    public void testExample() throws Exception{
        Random random = new Random(1000);
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < 51; ++i){
            int tmp = random.nextInt(1000) % (1000 - 10 + 1) + 10;
            J64StreamMedian.insert(tmp);
            arr.add(tmp);
        }
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        System.out.println(arr.get(25));
        System.out.println(J64StreamMedian.getMedian());
    }
}
