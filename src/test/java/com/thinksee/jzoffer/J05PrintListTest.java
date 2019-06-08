package com.thinksee.jzoffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class J05PrintListTest {
    @Test
    public void testExample(){
        int[] nums = {3,2,5,11,17,31,18,22,45,23};
        J05PrintList.Node head = null;
        head = J05PrintList.preInsert(head, Arrays.stream(nums).boxed().collect(Collectors.toList()));
        J05PrintList.printList(head);
        System.out.println();
        head = null;
        head = J05PrintList.postInsert(head, Arrays.stream(nums).boxed().collect(Collectors.toList()));
        J05PrintList.printList(head);
    }
}
