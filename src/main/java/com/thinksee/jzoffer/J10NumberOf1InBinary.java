package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-28
 * 实现一个函数，输入一个整数，输出二进制数中1的个数。
 * 如9看成1001，有2位1。
 */
public class J10NumberOf1InBinary {

    /**
     * 负数(本身)循环会陷入死循环
     * 如0x80000000->0xC0000000->0xE0000000->0xF0000000
     * @param n
     * @return
     */
    public static int numberOf11(int n){
        int count = 0;
        while(n != 0){
            if((n&1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * 采用索引值循环
     * @param n
     * @return
     */
    public static int numberOf12(int n){
        int count = 0;
        int flag = 1 & 0xFFFFFFFF;
        System.out.println((0x80000000) & ( 0xFFFFFFFF));
        while (flag != 0){
            if((n & flag) != 0){
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    public static int numberOf13(int n){
        int count = 0;
        while(n != 0){
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * 输入两个数m和n，计算需要改变m的二进制表示中的多少位才能得到n。
     * @param n
     * @param m
     * @return
     */
    public static int count(int n, int m){
        return numberOf13(n^m);
    }
}
