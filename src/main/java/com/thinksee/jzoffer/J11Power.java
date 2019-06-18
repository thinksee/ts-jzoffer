package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-28
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 */
public class J11Power {
    public static double power(double base, int exponent){
        // special case : base.equals(0.0) and exponent < 0
        if(Math.abs(base - 0.0) < 1e-6 && exponent < 0){
            throw new RuntimeException("Illegal Input.");
        }
        boolean flag = (exponent > 0);
        double result = powerCore(base, Math.abs(exponent));
        if(exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }

    private static double powerCore(double base, int exponent){
        double result = 1.0;
        while(exponent > 0){
            if((exponent & 0x1) == 1){
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }
}
