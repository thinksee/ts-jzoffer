package com.thinksee.jzoffer;

import java.util.*;

/**
 * @author thinksee
 * @since 2019-5-28
 * 如何得到一个数据流中的中位数？如果从数据流中读取奇数个数值，那么中位数就是
 * 那么中位数就是所有数值排序之后位于中间的数值。若从数据流中读取出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Pro64StreamMedian {

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    /**
     * 保证最小堆的堆顶值 > 最大堆的堆顶值，
     * 此时的数组长度为奇数，再插入一个数，放入最大堆中，需要考虑条件A；
     * 若此时数组长度为偶数，再插入一个数，放入最小堆中，需要考虑条件B。
     * 所以，在总数组为奇数的情况下，只需要返回最小堆中的数，
     * 反之，返回最大堆中的数。
     * @param num
     */
    static void insert(Integer num){
        if(((maxHeap.size() + minHeap.size()) & 1) == 0){
             /*
             * A 当前值小于最大堆队顶值时，和最大堆堆顶元素对换
             * */
            if(maxHeap.size() > 0 && num < maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }else{
            /*
            * B 当前值大于最小堆堆顶值时，和最小堆堆顶元素对换
            * */
            if(minHeap.size() > 0 && minHeap.peek() < num){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }
    static Integer getMedian() throws Exception{
        int size = maxHeap.size() + minHeap.size();
        if(size == 0){
            throw new Exception("No numbers are available");
        }
        Integer median = 0;
        if((size & 1) == 1){
            median = minHeap.peek();
        }else{
            median = (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }

    public static void main(String[] args) throws Exception{
        Random random = new Random(1000);
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 51; ++i){
            int tmp = random.nextInt(1000) % (1000 - 10 + 1) + 10;
            insert(tmp);
            arr.add(tmp);
        }
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        System.out.println(arr.get(25));
        System.out.println(getMedian());

    }
}
