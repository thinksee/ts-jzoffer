package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-28
 * 把一个数组最开始的若干个元素搬到数组的尾部，称之为数组旋转。
 * 如{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class J08MinNumberInRotatedArray {
    public static int getMin(int[] numbers){
        if(numbers == null || numbers.length == 0){
            throw new RuntimeException("the numbers is empty.");
        }
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(numbers[left] < numbers[mid]){
                left = mid + 1;
            }
        }
        return left;
    }
}
