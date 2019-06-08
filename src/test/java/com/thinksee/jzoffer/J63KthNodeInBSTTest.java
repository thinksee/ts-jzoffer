package com.thinksee.jzoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class J63KthNodeInBSTTest {
    @Test
    public void testExample(){
        J63KthNodeInBST.BSTNode root = null;
        // 1. 插入
        for(Integer value :new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8))) {
            if (null != J63KthNodeInBST.insert(root, value)) {
                System.out.println("insert() error");
                return;
            }
        }
        // 2.遍历
        boolean flag = true;
        for(Integer value : J63KthNodeInBST.traverse(root)){
            if(flag){
                System.out.print(value);
            }else{
                System.out.print(" " + value);
            }
        }
    }
}
