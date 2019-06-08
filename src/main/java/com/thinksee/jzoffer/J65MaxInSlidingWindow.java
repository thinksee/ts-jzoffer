package com.thinksee.jzoffer;

import java.util.*;

/**
 * @author thinksee
 * @since 2019-5-27
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *
 * {@link Deque}的三种用途：
 * (1) 普通队列(一端进一端出)：{@link Queue} queue = new {@link LinkedList} 或 {@link Deque} = new {@link LinkedList}
 * (2) 双端队列(两端都可进出)：{@link Deque} queue = new {@link LinkedList}
 * (3) 堆栈：{@link Deque} deque = new {@link LinkedList}
 * 其中，Java堆栈中的Stack已经过时了，推荐使用Deque替代Stack使用，此时Deque堆栈操作方法为push(),pop(),peek()
 *
 * 	                       第一个元素 (头部)	                      最后一个元素 (尾部)
 *                      抛出异常	       特殊值	                抛出异常          特殊值
 * 插入	              addFirst(e)	offerFirst(e)	           addLast(e)	offerLast(e)
 * 删除	              removeFirst()	pollFirst()	               removeLast()	pollLast()
 * 检查	                 getFirst()	peekFirst()	               getLast()	peekLast()
 * 其中，特殊值的含义是返回一个null或false或集合中的元素
 *
 * Queue方法	      等效Deque方法
 *  add(e)	      addLast(e)
 * offer(e)	      offerLast(e)
 * remove()	      removeFirst()
 * poll()	      pollFirst()
 * element()	  getFirst()
 * peek()	      peekFirst()
 *
 * offer和add方式，当容量限制时，offer方法通常优选add
 *
 * 堆栈方法	      等效Deque方法
 * push(e)	      addFirst(e)
 * pop()	      removeFirst()
 * peek()	      peekFirst()
 */
public class J65MaxInSlidingWindow {
    /**
     * 1. 初始化首个值为a1，放入双端队列deque中；
     * 2. (值的)准确性
     * 比较当前值ai(i=j+1...n)和aj的大小；
     *   2.1 若aj >= ai，ai可能成为窗口内的最大值，放入双端队列deque队尾中；
     *   2.2 若aj < ai，ai一定是当前窗口的最大值，把aj的值从双端队列队首deque中删除，ak(k = j--) >= ai
     * 3. (值的)时效性
     * 在索引值为i的情况下，使用窗口windowSize大小，需从队首删除索引值index <= i-windowSize的值
     * 在满足2,3的情况下，deque队首的值即为想要的值。
     * @param nums 被统计的数列
     * @param windowSize 窗口大小
     * @return
     */
    static List<Integer> maxInWindows(List<Integer> nums, int windowSize){
        List<Integer> result = new ArrayList<Integer>();
        if(nums.size() >= windowSize && windowSize >= 1){
            Deque<Integer> deque = new LinkedList<Integer>();
            for(int i = 0; i < windowSize; ++i){
                while(!deque.isEmpty() && nums.get(i) > nums.get(deque.peekLast())){
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            for(int i = windowSize; i < nums.size(); ++i){
                result.add(nums.get(deque.peekFirst()));
                while(!deque.isEmpty() && nums.get(i) >= nums.get(deque.peekLast())){
                    deque.pollLast();
                }
                if(!deque.isEmpty() && deque.peekFirst() <= i - windowSize){
                    deque.pollFirst();
                }
                deque.addLast(i);

            }
            result.add(nums.get(deque.peekFirst()));
        }
        return result;
    }

}
