package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-28
 * 写一个函数，输入N，求斐波那契数列的第n项。
 * 0 1 f(n) = f(n-1)+f(n-2)
 */
public class Pro09Fibonacci {
    public static long fibonacci1(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    public static long fibonacci2(int n){
        int[] result = {0, 1};
        if(n < 2){
            return result[n];
        }

        long one = 1;
        long two = 0;
        long three = 0;

    }
}
